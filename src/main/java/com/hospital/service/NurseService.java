package com.hospital.service;

import com.hospital.dto.NurseDTO;

import java.util.ArrayList;
import java.util.List;

public class NurseService {
    private List<NurseDTO> nurses = new ArrayList<>();

    public void addNurse(NurseDTO nurse) {
        nurses.add(nurse);
        System.out.println("간호사가 추가되었습니다: " + nurse.getName());
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
        return nurses;
    }

    public void assignWardToNurse(String nurseName, String ward) {
        NurseDTO nurse = findNurseByName(nurseName);
        if (nurse != null) {
            if (!nurse.getAssignedWards().contains(ward)) {
                nurse.getAssignedWards().add(ward);
                System.out.println(ward + " 병동이 " + nurse.getName() + " 간호사에게 배정되었습니다.");
            } else {
                System.out.println("해당 병동은 이미 배정되어 있습니다.");
            }
        } else {
            System.out.println("해당 이름의 간호사가 없습니다.");
        }
    }

    public void removeWardFromNurse(String nurseName, String ward) {
        NurseDTO nurse = findNurseByName(nurseName);
        if (nurse != null) {
            if (nurse.getAssignedWards().contains(ward)) {
                nurse.getAssignedWards().remove(ward);
                System.out.println(ward + " 병동이 " + nurse.getName() + " 간호사에게서 해제되었습니다.");
            } else {
                System.out.println("해당 병동은 배정되지 않았습니다.");
            }
        } else {
            System.out.println("해당 이름의 간호사가 없습니다.");
        }
    }
}
