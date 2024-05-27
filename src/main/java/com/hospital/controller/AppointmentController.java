package com.hospital.controller;

import com.hospital.dto.AppointmentDTO;
import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;
import com.hospital.service.AppointmentService;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppointmentController {
    private AppointmentService appointmentService;
    private PatientService patientService;
    private DoctorService doctorService;
    private ExecutorService executor;

    public AppointmentController(AppointmentService appointmentService, PatientService patientService, DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.executor = Executors.newFixedThreadPool(5);
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 진료 예약 추가");
            System.out.println("2. 진료 예약 정보 보기");
            System.out.println("3. 진료 예약 업데이트");
            System.out.println("4. 진료 예약 취소");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executor.submit(new AddAppointmentTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewAppointmentsTask(latch));
                    break;
                case 3:
                    executor.submit(new UpdateAppointmentTask(scanner, latch));
                    break;
                case 4:
                    executor.submit(new CancelAppointmentTask(scanner, latch));
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

    private class AddAppointmentTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddAppointmentTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            PatientDTO patient = patientService.findPatientByName(patientName);
            if (patient == null) {
                System.out.println("해당 이름의 환자가 없습니다.");
                latch.countDown();
                return;
            }

            System.out.print("의사 이름: ");
            String doctorName = scanner.nextLine();
            DoctorDTO doctor = doctorService.findDoctorByName(doctorName);
            if (doctor == null) {
                System.out.println("해당 이름의 의사가 없습니다.");
                latch.countDown();
                return;
            }

            System.out.print("예약 날짜 (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            Date appointmentDate;
            try {
                appointmentDate = new Date(dateStr);
            } catch (Exception e) {
                System.out.println("날짜 형식이 잘못되었습니다.");
                latch.countDown();
                return;
            }

            System.out.print("예약 시간 (HH:mm): ");
            String appointmentTime = scanner.nextLine();
            System.out.print("상태: ");
            String status = scanner.nextLine();

            appointmentService.addAppointment(patient, doctor, appointmentDate, appointmentTime, status);
            System.out.println("진료 예약이 추가되었습니다.");
            latch.countDown();
        }
    }

    private class ViewAppointmentsTask implements Runnable {
        private CountDownLatch latch;

        ViewAppointmentsTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            List<AppointmentDTO> appointments = appointmentService.getAppointments();
            if (appointments.isEmpty()) {
                System.out.println("진료 예약이 없습니다.");
            } else {
                for (AppointmentDTO appointment : appointments) {
                    System.out.println("예약 ID: " + appointment.getAppointmentId());
                    System.out.println("환자: " + appointment.getPatient().getName());
                    System.out.println("의사: " + appointment.getDoctor().getName());
                    System.out.println("날짜: " + appointment.getAppointmentDate());
                    System.out.println("시간: " + appointment.getAppointmentTime());
                    System.out.println("상태: " + appointment.getStatus());
                    System.out.println("--------------------");
                }
            }
            latch.countDown();
        }
    }

    private class UpdateAppointmentTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        UpdateAppointmentTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("예약 ID: ");
            int appointmentId = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            System.out.print("새 예약 날짜 (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            Date newDate;
            try {
                newDate = new Date(dateStr);
            } catch (Exception e) {
                System.out.println("날짜 형식이 잘못되었습니다.");
                latch.countDown();
                return;
            }

            System.out.print("새 예약 시간 (HH:mm): ");
            String newTime = scanner.nextLine();

            appointmentService.updateAppointment(appointmentId, newDate, newTime);
            System.out.println("예약이 업데이트되었습니다.");
            latch.countDown();
        }
    }

    private class CancelAppointmentTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        CancelAppointmentTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("예약 ID: ");
            int appointmentId = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            appointmentService.cancelAppointment(appointmentId);
            System.out.println("예약이 취소되었습니다.");
            latch.countDown();
        }
    }
}
