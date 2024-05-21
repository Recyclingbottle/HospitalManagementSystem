package com.hospital.service;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.MedicalRecordDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalRecordService {
    private List<MedicalRecordDTO> medicalRecords = new ArrayList<>();

    public void addMedicalRecord(int recordId, PatientDTO patient, DoctorDTO doctor, Date visitDate, String diagnosis, String treatment) {
        MedicalRecordDTO medicalRecord = new MedicalRecordDTO(recordId, patient, doctor, visitDate, diagnosis, treatment);
        medicalRecords.add(medicalRecord);
    }

    public MedicalRecordDTO findMedicalRecordById(int recordId) {
        for (MedicalRecordDTO medicalRecord : medicalRecords) {
            if (medicalRecord.getRecordId() == recordId) {
                return medicalRecord;
            }
        }
        return null;
    }

    public List<MedicalRecordDTO> getAllMedicalRecords() {
        return new ArrayList<>(medicalRecords);
    }

    public void updateMedicalRecord(int recordId, String newDiagnosis, String newTreatment) {
        MedicalRecordDTO medicalRecord = findMedicalRecordById(recordId);
        if (medicalRecord != null) {
            medicalRecord.setDiagnosis(newDiagnosis);
            medicalRecord.setTreatment(newTreatment);
        }
    }
}
