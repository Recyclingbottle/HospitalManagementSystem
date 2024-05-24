package com.hospital.service;

import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private List<PatientDTO> patients = new ArrayList<>();

    public void addPatient(PatientDTO patient) {
        patients.add(patient);
        System.out.println("환자가 추가되었습니다: " + patient.getName());
    }

    public PatientDTO findPatientByName(String name) {
        for (PatientDTO patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    public PatientDTO findPatientById(int id) {
        for (PatientDTO patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public List<PatientDTO> getAllPatients() {
        return patients;
    }

    public void updateMedicalHistory(String patientName, String newRecord) {
        PatientDTO patient = findPatientByName(patientName);
        if (patient != null) {
            patient.getMedicalHistory().add(newRecord);
            System.out.println(patientName + " 환자의 진료 기록이 업데이트되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    public void updateCurrentMedication(String patientName, String newMedication) {
        PatientDTO patient = findPatientByName(patientName);
        if (patient != null) {
            patient.getCurrentMedication().add(newMedication);
            System.out.println(patientName + " 환자의 현재 복용 약물이 업데이트되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }
}
