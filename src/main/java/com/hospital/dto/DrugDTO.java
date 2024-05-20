package com.hospital.dto;

public class DrugDTO {
    private String name;
    private int quantity;
    private double price;

    public DrugDTO(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter와 Setter 메소드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // 약품의 재고를 추가하는 메소드
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    // 약품을 조제하는 메소드
    public void dispense(int quantity) {
        this.quantity -= quantity;
    }
}
