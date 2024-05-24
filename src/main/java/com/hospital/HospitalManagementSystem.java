package com.hospital;

import com.hospital.controller.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HospitalManagementSystem {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

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
        ChatController chatController = new ChatController();

        while (true) {
            System.out.println("병원 관리 시스템에 오신 것을 환영합니다.");
            System.out.println("1. 환자 관리");
            System.out.println("2. 의사 관리");
            System.out.println("3. 간호사 관리");
            System.out.println("4. 진료 예약 관리");
            System.out.println("5. 청구 및 결제 관리");
            System.out.println("6. 진료 기록 관리");
            System.out.println("7. 병실 관리");
            System.out.println("8. 약국 관리");
            System.out.println("9. 병원 직원 관리");
            System.out.println("10. 채팅 관리");
            System.out.println("11. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    executorService.submit(() -> patientController.menu(scanner));
                    break;
                case 2:
                    executorService.submit(() -> doctorController.menu(scanner));
                    break;
                case 3:
                    executorService.submit(() -> nurseController.menu(scanner));
                    break;
                case 4:
                    executorService.submit(() -> appointmentController.menu(scanner));
                    break;
                case 5:
                    executorService.submit(() -> billingController.menu(scanner));
                    break;
                case 6:
                    executorService.submit(() -> medicalRecordController.menu(scanner));
                    break;
                case 7:
                    executorService.submit(() -> roomController.menu(scanner));
                    break;
                case 8:
                    executorService.submit(() -> pharmacyController.menu(scanner));
                    break;
                case 9:
                    executorService.submit(() -> crewController.menu(scanner));
                    break;
                case 10:
                    executorService.submit(() -> chatController.menu(scanner));
                    break;
                case 11:
                    executorService.shutdown();
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }
}
