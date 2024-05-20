package com.hospital.manager;

import com.hospital.dto.PatientDTO;
import com.hospital.dto.DoctorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientManager {
    private static List<PatientDTO> patients = new ArrayList<>();

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 환자 추가");
            System.out.println("2. 환자 정보 보기");
            System.out.println("3. 진료 기록 업데이트");
            System.out.println("4. 현재 복용 약물 업데이트");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    viewPatientInfo(scanner);
                    break;
                case 3:
                    updateMedicalHistory(scanner);
                    break;
                case 4:
                    updateCurrentMedication(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("환자 이름: ");
        String name = scanner.nextLine();
        System.out.print("환자 나이: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Enter key 처리
        System.out.print("연락처: ");
        String contactInfo = scanner.nextLine();
        System.out.print("배정된 의사 이름: ");
        String doctorName = scanner.nextLine();
        DoctorDTO assignedDoctor = DoctorManager.findDoctorByName(doctorName);
        if (assignedDoctor == null) {
            System.out.println("해당 이름의 의사가 없습니다.");
            return;
        }
        PatientDTO patient = new PatientDTO(name, age, contactInfo, assignedDoctor);
        patients.add(patient);
        System.out.println("환자가 추가되었습니다.");
    }

    private static void viewPatientInfo(Scanner scanner) {
        System.out.print("환자 이름: ");
        String name = scanner.nextLine();
        PatientDTO patient = findPatientByName(name);
        if (patient != null) {
            System.out.println("이름: " + patient.getName());
            System.out.println("나이: " + patient.getAge());
            System.out.println("연락처: " + patient.getContactInfo());
            System.out.println("배정된 의사: " + (patient.getAssignedDoctor() != null ? patient.getAssignedDoctor().getName() : "없음"));
            System.out.println("진료 기록: " + patient.getMedicalHistory());
            System.out.println("현재 복용 약물: " + patient.getCurrentMedication());
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    private static void updateMedicalHistory(Scanner scanner) {
        System.out.print("환자 이름: ");
        String name = scanner.nextLine();
        PatientDTO patient = findPatientByName(name);
        if (patient != null) {
            System.out.print("추가할 진료 기록: ");
            String record = scanner.nextLine();
            patient.addMedicalHistory(record);
            System.out.println("진료 기록이 업데이트되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    private static void updateCurrentMedication(Scanner scanner) {
        System.out.print("환자 이름: ");
        String name = scanner.nextLine();
        PatientDTO patient = findPatientByName(name);
        if (patient != null) {
            System.out.print("추가할 현재 복용 약물: ");
            String medication = scanner.nextLine();
            patient.addCurrentMedication(medication);
            System.out.println("현재 복용 약물이 업데이트되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    public static PatientDTO findPatientByName(String name) {
        for (PatientDTO patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }
}
