package com.hospital.dto;

import java.util.ArrayList;
import java.util.List;

public class NurseDTO extends CrewDTO {
    private List<String> assignedWards;

    public NurseDTO(String name, int age, String contactInfo, boolean isOnDuty, double salary) {
        super(name, age, contactInfo, isOnDuty, salary);
        this.assignedWards = new ArrayList<>();
    }

    public List<String> getAssignedWards() {
        return assignedWards;
    }

    public void setAssignedWards(List<String> assignedWards) {
        this.assignedWards = assignedWards;
    }
}
