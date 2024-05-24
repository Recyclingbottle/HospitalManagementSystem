package com.hospital.controller;

import com.hospital.dto.CrewDTO;
import com.hospital.service.CrewService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CrewController {
    private CrewService crewService = new CrewService();
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 병원 직원 추가");
            System.out.println("2. 병원 직원 정보 보기");
            System.out.println("3. 병원 직원 리스트 보기");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            CountDownLatch latch = new CountDownLatch(1);  // 비동기 작업이 완료될 때까지 기다리는 래치

            switch (choice) {
                case 1:
                    executor.submit(new AddCrewMemberTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewCrewInfoTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new ViewAllCrewMembersTask(latch));
                    break;
                case 4:
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

    private class AddCrewMemberTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddCrewMemberTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print("직원 이름: ");
                String name = scanner.nextLine();
                System.out.print("직원 나이: ");
                int age = scanner.nextInt();
                scanner.nextLine();  
                System.out.print("연락처: ");
                String contactInfo = scanner.nextLine();
                System.out.print("근무 상태 (true/false): ");
                boolean isOnDuty = scanner.nextBoolean();
                System.out.print("월급: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();  
                CrewDTO crewMember = new CrewDTO(name, age, contactInfo, isOnDuty, salary);
                crewService.addCrewMember(crewMember);
                System.out.println("병원 직원이 추가되었습니다.");
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }

    private class ViewCrewInfoTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewCrewInfoTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print("직원 이름: ");
                String name = scanner.nextLine();
                CrewDTO crewMember = crewService.findCrewByName(name);
                if (crewMember != null) {
                    System.out.println("이름: " + crewMember.getName());
                    System.out.println("나이: " + crewMember.getAge());
                    System.out.println("연락처: " + crewMember.getContactInfo());
                    System.out.println("근무 상태: " + (crewMember.isOnDuty() ? "출근 중" : "퇴근 중"));
                    System.out.println("월급: " + crewMember.getSalary());
                } else {
                    System.out.println("해당 이름의 직원이 없습니다.");
                }
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }

    private class ViewAllCrewMembersTask implements Runnable {
        private CountDownLatch latch;

        ViewAllCrewMembersTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                List<CrewDTO> crewMembers = crewService.getAllCrewMembers();
                if (crewMembers.isEmpty()) {
                    System.out.println("등록된 직원이 없습니다.");
                } else {
                    for (CrewDTO crewMember : crewMembers) {
                        System.out.println("이름: " + crewMember.getName() + ", 나이: " + crewMember.getAge() + ", 연락처: " + crewMember.getContactInfo() + ", 근무 상태: " + (crewMember.isOnDuty() ? "출근 중" : "퇴근 중") + ", 월급: " + crewMember.getSalary());
                        System.out.println("--------------------");
                    }
                }
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }
}
