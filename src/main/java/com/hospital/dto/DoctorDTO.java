package com.hospital.dto;

import java.util.ArrayList;
import java.util.List;

public class DoctorDTO extends CrewDTO {
    private String specialty;
    private List<PatientDTO> assignedPatients;

    public DoctorDTO(String name, int age, String contactInfo, boolean isOnDuty, double salary, String specialty) {
        super(name, age, contactInfo, isOnDuty, salary);
        this.specialty = specialty;
        this.assignedPatients = new ArrayList<>();
    }

    // Getter와 Setter 메소드
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<PatientDTO> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<PatientDTO> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    // 환자 추가 메소드
    public void addPatient(PatientDTO patient) {
        this.assignedPatients.add(patient);
    }

    // 환자 제거 메소드
    public void removePatient(PatientDTO patient) {
        this.assignedPatients.remove(patient);
    }
}
