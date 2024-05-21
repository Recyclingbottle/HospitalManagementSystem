package com.hospital;

import com.hospital.controller.*;
import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentController appointmentController = new AppointmentController();
        BillingController billingController = new BillingController();
        CrewController crewController = new CrewController();
        DoctorController doctorController = new DoctorController();
        MedicalRecordController medicalRecordController = new MedicalRecordController();
        NurseController nurseController = new NurseController();
        PatientController patientController = new PatientController();
        PharmacyController pharmacyController = new PharmacyController();
        RoomController roomController = new RoomController();

        while (true) {
            System.out.println("┌────────────────────────────────────────────┐");
            System.out.println("│                                            │");
            System.out.println("│    Welcome to the Hospital Management      │");
            System.out.println("│                System                      │");
            System.out.println("│        종합 병원 관리 시스템에 오신 것을       │");
            System.out.println("│                환영합니다                   │");
            System.out.println("│                                            │");
            System.out.println("└────────────────────────────────────────────┘");
            System.out.println("===========================================");
            System.out.println("1. 사용자 관리");
            System.out.println("2. 병원 직원 관리");
            System.out.println("3. 의사 관리");
            System.out.println("4. 간호사 관리");
            System.out.println("5. 환자 관리");
            System.out.println("6. 진료 예약 관리");
            System.out.println("7. 병실 관리");
            System.out.println("8. 약국 관리");
            System.out.println("9. 진료 기록 관리");
            System.out.println("10. 청구서 관리");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    crewController.menu(scanner);
                    break;
                case 2:
                    crewController.menu(scanner);
                    break;
                case 3:
                    doctorController.menu(scanner);
                    break;
                case 4:
                    nurseController.menu(scanner);
                    break;
                case 5:
                    patientController.menu(scanner);
                    break;
                case 6:
                    appointmentController.menu(scanner);
                    break;
                case 7:
                    roomController.menu(scanner);
                    break;
                case 8:
                    pharmacyController.menu(scanner);
                    break;
                case 9:
                    medicalRecordController.menu(scanner);
                    break;
                case 10:
                    billingController.menu(scanner);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }
}
