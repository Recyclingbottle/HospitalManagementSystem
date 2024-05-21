package com.hospital.controller;

import com.hospital.service.UserService;

import java.util.Scanner;

public class UserController {
    private UserService userService = new UserService();

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 사용자 추가");
            System.out.println("2. 사용자 정보 보기");
            System.out.println("3. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    viewUserInfo(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private void addUser(Scanner scanner) {
        System.out.print("사용자 이름: ");
        String name = scanner.nextLine();
        System.out.print("사용자 나이: ");
        int age = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("연락처: ");
        String contactInfo = scanner.nextLine();
        userService.addUser(name, age, contactInfo);
    }

    private void viewUserInfo(Scanner scanner) {
        System.out.print("사용자 이름: ");
        String name = scanner.nextLine();
        userService.viewUserInfo(name);
    }
}
