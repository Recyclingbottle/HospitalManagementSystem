package com.hospital.controller;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;
import com.hospital.service.DoctorService;
import com.hospital.service.PatientService;

import java.util.List;
import java.util.Scanner;

public class PatientController {
    private PatientService patientService = new PatientService();
    private DoctorService doctorService = new DoctorService();

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

    private void addPatient(Scanner scanner) {
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
        PatientDTO patient = new PatientDTO(name, age, contactInfo, assignedDoctor);
        patientService.addPatient(patient);
        System.out.println("환자가 추가되었습니다.");
    }

    private void viewPatientInfo(Scanner scanner) {
        System.out.print("환자 이름: ");
        String name = scanner.nextLine();
        PatientDTO patient = patientService.findPatientByName(name);
        if (patient != null) {
            System.out.println("이름: " + patient.getName());
            System.out.println("나이: " + patient.getAge());
            System.out.println("연락처: " + patient.getContactInfo());
            System.out.println("배정된 의사: " + patient.getAssignedDoctor().getName());
            viewMedicalHistory(patient);
            viewCurrentMedication(patient);
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    private void viewMedicalHistory(PatientDTO patient) {
        List<String> history = patient.getMedicalHistory();
        if (history.isEmpty()) {
            System.out.println("진료 기록이 없습니다.");
        } else {
            System.out.println("진료 기록:");
            for (String record : history) {
                System.out.println("- " + record);
            }
        }
    }

    private void viewCurrentMedication(PatientDTO patient) {
        List<String> medication = patient.getCurrentMedication();
        if (medication.isEmpty()) {
            System.out.println("현재 복용 약물이 없습니다.");
        } else {
            System.out.println("현재 복용 약물:");
            for (String med : medication) {
                System.out.println("- " + med);
            }
        }
    }

    private void updateMedicalHistory(Scanner scanner) {
        System.out.print("환자 이름: ");
        String name = scanner.nextLine();
        System.out.print("추가할 진료 기록: ");
        String record = scanner.nextLine();
        patientService.updateMedicalHistory(name, record);
        System.out.println("진료 기록이 업데이트되었습니다.");
    }

    private void updateCurrentMedication(Scanner scanner) {
        System.out.print("환자 이름: ");
        String name = scanner.nextLine();
        System.out.print("추가할 현재 복용 약물: ");
        String medication = scanner.nextLine();
        patientService.updateCurrentMedication(name, medication);
        System.out.println("현재 복용 약물이 업데이트되었습니다.");
    }
}
