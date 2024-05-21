package com.hospital.controller;

import com.hospital.dto.CrewDTO;
import com.hospital.service.CrewService;

import java.util.List;
import java.util.Scanner;

public class CrewController {
    private CrewService crewService = new CrewService();

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 병원 직원 추가");
            System.out.println("2. 병원 직원 정보 보기");
            System.out.println("3. 병원 직원 리스트 보기");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addCrewMember(scanner);
                    break;
                case 2:
                    viewCrewInfo(scanner);
                    break;
                case 3:
                    viewAllCrewMembers();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private void addCrewMember(Scanner scanner) {
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
        crewService.addCrewMember(name, age, contactInfo, isOnDuty, salary);
        System.out.println("병원 직원이 추가되었습니다.");
    }

    private void viewCrewInfo(Scanner scanner) {
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
    }

    private void viewAllCrewMembers() {
        List<CrewDTO> crewMembers = crewService.getAllCrewMembers();
        if (crewMembers.isEmpty()) {
            System.out.println("등록된 직원이 없습니다.");
        } else {
            for (CrewDTO crew : crewMembers) {
                System.out.println("이름: " + crew.getName());
                System.out.println("나이: " + crew.getAge());
                System.out.println("연락처: " + crew.getContactInfo());
                System.out.println("근무 상태: " + (crew.isOnDuty() ? "출근 중" : "퇴근 중"));
                System.out.println("월급: " + crew.getSalary());
                System.out.println("--------------------");
            }
        }
    }
}
