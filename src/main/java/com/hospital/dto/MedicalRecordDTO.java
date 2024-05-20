package com.hospital.dto;

import java.util.Date;

public class MedicalRecordDTO {
    private int recordId;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private Date visitDate;
    private String diagnosis;
    private String treatment;

    public MedicalRecordDTO(int recordId, PatientDTO patient, DoctorDTO doctor, Date visitDate, String diagnosis, String treatment) {
        this.recordId = recordId;
        this.patient = patient;
        this.doctor = doctor;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    // Getter와 Setter 메소드
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
