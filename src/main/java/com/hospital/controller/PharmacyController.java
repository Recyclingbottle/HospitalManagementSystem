package com.hospital.controller;

import com.hospital.dto.DrugDTO;
import com.hospital.service.PharmacyService;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PharmacyController {
    private PharmacyService pharmacyService = new PharmacyService();
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 약품 추가");
            System.out.println("2. 약품 정보 보기");
            System.out.println("3. 약품 조제");
            System.out.println("4. 약국 약품 목록 보기");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            CountDownLatch latch = new CountDownLatch(1);  // 비동기 작업이 완료될 때까지 기다리는 래치

            switch (choice) {
                case 1:
                    executor.submit(new AddDrugTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewDrugInfoTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new DispenseDrugTask(scanner, latch));
                    break;
                case 4:
                    executor.submit(new ViewAllDrugsTask(latch));
                    break;
                case 5:
                    executor.shutdown();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    latch.countDown();  // 잘못된 선택일 경우 래치를 감소시켜 다음 루프로 넘어가게 함
                    break;
            }

            try {
                latch.await();  // 비동기 작업이 완료될 때까지 대기
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("작업이 중단되었습니다.");
            }
        }
    }

    private class AddDrugTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddDrugTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print("약품 이름: ");
                String drugName = scanner.nextLine();
                System.out.print("재고 수량: ");
                int quantity = scanner.nextInt();
                System.out.print("가격: ");
                double price = scanner.nextDouble();
                scanner.nextLine();  
                DrugDTO drug = new DrugDTO(drugName, quantity, price);
                pharmacyService.addDrug(drug);
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }

    private class ViewDrugInfoTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewDrugInfoTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print("약품 이름: ");
                String drugName = scanner.nextLine();
                pharmacyService.viewDrugInfo(drugName);
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }

    private class DispenseDrugTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        DispenseDrugTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print("약품 이름: ");
                String drugName = scanner.nextLine();
                System.out.print("조제 수량: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();  
                pharmacyService.dispenseDrug(drugName, quantity);
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }

    private class ViewAllDrugsTask implements Runnable {
        private CountDownLatch latch;

        ViewAllDrugsTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                pharmacyService.viewAllDrugs();
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }
}
