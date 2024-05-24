package com.hospital.service;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.MedicalRecordDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MedicalRecordService {
    private List<MedicalRecordDTO> medicalRecords;
    private final Lock lock = new ReentrantLock();

    public MedicalRecordService() {
        this.medicalRecords = new ArrayList<>();
    }

    public void addMedicalRecord(PatientDTO patient, DoctorDTO doctor, Date visitDate, String diagnosis, String treatment) {
        lock.lock();
        try {
            int recordId = medicalRecords.size() + 1;
            MedicalRecordDTO medicalRecord = new MedicalRecordDTO(recordId, patient, doctor, visitDate, diagnosis, treatment);
            medicalRecords.add(medicalRecord);
            System.out.println("진료 기록이 추가되었습니다.");
        } finally {
            lock.unlock();
        }
    }

    public List<MedicalRecordDTO> getMedicalRecords() {
        return medicalRecords;
    }

    public void updateMedicalRecord(int recordId, String newDiagnosis, String newTreatment) {
        lock.lock();
        try {
            MedicalRecordDTO medicalRecord = findMedicalRecordById(recordId);
            if (medicalRecord != null) {
                medicalRecord.setDiagnosis(newDiagnosis);
                medicalRecord.setTreatment(newTreatment);
                System.out.println("진료 기록이 업데이트되었습니다.");
            } else {
                System.out.println("해당 ID의 진료 기록이 없습니다.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void viewMedicalRecord(int recordId) {
        lock.lock();
        try {
            MedicalRecordDTO medicalRecord = findMedicalRecordById(recordId);
            if (medicalRecord != null) {
                System.out.println("진료 기록 ID: " + medicalRecord.getRecordId());
                System.out.println("환자: " + medicalRecord.getPatient().getName());
                System.out.println("의사: " + medicalRecord.getDoctor().getName());
                System.out.println("방문 날짜: " + medicalRecord.getVisitDate());
                System.out.println("진단: " + medicalRecord.getDiagnosis());
                System.out.println("치료: " + medicalRecord.getTreatment());
                System.out.println("--------------------");
            } else {
                System.out.println("해당 ID의 진료 기록이 없습니다.");
            }
        } finally {
            lock.unlock();
        }
    }

    private MedicalRecordDTO findMedicalRecordById(int recordId) {
        for (MedicalRecordDTO medicalRecord : medicalRecords) {
            if (medicalRecord.getRecordId() == recordId) {
                return medicalRecord;
            }
        }
        return null;
    }
}
