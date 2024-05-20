package com.hospital.manager;

import com.hospital.dto.BillingDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillingManager {
    private static List<BillingDTO> billings = new ArrayList<>();
    private static final String[] PAYMENT_STATUSES = {"미결제", "결제 완료", "결제 보류"};

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 청구서 생성");
            System.out.println("2. 청구서 정보 보기");
            System.out.println("3. 결제 상태 업데이트");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            switch (choice) {
                case 1:
                    createBilling(scanner);
                    break;
                case 2:
                    viewBillingInfo(scanner);
                    break;
                case 3:
                    updatePaymentStatus(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void createBilling(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        PatientDTO patient = PatientManager.findPatientByName(patientName);
        if (patient == null) {
            System.out.println("해당 이름의 환자가 없습니다.");
            return;
        }

        System.out.print("청구 금액: ");
        double totalAmount = scanner.nextDouble();
        scanner.nextLine();  // Enter key 처리

        int billingId = billings.size() + 1;
        BillingDTO billing = new BillingDTO(billingId, patient, totalAmount, "미결제");
        billings.add(billing);
        System.out.println("청구서가 생성되었습니다.");
        System.out.println("청구 금액: " + billing.getTotalAmount());
        System.out.println("결제 상태: " + billing.getPaymentStatus());
    }

    private static void viewBillingInfo(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        BillingDTO billing = findBillingByPatientName(patientName);
        if (billing != null) {
            System.out.println("청구서 ID: " + billing.getBillingId());
            System.out.println("환자: " + billing.getPatient().getName());
            System.out.println("청구 금액: " + billing.getTotalAmount());
            System.out.println("결제 상태: " + billing.getPaymentStatus());
        } else {
            System.out.println("해당 이름의 청구서가 없습니다.");
        }
    }

    private static void updatePaymentStatus(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        BillingDTO billing = findBillingByPatientName(patientName);
        if (billing != null) {
            System.out.println("새 결제 상태 번호를 선택하세요:");
            for (int i = 0; i < PAYMENT_STATUSES.length; i++) {
                System.out.println((i + 1) + ". " + PAYMENT_STATUSES[i]);
            }
            System.out.print("선택: ");
            int statusChoice;
            try {
                statusChoice = scanner.nextInt();
                scanner.nextLine();  // Enter key 처리
                if (statusChoice < 1 || statusChoice > PAYMENT_STATUSES.length) {
                    throw new IllegalArgumentException("잘못된 번호입니다.");
                }
                String newStatus = PAYMENT_STATUSES[statusChoice - 1];
                billing.setPaymentStatus(newStatus);
                System.out.println("결제 상태가 " + newStatus + "으로 업데이트되었습니다.");
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                scanner.nextLine();  // 잘못된 입력 처리 후 남은 입력 제거
            }
        } else {
            System.out.println("해당 이름의 청구서가 없습니다.");
        }
    }

    private static BillingDTO findBillingByPatientName(String name) {
        for (BillingDTO billing : billings) {
            if (billing.getPatient().getName().equalsIgnoreCase(name)) {
                return billing;
            }
        }
        return null;
    }
}
