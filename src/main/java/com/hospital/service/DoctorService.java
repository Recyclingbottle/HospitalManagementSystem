package com.hospital.service;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private List<DoctorDTO> doctors = new ArrayList<>();

    public void addDoctor(String name, int age, String contactInfo, boolean isOnDuty, double salary, String specialty) {
        DoctorDTO doctor = new DoctorDTO(name, age, contactInfo, isOnDuty, salary, specialty);
        doctors.add(doctor);
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
        return new ArrayList<>(doctors);
    }

    public void addPatientToDoctor(String doctorName, PatientDTO patient) {
        DoctorDTO doctor = findDoctorByName(doctorName);
        if (doctor != null) {
            doctor.addPatient(patient);
        }
    }

    public void removePatientFromDoctor(String doctorName, PatientDTO patient) {
        DoctorDTO doctor = findDoctorByName(doctorName);
        if (doctor != null) {
            doctor.removePatient(patient);
        }
    }
}
