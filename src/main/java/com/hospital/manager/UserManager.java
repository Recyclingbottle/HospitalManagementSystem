package com.hospital.manager;

import com.hospital.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private static List<UserDTO> users = new ArrayList<>();

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 사용자 추가");
            System.out.println("2. 사용자 정보 보기");
            System.out.println("3. 사용자 목록 보기");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    viewUserInfo(scanner);
                    break;
                case 3:
                    viewAllUsers();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addUser(Scanner scanner) {
        System.out.print("사용자 이름: ");
        String name = scanner.nextLine();
        System.out.print("사용자 나이: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Enter key 처리
        System.out.print("연락처: ");
        String contactInfo = scanner.nextLine();
        UserDTO user = new UserDTO(name, age, contactInfo);
        users.add(user);
        System.out.println("사용자가 추가되었습니다.");
    }

    private static void viewUserInfo(Scanner scanner) {
        System.out.print("사용자 이름: ");
        String name = scanner.nextLine();
        UserDTO user = findUserByName(name);
        if (user != null) {
            System.out.println("이름: " + user.getName());
            System.out.println("나이: " + user.getAge());
            System.out.println("연락처: " + user.getContactInfo());
        } else {
            System.out.println("해당 이름의 사용자가 없습니다.");
        }
    }

    private static void viewAllUsers() {
        if (users.isEmpty()) {
            System.out.println("등록된 사용자가 없습니다.");
        } else {
            for (UserDTO user : users) {
                System.out.println("이름: " + user.getName());
                System.out.println("나이: " + user.getAge());
                System.out.println("연락처: " + user.getContactInfo());
                System.out.println("--------------------");
            }
        }
    }

    public static UserDTO findUserByName(String name) {
        for (UserDTO user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
}
