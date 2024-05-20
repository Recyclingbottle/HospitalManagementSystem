package com.hospital.manager;

import com.hospital.dto.PharmacyDTO;
import com.hospital.dto.DrugDTO;

import java.util.Scanner;

public class PharmacyManager {
    private static PharmacyDTO pharmacy = new PharmacyDTO();

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 약품 추가");
            System.out.println("2. 약품 정보 보기");
            System.out.println("3. 약품 조제");
            System.out.println("4. 약국 약품 목록 보기");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

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

    private static void addDrug(Scanner scanner) {
        System.out.print("약품 이름: ");
        String drugName = scanner.nextLine();
        System.out.print("재고 수량: ");
        int quantity = scanner.nextInt();
        System.out.print("가격: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Enter key 처리

        DrugDTO drug = new DrugDTO(drugName, quantity, price);
        pharmacy.addDrug(drug);
        System.out.println(drugName + " 약품이 추가되었습니다.");
    }

    private static void viewDrugInfo(Scanner scanner) {
        System.out.print("약품 이름: ");
        String drugName = scanner.nextLine();
        DrugDTO drug = pharmacy.getDrug(drugName);
        if (drug != null) {
            System.out.println("약품 이름: " + drug.getName());
            System.out.println("재고 수량: " + drug.getQuantity());
            System.out.println("가격: " + drug.getPrice());
        } else {
            System.out.println(drugName + " 약품이 존재하지 않습니다.");
        }
    }

    private static void dispenseDrug(Scanner scanner) {
        System.out.print("약품 이름: ");
        String drugName = scanner.nextLine();
        System.out.print("조제 수량: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Enter key 처리

        DrugDTO drug = pharmacy.getDrug(drugName);
        if (drug != null && drug.getQuantity() >= quantity) {
            pharmacy.dispenseDrug(drugName, quantity);
            System.out.println(quantity + "개의 " + drugName + " 약품이 조제되었습니다.");
        } else {
            System.out.println(drugName + " 약품의 재고가 부족하거나 존재하지 않습니다.");
        }
    }

    private static void viewAllDrugs(Scanner scanner) {
        if (pharmacy.getDrugInventory().isEmpty()) {
            System.out.println("약국에 등록된 약품이 없습니다.");
        } else {
            System.out.println("약국 약품 목록:");
            for (DrugDTO drug : pharmacy.getDrugInventory().values()) {
                System.out.println("약품 이름: " + drug.getName());
                System.out.println("재고 수량: " + drug.getQuantity());
                System.out.println("가격: " + drug.getPrice());
                System.out.println("--------------------");
            }
        }
    }
}
