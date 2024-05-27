package com.hospital.controller;

import com.hospital.dto.DrugDTO;
import com.hospital.service.PharmacyService;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PharmacyController {
    private PharmacyService pharmacyService;
    private ExecutorService executor;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
        this.executor = Executors.newFixedThreadPool(5);
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 약품 추가");
            System.out.println("2. 약품 정보 보기");
            System.out.println("3. 약품 조제");
            System.out.println("4. 약국 약품 목록 보기");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            CountDownLatch latch = new CountDownLatch(1);

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
                    latch.countDown();
                    break;
            }

            try {
                latch.await();  // 비동기 작업이 완료될 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
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
            System.out.print("약품 이름: ");
            String drugName = scanner.nextLine();
            System.out.print("재고 수량: ");
            int quantity = scanner.nextInt();
            System.out.print("가격: ");
            double price = scanner.nextDouble();
            scanner.nextLine();  // Enter key 처리
            DrugDTO drug = new DrugDTO(drugName, quantity, price);
            pharmacyService.addDrug(drug);
            latch.countDown();
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
            System.out.print("약품 이름: ");
            String drugName = scanner.nextLine();
            pharmacyService.viewDrugInfo(drugName);
            latch.countDown();
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
            System.out.print("약품 이름: ");
            String drugName = scanner.nextLine();
            System.out.print("조제 수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            pharmacyService.dispenseDrug(drugName, quantity);
            latch.countDown();
        }
    }

    private class ViewAllDrugsTask implements Runnable {
        private CountDownLatch latch;

        ViewAllDrugsTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            pharmacyService.viewAllDrugs();
            latch.countDown();
        }
    }
}
