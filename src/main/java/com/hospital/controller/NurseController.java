package com.hospital.controller;

import com.hospital.dto.NurseDTO;
import com.hospital.service.NurseService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NurseController {
    private NurseService nurseService;
    private ExecutorService executor;

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
        this.executor = Executors.newFixedThreadPool(5);
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 간호사 추가");
            System.out.println("2. 간호사 정보 보기");
            System.out.println("3. 배정된 병동 보기");
            System.out.println("4. 병동 배정");
            System.out.println("5. 병동 해제");
            System.out.println("6. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executor.submit(new AddNurseTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewNurseInfoTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new ViewAssignedWardsTask(scanner, latch));
                    break;
                case 4:
                    executor.submit(new AssignWardToNurseTask(scanner, latch));
                    break;
                case 5:
                    executor.submit(new RemoveWardFromNurseTask(scanner, latch));
                    break;
                case 6:
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

    private class AddNurseTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddNurseTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("간호사 이름: ");
            String name = scanner.nextLine();
            System.out.print("간호사 나이: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            System.out.print("연락처: ");
            String contactInfo = scanner.nextLine();
            System.out.print("근무 상태 (true/false): ");
            boolean isOnDuty = scanner.nextBoolean();
            System.out.print("월급: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();  // Enter key 처리
            NurseDTO nurse = new NurseDTO(name, age, contactInfo, isOnDuty, salary);
            nurseService.addNurse(nurse);
            latch.countDown();
        }
    }

    private class ViewNurseInfoTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewNurseInfoTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("간호사 이름: ");
            String name = scanner.nextLine();
            NurseDTO nurse = nurseService.findNurseByName(name);
            if (nurse != null) {
                System.out.println("이름: " + nurse.getName());
                System.out.println("나이: " + nurse.getAge());
                System.out.println("연락처: " + nurse.getContactInfo());
                System.out.println("근무 상태: " + (nurse.isOnDuty() ? "출근 중" : "퇴근 중"));
                System.out.println("월급: " + nurse.getSalary());
                System.out.println("배정된 병동: " + nurse.getAssignedWards());
            } else {
                System.out.println("해당 이름의 간호사가 없습니다.");
            }
            latch.countDown();
        }
    }

    private class ViewAssignedWardsTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewAssignedWardsTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("간호사 이름: ");
            String name = scanner.nextLine();
            NurseDTO nurse = nurseService.findNurseByName(name);
            if (nurse != null) {
                List<String> wards = nurse.getAssignedWards();
                if (wards.isEmpty()) {
                    System.out.println("배정된 병동이 없습니다.");
                } else {
                    System.out.println("배정된 병동 목록:");
                    for (String ward : wards) {
                        System.out.println("- " + ward);
                    }
                }
            } else {
                System.out.println("해당 이름의 간호사가 없습니다.");
            }
            latch.countDown();
        }
    }

    private class AssignWardToNurseTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AssignWardToNurseTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("간호사 이름: ");
            String nurseName = scanner.nextLine();
            System.out.print("병동 이름: ");
            String wardName = scanner.nextLine();
            nurseService.assignWardToNurse(nurseName, wardName);
            latch.countDown();
        }
    }

    private class RemoveWardFromNurseTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        RemoveWardFromNurseTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("간호사 이름: ");
            String nurseName = scanner.nextLine();
            System.out.print("병동 이름: ");
            String wardName = scanner.nextLine();
            nurseService.removeWardFromNurse(nurseName, wardName);
            latch.countDown();
        }
    }
}
