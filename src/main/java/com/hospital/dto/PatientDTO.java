package com.hospital.dto;

import java.util.ArrayList;
import java.util.List;

public class PatientDTO extends UserDTO {
    private List<String> medicalHistory;
    private List<String> currentMedication;
    private DoctorDTO assignedDoctor;

    public PatientDTO(String name, int age, String contactInfo, DoctorDTO assignedDoctor) {
        super(name, age, contactInfo);
        this.medicalHistory = new ArrayList<>();
        this.currentMedication = new ArrayList<>();
        this.assignedDoctor = assignedDoctor;
    }

    // Getter와 Setter 메소드
    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<String> getCurrentMedication() {
        return currentMedication;
    }

    public void setCurrentMedication(List<String> currentMedication) {
        this.currentMedication = currentMedication;
    }

    public DoctorDTO getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(DoctorDTO assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    // 진료 기록을 추가하는 메소드
    public void addMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    // 현재 복용 약물을 추가하는 메소드
    public void addCurrentMedication(String medication) {
        currentMedication.add(medication);
    }
}
