package com.hospital.dto;

public class CrewDTO extends UserDTO {
    private boolean isOnDuty;
    private double salary;

    public CrewDTO(String name, int age, String contactInfo, boolean isOnDuty, double salary) {
        super(name, age, contactInfo);
        this.isOnDuty = isOnDuty;
        this.salary = salary;
    }

    // Getter와 Setter 메소드
    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void setOnDuty(boolean onDuty) {
        isOnDuty = onDuty;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
