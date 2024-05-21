package com.hospital.controller;

import com.hospital.dto.BillingDTO;
import com.hospital.dto.PatientDTO;
import com.hospital.service.BillingService;
import com.hospital.service.PatientService;

import java.util.List;
import java.util.Scanner;

public class BillingController {
    private BillingService billingService = new BillingService();
    private PatientService patientService = new PatientService();

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 청구서 생성");
            System.out.println("2. 청구서 정보 보기");
            System.out.println("3. 결제 상태 업데이트");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

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

    private void createBilling(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        PatientDTO patient = patientService.findPatientByName(patientName);
        if (patient == null) {
            System.out.println("해당 이름의 환자가 없습니다.");
            return;
        }

        System.out.print("청구 금액: ");
        double totalAmount = scanner.nextDouble();
        scanner.nextLine();  

        billingService.createBilling(patient, totalAmount);
        System.out.println("청구서가 생성되었습니다.");
    }

    private void viewBillingInfo(Scanner scanner) {
        List<BillingDTO> billings = billingService.getBillings();
        if (billings.isEmpty()) {
            System.out.println("청구서가 없습니다.");
        } else {
            for (BillingDTO billing : billings) {
                System.out.println("청구서 ID: " + billing.getBillingId());
                System.out.println("환자: " + billing.getPatient().getName());
                System.out.println("청구 금액: " + billing.getTotalAmount());
                System.out.println("결제 상태: " + billing.getPaymentStatus());
                System.out.println("--------------------");
            }
        }
    }

    private void updatePaymentStatus(Scanner scanner) {
        System.out.print("청구서 ID: ");
        int billingId = scanner.nextInt();
        scanner.nextLine();  

        System.out.println("새 결제 상태 번호를 선택하세요:");
        for (int i = 0; i < BillingService.PAYMENT_STATUSES.length; i++) {
            System.out.println((i + 1) + ". " + BillingService.PAYMENT_STATUSES[i]);
        }
        System.out.print("선택: ");
        int statusChoice = scanner.nextInt();
        scanner.nextLine();  

        if (statusChoice < 1 || statusChoice > BillingService.PAYMENT_STATUSES.length) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        String newStatus = BillingService.PAYMENT_STATUSES[statusChoice - 1];
        billingService.updatePaymentStatus(billingId, newStatus);
        System.out.println("결제 상태가 업데이트되었습니다.");
    }
}
