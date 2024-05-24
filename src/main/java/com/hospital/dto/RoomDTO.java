package com.hospital.dto;

import java.util.ArrayList;
import java.util.List;

public class RoomDTO {
    private int roomId;
    private RoomType roomType;
    private boolean availability;
    private List<PatientDTO> assignedPatients;

    public RoomDTO(int roomId, RoomType roomType) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.availability = true;
        this.assignedPatients = new ArrayList<>();
    }

    // Getter와 Setter 메소드
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<PatientDTO> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<PatientDTO> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }
}
