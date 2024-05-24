package com.hospital.service;

import com.hospital.dto.DrugDTO;
import com.hospital.dto.PharmacyDTO;

import java.util.Map;

public class PharmacyService {
    private PharmacyDTO pharmacy;

    public PharmacyService() {
        this.pharmacy = new PharmacyDTO();
    }

    public void addDrug(DrugDTO drug) {
        Map<String, DrugDTO> inventory = pharmacy.getDrugInventory();
        if (inventory.containsKey(drug.getName())) {
            DrugDTO existingDrug = inventory.get(drug.getName());
            existingDrug.setQuantity(existingDrug.getQuantity() + drug.getQuantity());
            existingDrug.setPrice(drug.getPrice());
            System.out.println(drug.getName() + " 약품 정보가 업데이트되었습니다.");
        } else {
            inventory.put(drug.getName(), drug);
            System.out.println(drug.getName() + " 약품이 추가되었습니다.");
        }
    }

    public void viewDrugInfo(String drugName) {
        Map<String, DrugDTO> inventory = pharmacy.getDrugInventory();
        DrugDTO drug = inventory.get(drugName);
        if (drug != null) {
            System.out.println("약품 이름: " + drug.getName());
            System.out.println("재고 수량: " + drug.getQuantity());
            System.out.println("가격: " + drug.getPrice());
        } else {
            System.out.println(drugName + " 약품이 존재하지 않습니다.");
        }
    }

    public void dispenseDrug(String drugName, int quantity) {
        Map<String, DrugDTO> inventory = pharmacy.getDrugInventory();
        DrugDTO drug = inventory.get(drugName);
        if (drug != null && drug.getQuantity() >= quantity) {
            drug.setQuantity(drug.getQuantity() - quantity);
            System.out.println(quantity + "개의 " + drugName + " 약품이 조제되었습니다.");
        } else {
            System.out.println(drugName + " 약품의 재고가 부족하거나 존재하지 않습니다.");
        }
    }

    public void viewAllDrugs() {
        Map<String, DrugDTO> inventory = pharmacy.getDrugInventory();
        if (inventory.isEmpty()) {
            System.out.println("약국에 등록된 약품이 없습니다.");
        } else {
            System.out.println("약국 약품 목록:");
            for (DrugDTO drug : inventory.values()) {
                System.out.println("약품 이름: " + drug.getName());
                System.out.println("재고 수량: " + drug.getQuantity());
                System.out.println("가격: " + drug.getPrice());
                System.out.println("--------------------");
            }
        }
    }
}
