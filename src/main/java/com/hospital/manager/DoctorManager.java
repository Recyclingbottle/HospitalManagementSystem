package com.hospital.manager;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorManager {
    private static List<DoctorDTO> doctors = new ArrayList<>();

    public static void menu(Scanner scanner) {
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

            switch (choice) {
                case 1:
                    addDoctor(scanner);
                    break;
                case 2:
                    viewDoctorInfo(scanner);
                    break;
                case 3:
                    viewAssignedPatients(scanner);
                    break;
                case 4:
                    addPatientToDoctor(scanner);
                    break;
                case 5:
                    removePatientFromDoctor(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addDoctor(Scanner scanner) {
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
        doctors.add(doctor);
        System.out.println("의사가 추가되었습니다.");
    }

    private static void viewDoctorInfo(Scanner scanner) {
        System.out.print("의사 이름: ");
        String name = scanner.nextLine();
        DoctorDTO doctor = findDoctorByName(name);
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
    }

    private static void viewAssignedPatients(Scanner scanner) {
        System.out.print("의사 이름: ");
        String name = scanner.nextLine();
        DoctorDTO doctor = findDoctorByName(name);
        if (doctor != null) {
            System.out.println("배정된 환자 목록:");
            List<PatientDTO> patients = doctor.getAssignedPatients();
            if (patients.isEmpty()) {
                System.out.println("배정된 환자가 없습니다.");
            } else {
                for (PatientDTO patient : patients) {
                    System.out.println("- " + patient.getName());
                }
            }
        } else {
            System.out.println("해당 이름의 의사가 없습니다.");
        }
    }

    private static void addPatientToDoctor(Scanner scanner) {
        System.out.print("의사 이름: ");
        String doctorName = scanner.nextLine();
        DoctorDTO doctor = findDoctorByName(doctorName);
        if (doctor == null) {
            System.out.println("해당 이름의 의사가 없습니다.");
            return;
        }
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        PatientDTO patient = PatientManager.findPatientByName(patientName);
        if (patient != null) {
            doctor.addPatient(patient);
            System.out.println("환자가 의사에게 배정되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    private static void removePatientFromDoctor(Scanner scanner) {
        System.out.print("의사 이름: ");
        String doctorName = scanner.nextLine();
        DoctorDTO doctor = findDoctorByName(doctorName);
        if (doctor == null) {
            System.out.println("해당 이름의 의사가 없습니다.");
            return;
        }
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        PatientDTO patient = PatientManager.findPatientByName(patientName);
        if (patient != null) {
            doctor.removePatient(patient);
            System.out.println("환자가 의사에게서 해제되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    public static DoctorDTO findDoctorByName(String name) {
        for (DoctorDTO doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }
}
