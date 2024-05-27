package com.hospital.controller;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DoctorController {
    private DoctorService doctorService;
    private PatientService patientService;
    private ExecutorService executor;

    public DoctorController(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.executor = Executors.newFixedThreadPool(5);
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 의사 추가");
            System.out.println("2. 의사 정보 보기");
            System.out.println("3. 의사 배정 환자 보기");
            System.out.println("4. 환자 추가");
            System.out.println("5. 환자 제거");
            System.out.println("6. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executor.submit(new AddDoctorTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewDoctorInfoTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new ViewAssignedPatientsTask(scanner, latch));
                    break;
                case 4:
                    executor.submit(new AddPatientToDoctorTask(scanner, latch));
                    break;
                case 5:
                    executor.submit(new RemovePatientFromDoctorTask(scanner, latch));
                    break;
                case 6:
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

    private class AddDoctorTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddDoctorTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("의사 이름: ");
            String name = scanner.nextLine();
            System.out.print("의사 나이: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            System.out.print("연락처: ");
            String contactInfo = scanner.nextLine();
            System.out.print("근무 상태 (true/false): ");
            boolean isOnDuty = scanner.nextBoolean();
            System.out.print("월급: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();  // Enter key 처리
            System.out.print("전문 분야: ");
            String specialty = scanner.nextLine();
            DoctorDTO doctor = new DoctorDTO(name, age, contactInfo, isOnDuty, salary, specialty);
            doctorService.addDoctor(doctor);
            latch.countDown();
        }
    }

    private class ViewDoctorInfoTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewDoctorInfoTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("의사 이름: ");
            String name = scanner.nextLine();
            DoctorDTO doctor = doctorService.findDoctorByName(name);
            if (doctor != null) {
                System.out.println("이름: " + doctor.getName());
                System.out.println("나이: " + doctor.getAge());
                System.out.println("연락처: " + doctor.getContactInfo());
                System.out.println("근무 상태: " + (doctor.isOnDuty() ? "출근 중" : "퇴근 중"));
                System.out.println("월급: " + doctor.getSalary());
                System.out.println("전문 분야: " + doctor.getSpecialty());
            } else {
                System.out.println("해당 이름의 의사가 없습니다.");
            }
            latch.countDown();
        }
    }

    private class ViewAssignedPatientsTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewAssignedPatientsTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("의사 이름: ");
            String name = scanner.nextLine();
            DoctorDTO doctor = doctorService.findDoctorByName(name);
            if (doctor != null) {
                List<PatientDTO> patients = doctor.getAssignedPatients();
                if (patients.isEmpty()) {
                    System.out.println("배정된 환자가 없습니다.");
                } else {
                    System.out.println("배정된 환자 목록:");
                    for (PatientDTO patient : patients) {
                        System.out.println("- " + patient.getName());
                    }
                }
            } else {
                System.out.println("해당 이름의 의사가 없습니다.");
            }
            latch.countDown();
        }
    }

    private class AddPatientToDoctorTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddPatientToDoctorTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("의사 이름: ");
            String doctorName = scanner.nextLine();
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            PatientDTO patient = patientService.findPatientByName(patientName);
            if (patient != null) {
                doctorService.addPatientToDoctor(doctorName, patient);
            } else {
                System.out.println("해당 이름의 환자가 없습니다.");
            }
            latch.countDown();
        }
    }

    private class RemovePatientFromDoctorTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        RemovePatientFromDoctorTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("의사 이름: ");
            String doctorName = scanner.nextLine();
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            PatientDTO patient = patientService.findPatientByName(patientName);
            if (patient != null) {
                doctorService.removePatientFromDoctor(doctorName, patient);
            } else {
                System.out.println("해당 이름의 환자가 없습니다.");
            }
            latch.countDown();
        }
    }
}
