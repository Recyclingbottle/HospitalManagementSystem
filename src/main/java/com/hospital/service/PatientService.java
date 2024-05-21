package com.hospital.service;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private List<PatientDTO> patients = new ArrayList<>();

    public void addPatient(PatientDTO patient) {
        patients.add(patient);
    }

    public PatientDTO findPatientByName(String name) {
        for (PatientDTO patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    public List<PatientDTO> getAllPatients() {
        return new ArrayList<>(patients);
    }

    public void updateMedicalHistory(String patientName, String record) {
        PatientDTO patient = findPatientByName(patientName);
        if (patient != null) {
            patient.getMedicalHistory().add(record);
        }
    }

    public void updateCurrentMedication(String patientName, String medication) {
        PatientDTO patient = findPatientByName(patientName);
        if (patient != null) {
            patient.getCurrentMedication().add(medication);
        }
    }
}
