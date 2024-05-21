package com.hospital.dto;

public class CrewDTO {
    private String name;
    private int age;
    private String contactInfo;
    private boolean isOnDuty;
    private double salary;

    public CrewDTO(String name, int age, String contactInfo, boolean isOnDuty, double salary) {
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
        this.isOnDuty = isOnDuty;
        this.salary = salary;
    }

    // Getter와 Setter 메소드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

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
