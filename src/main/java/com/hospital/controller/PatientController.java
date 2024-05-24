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
    private PatientService patientService = new PatientService();
    private DoctorService doctorService = new DoctorService();
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 환자 추가");
            System.out.println("2. 환자 정보 보기");
            System.out.println("3. 진료 기록 업데이트");
            System.out.println("4. 현재 복용 약물 업데이트");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            CountDownLatch latch = new CountDownLatch(1);  // 비동기 작업이 완료될 때까지 기다리는 래치

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

    private class AddPatientTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddPatientTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print("환자 ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();  
                System.out.print("환자 이름: ");
                String name = scanner.nextLine();
                System.out.print("환자 나이: ");
                int age = scanner.nextInt();
                scanner.nextLine();  
                System.out.print("연락처: ");
                String contactInfo = scanner.nextLine();
                System.out.print("배정된 의사 이름: ");
                String doctorName = scanner.nextLine();
                DoctorDTO assignedDoctor = doctorService.findDoctorByName(doctorName);
                if (assignedDoctor == null) {
                    System.out.println("해당 이름의 의사가 없습니다.");
                    return;
                }
                PatientDTO patient = new PatientDTO(id, name, age, contactInfo);
                patient.setAssignedDoctor(assignedDoctor);
                patientService.addPatient(patient);
                System.out.println("환자가 추가되었습니다.");
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
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
            try {
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
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
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
            try {
                System.out.print("환자 이름: ");
                String name = scanner.nextLine();
                System.out.print("추가할 진료 기록: ");
                String record = scanner.nextLine();
                patientService.updateMedicalHistory(name, record);
                System.out.println("진료 기록이 업데이트되었습니다.");
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
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
            try {
                System.out.print("환자 이름: ");
                String name = scanner.nextLine();
                System.out.print("추가할 현재 복용 약물: ");
                String medication = scanner.nextLine();
                patientService.updateCurrentMedication(name, medication);
                System.out.println("현재 복용 약물이 업데이트되었습니다.");
            } finally {
                latch.countDown();  // 작업이 완료되면 래치를 감소시킴
            }
        }
    }
}
