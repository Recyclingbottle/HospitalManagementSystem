package com.hospital.dto;

import java.util.HashMap;
import java.util.Map;

public class PharmacyDTO {
    private Map<String, DrugDTO> drugInventory;

    public PharmacyDTO() {
        this.drugInventory = new HashMap<>();
    }

    public Map<String, DrugDTO> getDrugInventory() {
        return drugInventory;
    }

    public void setDrugInventory(Map<String, DrugDTO> drugInventory) {
        this.drugInventory = drugInventory;
    }
}
