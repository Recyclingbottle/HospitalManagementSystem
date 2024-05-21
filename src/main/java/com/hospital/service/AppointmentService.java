package com.hospital.service;

import com.hospital.dto.AppointmentDTO;
import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentService {
    private List<AppointmentDTO> appointments = new ArrayList<>();

    public void addAppointment(PatientDTO patient, DoctorDTO doctor, Date appointmentDate, String appointmentTime, String status) {
        int appointmentId = appointments.size() + 1;
        AppointmentDTO appointment = new AppointmentDTO(appointmentId, patient, doctor, appointmentDate, appointmentTime, status);
        appointments.add(appointment);
    }

    public List<AppointmentDTO> getAppointments() {
        return new ArrayList<>(appointments);
    }

    public AppointmentDTO findAppointmentById(int appointmentId) {
        for (AppointmentDTO appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }
        return null;
    }

    public void updateAppointment(int appointmentId, Date newDate, String newTime) {
        AppointmentDTO appointment = findAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.setAppointmentDate(newDate);
            appointment.setAppointmentTime(newTime);
        }
    }

    public void cancelAppointment(int appointmentId) {
        AppointmentDTO appointment = findAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.setStatus("Cancelled");
        }
    }
}
