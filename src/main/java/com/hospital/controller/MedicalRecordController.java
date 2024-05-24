package com.hospital.controller;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;
import com.hospital.service.DoctorService;
import com.hospital.service.MedicalRecordService;
import com.hospital.service.PatientService;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MedicalRecordController {
    private MedicalRecordService medicalRecordService = new MedicalRecordService();
    private PatientService patientService = new PatientService();
    private DoctorService doctorService = new DoctorService();
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 진료 기록 추가");
            System.out.println("2. 진료 기록 정보 보기");
            System.out.println("3. 진료 기록 업데이트");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            CountDownLatch latch = new CountDownLatch(1);  // 비동기 작업이 완료될 때까지 기다리는 래치

            switch (choice) {
                case 1:
                    executor.submit(new AddMedicalRecordTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewMedicalRecordTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new UpdateMedicalRecordTask(scanner, latch));
                    break;
                case 4:
                    executor.shutdown();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    latch.countDown();  // 잘못된 선택일 경우 래치를 감소시켜 다음 루프로 넘어가게 함
                    break;
            }

            try {
                latch.await();  // 비동기 작업이 완료될 때까지 대기
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("작업이 중단되었습니다.");
            }
        }
    }

    private class AddMedicalRecordTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddMedicalRecordTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print("환자 이름: ");
                String patientName = scanner.nextLine();
                PatientDTO patient = patientService.findPatientByName(patientName);
                if (patient == null) {
                    System.out.println("해당 이름의 환자가 없습니다.");
                    return;
                }

                System.out.print("의사 이름: ");
                String doctorName = scanner.nextLine();
                DoctorDTO doctor = doctorService.findDoctorByName(doctorName);
                if (doctor == null) {
                    System.out.println("해당 이름의 의사가 없습니다.");
                    return;
                }

                System.out.print("방문 날짜 (yyyy-MM-dd): ");
                String dateStr = scanner.nextLine();
                Date visitDate;
                try {
                    visitDate = new Date(dateStr);
                } catch (Exception e) {
                    System.out.println("날짜 형식이 잘못되었습니다.");
                    return;
                }

                System.out.print("진단: ");
                String diagnosis = scanner.nextLine();
                System.out.print("치료: ");
                String treatment = scanner.nextLine();

                medicalRecordService.addMedicalRecord(patient, doctor, visitDate, diagnosis, treatment);
                System.out.println("진료 기록이 추가되었습니다.");
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }

    private class ViewMedicalRecordTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewMedicalRecordTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print("진료 기록 ID: ");
                int recordId = scanner.nextInt();
                scanner.nextLine();  
                medicalRecordService.viewMedicalRecord(recordId);
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }

    private class UpdateMedicalRecordTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        UpdateMedicalRecordTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print("진료 기록 ID: ");
                int recordId = scanner.nextInt();
                scanner.nextLine();  

                System.out.print("새 진단: ");
                String newDiagnosis = scanner.nextLine();
                System.out.print("새 치료: ");
                String newTreatment = scanner.nextLine();

                medicalRecordService.updateMedicalRecord(recordId, newDiagnosis, newTreatment);
                System.out.println("진료 기록이 업데이트되었습니다.");
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }
}
