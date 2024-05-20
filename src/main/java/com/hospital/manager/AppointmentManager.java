package com.hospital.manager;

import com.hospital.dto.AppointmentDTO;
import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AppointmentManager {
    private List<AppointmentDTO> appointments;

    public AppointmentManager() {
        this.appointments = new ArrayList<>();
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

            switch (choice) {
                case 1:
                    addAppointment(scanner);
                    break;
                case 2:
                    viewAppointmentInfo(scanner);
                    break;
                case 3:
                    updateAppointment(scanner);
                    break;
                case 4:
                    cancelAppointment(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private void addAppointment(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        PatientDTO patient = PatientManager.findPatientByName(patientName);
        if (patient == null) {
            System.out.println("해당 이름의 환자가 없습니다.");
            return;
        }

        System.out.print("의사 이름: ");
        String doctorName = scanner.nextLine();
        DoctorDTO doctor = DoctorManager.findDoctorByName(doctorName);
        if (doctor == null) {
            System.out.println("해당 이름의 의사가 없습니다.");
            return;
        }

        System.out.print("예약 날짜 (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        Date appointmentDate;
        try {
            appointmentDate = java.sql.Date.valueOf(dateStr); // 문자열을 Date 객체로 변환
        } catch (Exception e) {
            System.out.println("날짜 형식이 잘못되었습니다.");
            return;
        }

        System.out.print("예약 시간 (HH:mm): ");
        String appointmentTime = scanner.nextLine();
        System.out.print("상태: ");
        String status = scanner.nextLine();

        int appointmentId = appointments.size() + 1;
        AppointmentDTO appointment = new AppointmentDTO(appointmentId, patient, doctor, appointmentDate, appointmentTime, status);
        appointments.add(appointment);
        System.out.println("진료 예약이 추가되었습니다.");
    }

    private void viewAppointmentInfo(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        AppointmentDTO appointment = findAppointmentByPatientName(patientName);
        if (appointment != null) {
            System.out.println("예약 ID: " + appointment.getAppointmentId());
            System.out.println("환자: " + appointment.getPatient().getName());
            System.out.println("의사: " + appointment.getDoctor().getName());
            System.out.println("날짜: " + appointment.getAppointmentDate());
            System.out.println("시간: " + appointment.getAppointmentTime());
            System.out.println("상태: " + appointment.getStatus());
        } else {
            System.out.println("해당 이름의 진료 예약이 없습니다.");
        }
    }

    private void updateAppointment(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        AppointmentDTO appointment = findAppointmentByPatientName(patientName);
        if (appointment != null) {
            System.out.print("새 예약 날짜 (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            Date newDate;
            try {
                newDate = java.sql.Date.valueOf(dateStr); // 문자열을 Date 객체로 변환
            } catch (Exception e) {
                System.out.println("날짜 형식이 잘못되었습니다.");
                return;
            }

            System.out.print("새 예약 시간 (HH:mm): ");
            String newTime = scanner.nextLine();
            appointment.setAppointmentDate(newDate);
            appointment.setAppointmentTime(newTime);
            System.out.println("예약이 업데이트되었습니다.");
        } else {
            System.out.println("해당 이름의 진료 예약이 없습니다.");
        }
    }

    private void cancelAppointment(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        AppointmentDTO appointment = findAppointmentByPatientName(patientName);
        if (appointment != null) {
            appointment.setStatus("취소됨");
            System.out.println("예약이 취소되었습니다.");
        } else {
            System.out.println("해당 이름의 진료 예약이 없습니다.");
        }
    }

    private AppointmentDTO findAppointmentByPatientName(String name) {
        for (AppointmentDTO appointment : appointments) {
            if (appointment.getPatient().getName().equalsIgnoreCase(name)) {
                return appointment;
            }
        }
        return null;
    }
}
