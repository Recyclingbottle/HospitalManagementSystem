package com.hospital.controller;

import com.hospital.dto.UserDTO;
import com.hospital.service.UserService;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserController {
    private UserService userService;
    private ExecutorService executor;

    public UserController(UserService userService) {
        this.userService = userService;
        this.executor = Executors.newFixedThreadPool(5);
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 사용자 추가");
            System.out.println("2. 사용자 정보 보기");
            System.out.println("3. 사용자 리스트 보기");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executor.submit(new AddUserTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewUserInfoTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new ViewAllUsersTask(latch));
                    break;
                case 4:
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

    private class AddUserTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddUserTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("사용자 이름: ");
            String name = scanner.nextLine();
            System.out.print("사용자 나이: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            System.out.print("연락처: ");
            String contactInfo = scanner.nextLine();
            UserDTO user = new UserDTO(name, age, contactInfo);
            userService.addUser(user);
            latch.countDown();
        }
    }

    private class ViewUserInfoTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewUserInfoTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("사용자 이름: ");
            String name = scanner.nextLine();
            UserDTO user = userService.findUserByName(name);
            if (user != null) {
                System.out.println("이름: " + user.getName());
                System.out.println("나이: " + user.getAge());
                System.out.println("연락처: " + user.getContactInfo());
            } else {
                System.out.println("해당 이름의 사용자가 없습니다.");
            }
            latch.countDown();
        }
    }

    private class ViewAllUsersTask implements Runnable {
        private CountDownLatch latch;

        ViewAllUsersTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            for (UserDTO user : userService.getAllUsers()) {
                System.out.println("이름: " + user.getName() + ", 나이: " + user.getAge() + ", 연락처: " + user.getContactInfo());
            }
            latch.countDown();
        }
    }
}
