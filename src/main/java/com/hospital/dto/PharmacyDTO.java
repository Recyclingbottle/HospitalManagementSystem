package com.hospital.dto;

import java.util.HashMap;
import java.util.Map;

public class PharmacyDTO {
    private Map<String, DrugDTO> drugInventory;

    public PharmacyDTO() {
        this.drugInventory = new HashMap<>();
    }

    // Getter와 Setter 메소드
    public Map<String, DrugDTO> getDrugInventory() {
        return drugInventory;
    }

    public void setDrugInventory(Map<String, DrugDTO> drugInventory) {
        this.drugInventory = drugInventory;
    }

    // 약품을 추가하는 메소드
    public void addDrug(DrugDTO drug) {
        drugInventory.put(drug.getName(), drug);
    }

    // 약품을 조회하는 메소드
    public DrugDTO getDrug(String drugName) {
        return drugInventory.get(drugName);
    }

    // 약품을 조제하는 메소드
    public void dispenseDrug(String drugName, int quantity) {
        DrugDTO drug = drugInventory.get(drugName);
        if (drug != null) {
            drug.dispense(quantity);
        }
    }
}
