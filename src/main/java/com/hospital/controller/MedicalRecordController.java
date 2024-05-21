package com.hospital.controller;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.MedicalRecordDTO;
import com.hospital.dto.PatientDTO;
import com.hospital.service.DoctorService;
import com.hospital.service.MedicalRecordService;
import com.hospital.service.PatientService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordController {
    private MedicalRecordService medicalRecordService = new MedicalRecordService();
    private PatientService patientService = new PatientService();
    private DoctorService doctorService = new DoctorService();

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 진료 기록 추가");
            System.out.println("2. 진료 기록 정보 보기");
            System.out.println("3. 진료 기록 업데이트");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addMedicalRecord(scanner);
                    break;
                case 2:
                    viewMedicalRecordInfo(scanner);
                    break;
                case 3:
                    updateMedicalRecord(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private void addMedicalRecord(Scanner scanner) {
        System.out.print("진료 기록 ID: ");
        int recordId = scanner.nextInt();
        scanner.nextLine();  

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

        medicalRecordService.addMedicalRecord(recordId, patient, doctor, visitDate, diagnosis, treatment);
        System.out.println("진료 기록이 추가되었습니다.");
    }

    private void viewMedicalRecordInfo(Scanner scanner) {
        System.out.print("진료 기록 ID: ");
        int recordId = scanner.nextInt();
        scanner.nextLine();  
        MedicalRecordDTO medicalRecord = medicalRecordService.findMedicalRecordById(recordId);
        if (medicalRecord != null) {
            System.out.println("진료 기록 ID: " + medicalRecord.getRecordId());
            System.out.println("환자: " + medicalRecord.getPatient().getName());
            System.out.println("의사: " + medicalRecord.getDoctor().getName());
            System.out.println("방문 날짜: " + medicalRecord.getVisitDate());
            System.out.println("진단: " + medicalRecord.getDiagnosis());
            System.out.println("치료: " + medicalRecord.getTreatment());
        } else {
            System.out.println("해당 ID의 진료 기록이 없습니다.");
        }
    }

    private void updateMedicalRecord(Scanner scanner) {
        System.out.print("진료 기록 ID: ");
        int recordId = scanner.nextInt();
        scanner.nextLine();  
        MedicalRecordDTO medicalRecord = medicalRecordService.findMedicalRecordById(recordId);
        if (medicalRecord != null) {
            System.out.print("새 진단: ");
            String newDiagnosis = scanner.nextLine();
            System.out.print("새 치료: ");
            String newTreatment = scanner.nextLine();
            medicalRecordService.updateMedicalRecord(recordId, newDiagnosis, newTreatment);
            System.out.println("진료 기록이 업데이트되었습니다.");
        } else {
            System.out.println("해당 ID의 진료 기록이 없습니다.");
        }
    }
}
