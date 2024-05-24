package com.hospital.dto;

import java.util.ArrayList;
import java.util.List;

public class PatientDTO extends UserDTO {
    private int id;
    private List<String> medicalHistory;
    private List<String> currentMedication;
    private DoctorDTO assignedDoctor;

    public PatientDTO(int id, String name, int age, String contactInfo) {
        super(name, age, contactInfo);
        this.id = id;
        this.medicalHistory = new ArrayList<>();
        this.currentMedication = new ArrayList<>();
    }

    // Getter와 Setter 메소드
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
