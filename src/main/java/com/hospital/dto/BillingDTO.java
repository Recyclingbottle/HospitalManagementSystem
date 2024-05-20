package com.hospital.dto;

public class BillingDTO {
    private int billingId;
    private PatientDTO patient;
    private double totalAmount;
    private String paymentStatus;

    public BillingDTO(int billingId, PatientDTO patient, double totalAmount, String paymentStatus) {
        this.billingId = billingId;
        this.patient = patient;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    // Getter와 Setter 메소드
    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
