package com.hospital.controller;

import com.hospital.service.PharmacyService;

import java.util.Scanner;

public class PharmacyController {
    private PharmacyService pharmacyService = new PharmacyService();

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

            switch (choice) {
                case 1:
                    addDrug(scanner);
                    break;
                case 2:
                    viewDrugInfo(scanner);
                    break;
                case 3:
                    dispenseDrug(scanner);
                    break;
                case 4:
                    viewAllDrugs(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private void addDrug(Scanner scanner) {
        System.out.print("약품 이름: ");
        String drugName = scanner.nextLine();
        System.out.print("재고 수량: ");
        int quantity = scanner.nextInt();
        System.out.print("가격: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  
        pharmacyService.addDrug(drugName, quantity, price);
    }

    private void viewDrugInfo(Scanner scanner) {
        System.out.print("약품 이름: ");
        String drugName = scanner.nextLine();
        pharmacyService.viewDrugInfo(drugName);
    }

    private void dispenseDrug(Scanner scanner) {
        System.out.print("약품 이름: ");
        String drugName = scanner.nextLine();
        System.out.print("조제 수량: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  
        pharmacyService.dispenseDrug(drugName, quantity);
    }

    private void viewAllDrugs(Scanner scanner) {
        pharmacyService.viewAllDrugs();
    }
}
