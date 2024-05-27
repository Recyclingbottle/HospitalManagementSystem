package com.hospital;

import com.hospital.controller.*;
import com.hospital.service.*;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HospitalManagementSystem {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 단일 서비스 인스턴스를 생성
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        NurseService nurseService = new NurseService();
        AppointmentService appointmentService = new AppointmentService();
        BillingService billingService = new BillingService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        RoomService roomService = new RoomService();
        PharmacyService pharmacyService = new PharmacyService();
        CrewService crewService = new CrewService();
        ChatService chatService = new ChatService();

        // 서비스 인스턴스를 각 컨트롤러에 전달
        AppointmentController appointmentController = new AppointmentController(appointmentService, patientService, doctorService);
        BillingController billingController = new BillingController(billingService, patientService);
        CrewController crewController = new CrewController(crewService);
        DoctorController doctorController = new DoctorController(doctorService, patientService);
        MedicalRecordController medicalRecordController = new MedicalRecordController(medicalRecordService, patientService, doctorService);
        NurseController nurseController = new NurseController(nurseService);
        PatientController patientController = new PatientController(patientService, doctorService);
        PharmacyController pharmacyController = new PharmacyController(pharmacyService);
        RoomController roomController = new RoomController(roomService);
        ChatController chatController = new ChatController(chatService);

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
            scanner.nextLine();  // Enter key 처리

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executorService.submit(() -> {
                        try {
                            patientController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 2:
                    executorService.submit(() -> {
                        try {
                            doctorController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 3:
                    executorService.submit(() -> {
                        try {
                            nurseController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 4:
                    executorService.submit(() -> {
                        try {
                            appointmentController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 5:
                    executorService.submit(() -> {
                        try {
                            billingController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 6:
                    executorService.submit(() -> {
                        try {
                            medicalRecordController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 7:
                    executorService.submit(() -> {
                        try {
                            roomController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 8:
                    executorService.submit(() -> {
                        try {
                            pharmacyController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 9:
                    executorService.submit(() -> {
                        try {
                            crewController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 10:
                    executorService.submit(() -> {
                        try {
                            chatController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 11:
                    executorService.shutdown();
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    latch.countDown();
                    break;
            }

            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("메뉴 대기 중 인터럽트 발생.");
            }
        }
    }
}
