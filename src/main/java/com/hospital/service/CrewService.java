package com.hospital.service;

import com.hospital.dto.CrewDTO;

import java.util.ArrayList;
import java.util.List;

public class CrewService {
    private List<CrewDTO> crewMembers = new ArrayList<>();

    public void addCrewMember(CrewDTO crewMember) {
        crewMembers.add(crewMember);
        System.out.println("병원 직원이 추가되었습니다: " + crewMember.getName());
    }

    public CrewDTO findCrewByName(String name) {
        for (CrewDTO crewMember : crewMembers) {
            if (crewMember.getName().equalsIgnoreCase(name)) {
                return crewMember;
            }
        }
        return null;
    }

    public List<CrewDTO> getAllCrewMembers() {
        return crewMembers;
    }
}
