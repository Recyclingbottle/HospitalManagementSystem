package com.hospital.service;

import com.hospital.dto.BillingDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;

public class BillingService {
    private List<BillingDTO> billings;
    public static final String[] PAYMENT_STATUSES = {"미결제", "결제 완료", "결제 보류"};

    public BillingService() {
        this.billings = new ArrayList<>();
    }

    public synchronized void createBilling(PatientDTO patient, double totalAmount) {
        int billingId = billings.size() + 1;
        BillingDTO billing = new BillingDTO(billingId, patient, totalAmount, PAYMENT_STATUSES[0]);
        billings.add(billing);
    }

    public synchronized List<BillingDTO> getBillings() {
        return new ArrayList<>(billings);
    }

    public synchronized void updatePaymentStatus(int billingId, String newStatus) {
        for (BillingDTO billing : billings) {
            if (billing.getBillingId() == billingId) {
                billing.setPaymentStatus(newStatus);
                return;
            }
        }
    }
}
