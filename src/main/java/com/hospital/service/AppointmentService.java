package com.hospital.service;

import com.hospital.dto.AppointmentDTO;
import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentService {
    private List<AppointmentDTO> appointments;

    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    public synchronized void addAppointment(PatientDTO patient, DoctorDTO doctor, Date appointmentDate, String appointmentTime, String status) {
        int appointmentId = appointments.size() + 1;
        AppointmentDTO appointment = new AppointmentDTO(appointmentId, patient, doctor, appointmentDate, appointmentTime, status);
        appointments.add(appointment);
    }

    public synchronized List<AppointmentDTO> getAppointments() {
        return new ArrayList<>(appointments);
    }

    public synchronized void updateAppointment(int appointmentId, Date newDate, String newTime) {
        for (AppointmentDTO appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                appointment.setAppointmentDate(newDate);
                appointment.setAppointmentTime(newTime);
                return;
            }
        }
    }

    public synchronized void cancelAppointment(int appointmentId) {
        appointments.removeIf(appointment -> appointment.getAppointmentId() == appointmentId);
    }
}
