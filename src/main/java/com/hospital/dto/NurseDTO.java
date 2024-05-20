package com.hospital.dto;

import java.util.ArrayList;
import java.util.List;

public class NurseDTO extends CrewDTO {
    private List<String> assignedWards;

    public NurseDTO(String name, int age, String contactInfo, boolean isOnDuty, double salary) {
        super(name, age, contactInfo, isOnDuty, salary);
        this.assignedWards = new ArrayList<>();
    }

    // Getter와 Setter 메소드
    public List<String> getAssignedWards() {
        return assignedWards;
    }

    public void setAssignedWards(List<String> assignedWards) {
        this.assignedWards = assignedWards;
    }

    // 병동을 추가하는 메소드
    public void addWard(String ward) {
        if (!assignedWards.contains(ward)) {
            assignedWards.add(ward);
        } else {
            System.out.println("해당 병동은 이미 배정되어 있습니다.");
        }
    }

    // 병동을 제거하는 메소드
    public void removeWard(String ward) {
        if (assignedWards.contains(ward)) {
            assignedWards.remove(ward);
        } else {
            System.out.println("해당 병동은 배정되지 않았습니다.");
        }
    }
}
