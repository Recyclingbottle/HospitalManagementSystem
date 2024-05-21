package com.hospital.service;

import com.hospital.dto.DrugDTO;
import com.hospital.dto.PharmacyDTO;

public class PharmacyService {
    private PharmacyDTO pharmacy;

    public PharmacyService() {
        this.pharmacy = new PharmacyDTO();
    }

    public void addDrug(String name, int quantity, double price) {
        DrugDTO drug = pharmacy.getDrugInventory().get(name);
        if (drug == null) {
            drug = new DrugDTO(name, quantity, price);
            pharmacy.getDrugInventory().put(name, drug);
            System.out.println(name + " 약품이 추가되었습니다.");
        } else {
            drug.setQuantity(drug.getQuantity() + quantity);
            drug.setPrice(price);
            System.out.println(name + " 약품 정보가 업데이트되었습니다.");
        }
    }

    public void viewDrugInfo(String name) {
        DrugDTO drug = pharmacy.getDrugInventory().get(name);
        if (drug != null) {
            System.out.println("약품 이름: " + drug.getName());
            System.out.println("재고 수량: " + drug.getQuantity());
            System.out.println("가격: " + drug.getPrice());
        } else {
            System.out.println(name + " 약품이 존재하지 않습니다.");
        }
    }

    public void dispenseDrug(String name, int quantity) {
        DrugDTO drug = pharmacy.getDrugInventory().get(name);
        if (drug != null && drug.getQuantity() >= quantity) {
            drug.setQuantity(drug.getQuantity() - quantity);
            System.out.println(quantity + "개의 " + name + " 약품이 조제되었습니다.");
        } else {
            System.out.println(name + " 약품의 재고가 부족하거나 존재하지 않습니다.");
        }
    }

    public void viewAllDrugs() {
        if (pharmacy.getDrugInventory().isEmpty()) {
            System.out.println("약국에 등록된 약품이 없습니다.");
        } else {
            System.out.println("약국 약품 목록:");
            for (DrugDTO drug : pharmacy.getDrugInventory().values()) {
                System.out.println("약품 이름: " + drug.getName());
                System.out.println("재고 수량: " + drug.getQuantity());
                System.out.println("가격: " + drug.getPrice());
                System.out.println("-------------------------");
            }
        }
    }
}
