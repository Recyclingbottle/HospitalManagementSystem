package com.hospital.service;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private List<DoctorDTO> doctors = new ArrayList<>();

    public void addDoctor(DoctorDTO doctor) {
        doctors.add(doctor);
        System.out.println("의사가 추가되었습니다: " + doctor.getName());
    }

    public DoctorDTO findDoctorByName(String name) {
        for (DoctorDTO doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }

    public List<DoctorDTO> getAllDoctors() {
        return doctors;
    }

    public void addPatientToDoctor(String doctorName, PatientDTO patient) {
        DoctorDTO doctor = findDoctorByName(doctorName);
        if (doctor != null) {
            if (!doctor.getAssignedPatients().contains(patient)) {
                doctor.getAssignedPatients().add(patient);
                System.out.println(patient.getName() + " 환자가 " + doctor.getName() + " 의사에게 배정되었습니다.");
            } else {
                System.out.println("해당 환자는 이미 배정되어 있습니다.");
            }
        } else {
            System.out.println("해당 이름의 의사가 없습니다.");
        }
    }

    public void removePatientFromDoctor(String doctorName, PatientDTO patient) {
        DoctorDTO doctor = findDoctorByName(doctorName);
        if (doctor != null) {
            if (doctor.getAssignedPatients().contains(patient)) {
                doctor.getAssignedPatients().remove(patient);
                System.out.println(patient.getName() + " 환자가 " + doctor.getName() + " 의사에게서 해제되었습니다.");
            } else {
                System.out.println("해당 환자는 배정되지 않았습니다.");
            }
        } else {
            System.out.println("해당 이름의 의사가 없습니다.");
        }
    }
}
