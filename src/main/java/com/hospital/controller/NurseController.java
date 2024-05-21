package com.hospital.controller;

import com.hospital.dto.NurseDTO;
import com.hospital.service.NurseService;

import java.util.List;
import java.util.Scanner;

public class NurseController {
    private NurseService nurseService = new NurseService();

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
            scanner.nextLine();  

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
                    assignWardToNurse(scanner);
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

    private void addNurse(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String name = scanner.nextLine();
        System.out.print("간호사 나이: ");
        int age = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("연락처: ");
        String contactInfo = scanner.nextLine();
        System.out.print("근무 상태 (true/false): ");
        boolean isOnDuty = scanner.nextBoolean();
        System.out.print("월급: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  
        NurseDTO nurse = new NurseDTO(name, age, contactInfo, isOnDuty, salary);
        nurseService.addNurse(nurse);
        System.out.println("간호사가 추가되었습니다.");
    }

    private void viewNurseInfo(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String name = scanner.nextLine();
        NurseDTO nurse = nurseService.findNurseByName(name);
        if (nurse != null) {
            System.out.println("이름: " + nurse.getName());
            System.out.println("나이: " + nurse.getAge());
            System.out.println("연락처: " + nurse.getContactInfo());
            System.out.println("근무 상태: " + (nurse.isOnDuty() ? "출근 중" : "퇴근 중"));
            System.out.println("월급: " + nurse.getSalary());
            viewAssignedWards(nurse);
        } else {
            System.out.println("해당 이름의 간호사가 없습니다.");
        }
    }

    private void viewAssignedWards(NurseDTO nurse) {
        List<String> wards = nurse.getAssignedWards();
        if (wards.isEmpty()) {
            System.out.println("배정된 병동이 없습니다.");
        } else {
            System.out.println("배정된 병동 목록:");
            for (String ward : wards) {
                System.out.println("- " + ward);
            }
        }
    }

    private void viewAssignedWards(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String name = scanner.nextLine();
        NurseDTO nurse = nurseService.findNurseByName(name);
        if (nurse != null) {
            viewAssignedWards(nurse);
        } else {
            System.out.println("해당 이름의 간호사가 없습니다.");
        }
    }

    private void assignWardToNurse(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String nurseName = scanner.nextLine();
        System.out.print("병동 이름: ");
        String wardName = scanner.nextLine();
        nurseService.assignWard(nurseName, wardName);
        System.out.println("병동이 배정되었습니다.");
    }

    private void removeWardFromNurse(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String nurseName = scanner.nextLine();
        System.out.print("병동 이름: ");
        String wardName = scanner.nextLine();
        nurseService.removeWard(nurseName, wardName);
        System.out.println("병동이 해제되었습니다.");
    }
}
