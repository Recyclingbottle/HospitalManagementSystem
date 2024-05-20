package com.hospital;

import com.hospital.manager.*;
import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserManager userManager = new UserManager();
        CrewManager crewManager = new CrewManager();
        DoctorManager doctorManager = new DoctorManager();
        NurseManager nurseManager = new NurseManager();
        PatientManager patientManager = new PatientManager();
        AppointmentManager appointmentManager = new AppointmentManager();
        RoomManager roomManager = new RoomManager();
        PharmacyManager pharmacyManager = new PharmacyManager();
        MedicalRecordManager medicalRecordManager = new MedicalRecordManager();
        BillingManager billingManager = new BillingManager();

        while (true) {
            System.out.println("┌─────────────────────────────────────────────┐");
            System.out.println("│                                             │");
            System.out.println("│  ==========================================  │");
            System.out.println("│            Hospital Management System        │");
            System.out.println("│                                             │");
            System.out.println("│    종합 병원 관리 시스템에 오신 것을 환영합니다    │");
            System.out.println("│                                             │");
            System.out.println("│  ==========================================  │");
            System.out.println("│                                             │");
            System.out.println("└─────────────────────────────────────────────┘");
            System.out.println("===============================================");
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
            scanner.nextLine();  // Enter key 처리

            switch (choice) {
                case 1:
                    userManager.menu(scanner);
                    break;
                case 2:
                    crewManager.menu(scanner);
                    break;
                case 3:
                    doctorManager.menu(scanner);
                    break;
                case 4:
                    nurseManager.menu(scanner);
                    break;
                case 5:
                    patientManager.menu(scanner);
                    break;
                case 6:
                    appointmentManager.menu(scanner);
                    break;
                case 7:
                    roomManager.menu(scanner);
                    break;
                case 8:
                    pharmacyManager.menu(scanner);
                    break;
                case 9:
                    medicalRecordManager.menu(scanner);
                    break;
                case 10:
                    billingManager.menu(scanner);
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
