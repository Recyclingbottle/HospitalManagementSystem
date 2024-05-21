package com.hospital.service;

import com.hospital.dto.PatientDTO;
import com.hospital.dto.RoomDTO;
import com.hospital.dto.RoomType;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private List<RoomDTO> rooms;

    public RoomService() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(int roomId, RoomType roomType) {
        RoomDTO room = new RoomDTO(roomId, roomType);
        rooms.add(room);
        System.out.println("병실이 추가되었습니다.");
    }

    public void viewRoomInfo(int roomId) {
        RoomDTO room = findRoomById(roomId);
        if (room != null) {
            System.out.println("병실 ID: " + room.getRoomId());
            System.out.println("병실 유형: " + room.getRoomType());
            System.out.println("이용 가능 여부: " + room.isAvailability());
            System.out.print("배정된 환자 목록: ");
            if (room.getAssignedPatients().isEmpty()) {
                System.out.println("없음");
            } else {
                for (PatientDTO patient : room.getAssignedPatients()) {
                    System.out.print(patient.getName() + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("해당 ID의 병실이 없습니다.");
        }
    }

    public void assignRoom(int roomId, PatientDTO patient) {
        RoomDTO room = findRoomById(roomId);
        if (room != null) {
            if (!room.getAssignedPatients().contains(patient)) {
                room.getAssignedPatients().add(patient);
                room.setAvailability(false);
                System.out.println(patient.getName() + " 환자가 " + room.getRoomType() + " 병실에 배정되었습니다.");
            } else {
                System.out.println("해당 환자는 이미 배정되어 있습니다.");
            }
        } else {
            System.out.println("해당 ID의 병실이 없습니다.");
        }
    }

    public void releaseRoom(int roomId, PatientDTO patient) {
        RoomDTO room = findRoomById(roomId);
        if (room != null) {
            if (room.getAssignedPatients().contains(patient)) {
                room.getAssignedPatients().remove(patient);
                System.out.println(patient.getName() + " 환자가 " + room.getRoomType() + " 병실에서 해제되었습니다.");
                if (room.getAssignedPatients().isEmpty()) {
                    room.setAvailability(true);
                }
            } else {
                System.out.println("해당 환자는 이 병실에 배정되지 않았습니다.");
            }
        } else {
            System.out.println("해당 ID의 병실이 없습니다.");
        }
    }

    public void viewRoomStatus(int roomId) {
        RoomDTO room = findRoomById(roomId);
        if (room != null) {
            System.out.println("병실 ID: " + room.getRoomId());
            System.out.println("병실 유형: " + room.getRoomType());
            System.out.println("이용 가능 여부: " + room.isAvailability());
            System.out.print("배정된 환자 목록: ");
            if (room.getAssignedPatients().isEmpty()) {
                System.out.println("없음");
            } else {
                for (PatientDTO patient : room.getAssignedPatients()) {
                    System.out.print(patient.getName() + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("해당 ID의 병실이 없습니다.");
        }
    }

    private RoomDTO findRoomById(int roomId) {
        for (RoomDTO room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }
}
