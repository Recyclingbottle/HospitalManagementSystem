package com.hospital.controller;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;
import com.hospital.service.PatientService;
import com.hospital.service.DoctorService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PatientController {
    private PatientService patientService;
    private DoctorService doctorService;
    private ExecutorService executor;

    public PatientController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.executor = Executors.newFixedThreadPool(5);
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 환자 추가");
            System.out.println("2. 환자 정보 보기");
            System.out.println("3. 진료 기록 업데이트");
            System.out.println("4. 현재 복용 약물 업데이트");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executor.submit(new AddPatientTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewPatientInfoTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new UpdateMedicalHistoryTask(scanner, latch));
                    break;
                case 4:
                    executor.submit(new UpdateCurrentMedicationTask(scanner, latch));
                    break;
                case 5:
                    executor.shutdown();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    latch.countDown();
                    break;
            }

            try {
                latch.await();  // 비동기 작업이 완료될 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class AddPatientTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddPatientTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("환자 ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            System.out.print("환자 이름: ");
            String name = scanner.nextLine();
            System.out.print("환자 나이: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            System.out.print("연락처: ");
            String contactInfo = scanner.nextLine();
            System.out.print("배정된 의사 이름: ");
            String doctorName = scanner.nextLine();
            DoctorDTO assignedDoctor = doctorService.findDoctorByName(doctorName);
            if (assignedDoctor == null) {
                System.out.println("해당 이름의 의사가 없습니다.");
                latch.countDown();
                return;
            }
            PatientDTO patient = new PatientDTO(id, name, age, contactInfo);
            patient.setAssignedDoctor(assignedDoctor);
            patientService.addPatient(patient);
            latch.countDown();
        }
    }

    private class ViewPatientInfoTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewPatientInfoTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("환자 이름: ");
            String name = scanner.nextLine();
            PatientDTO patient = patientService.findPatientByName(name);
            if (patient != null) {
                System.out.println("이름: " + patient.getName());
                System.out.println("나이: " + patient.getAge());
                System.out.println("연락처: " + patient.getContactInfo());
                if (patient.getAssignedDoctor() != null) {
                    System.out.println("배정된 의사: " + patient.getAssignedDoctor().getName());
                }
                System.out.println("진료 기록: " + patient.getMedicalHistory());
                System.out.println("현재 복용 약물: " + patient.getCurrentMedication());
            } else {
                System.out.println("해당 이름의 환자가 없습니다.");
            }
            latch.countDown();
        }
    }

    private class UpdateMedicalHistoryTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        UpdateMedicalHistoryTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("환자 이름: ");
            String name = scanner.nextLine();
            System.out.print("추가할 진료 기록: ");
            String record = scanner.nextLine();
            patientService.updateMedicalHistory(name, record);
            latch.countDown();
        }
    }

    private class UpdateCurrentMedicationTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        UpdateCurrentMedicationTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("환자 이름: ");
            String name = scanner.nextLine();
            System.out.print("추가할 현재 복용 약물: ");
            String medication = scanner.nextLine();
            patientService.updateCurrentMedication(name, medication);
            latch.countDown();
        }
    }
}
