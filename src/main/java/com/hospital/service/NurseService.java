package com.hospital.service;

import com.hospital.dto.NurseDTO;

import java.util.ArrayList;
import java.util.List;

public class NurseService {
    private List<NurseDTO> nurses = new ArrayList<>();

    public void addNurse(NurseDTO nurse) {
        nurses.add(nurse);
    }

    public NurseDTO findNurseByName(String name) {
        for (NurseDTO nurse : nurses) {
            if (nurse.getName().equalsIgnoreCase(name)) {
                return nurse;
            }
        }
        return null;
    }

    public List<NurseDTO> getAllNurses() {
        return new ArrayList<>(nurses);
    }

    public void assignWard(String nurseName, String ward) {
        NurseDTO nurse = findNurseByName(nurseName);
        if (nurse != null && !nurse.getAssignedWards().contains(ward)) {
            nurse.getAssignedWards().add(ward);
        }
    }

    public void removeWard(String nurseName, String ward) {
        NurseDTO nurse = findNurseByName(nurseName);
        if (nurse != null) {
            nurse.getAssignedWards().remove(ward);
        }
    }
}
