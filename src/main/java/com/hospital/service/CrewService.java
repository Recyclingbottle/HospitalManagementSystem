package com.hospital.service;

import com.hospital.dto.CrewDTO;

import java.util.ArrayList;
import java.util.List;

public class CrewService {
    private List<CrewDTO> crewMembers = new ArrayList<>();

    public void addCrewMember(String name, int age, String contactInfo, boolean isOnDuty, double salary) {
        CrewDTO crewMember = new CrewDTO(name, age, contactInfo, isOnDuty, salary);
        crewMembers.add(crewMember);
    }

    public CrewDTO findCrewByName(String name) {
        for (CrewDTO crew : crewMembers) {
            if (crew.getName().equalsIgnoreCase(name)) {
                return crew;
            }
        }
        return null;
    }

    public List<CrewDTO> getAllCrewMembers() {
        return new ArrayList<>(crewMembers);
    }
}
