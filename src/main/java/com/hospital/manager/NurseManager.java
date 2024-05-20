package com.hospital.manager;

import com.hospital.dto.NurseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseManager {
    private static List<NurseDTO> nurses = new ArrayList<>();

    public static void menu(Scanner scanner) {
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

            switch (choice) {
                case 1:
                    addNurse(scanner);
                    break;
                case 2:
                    viewNurseInfo(scanner);
                    break;
                case 3:
                    viewAssignedWards(scanner);
                    break;
                case 4:
                    addWardToNurse(scanner);
                    break;
                case 5:
                    removeWardFromNurse(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addNurse(Scanner scanner) {
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
        nurses.add(nurse);
        System.out.println("간호사가 추가되었습니다.");
    }

    private static void viewNurseInfo(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String name = scanner.nextLine();
        NurseDTO nurse = findNurseByName(name);
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
    }

    private static void viewAssignedWards(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String name = scanner.nextLine();
        NurseDTO nurse = findNurseByName(name);
        if (nurse != null) {
            System.out.println("배정된 병동: " + nurse.getAssignedWards());
        } else {
            System.out.println("해당 이름의 간호사가 없습니다.");
        }
    }

    private static void addWardToNurse(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String nurseName = scanner.nextLine();
        NurseDTO nurse = findNurseByName(nurseName);
        if (nurse == null) {
            System.out.println("해당 이름의 간호사가 없습니다.");
            return;
        }
        System.out.print("병동 이름: ");
        String wardName = scanner.nextLine();
        nurse.addWard(wardName);
        System.out.println("병동이 배정되었습니다.");
    }

    private static void removeWardFromNurse(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String nurseName = scanner.nextLine();
        NurseDTO nurse = findNurseByName(nurseName);
        if (nurse == null) {
            System.out.println("해당 이름의 간호사가 없습니다.");
            return;
        }
        System.out.print("병동 이름: ");
        String wardName = scanner.nextLine();
        nurse.removeWard(wardName);
        System.out.println("병동이 해제되었습니다.");
    }

    public static NurseDTO findNurseByName(String name) {
        for (NurseDTO nurse : nurses) {
            if (nurse.getName().equalsIgnoreCase(name)) {
                return nurse;
            }
        }
        return null;
    }
}
