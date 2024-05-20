package com.hospital.manager;

import com.hospital.dto.PatientDTO;
import com.hospital.dto.RoomDTO;
import com.hospital.dto.RoomType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManager {
    private static List<RoomDTO> rooms = new ArrayList<>();

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 병실 추가");
            System.out.println("2. 병실 정보 보기");
            System.out.println("3. 병실 배정");
            System.out.println("4. 병실 배정 해제");
            System.out.println("5. 병실 상태 보기");
            System.out.println("6. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            switch (choice) {
                case 1:
                    addRoom(scanner);
                    break;
                case 2:
                    viewRoomInfo(scanner);
                    break;
                case 3:
                    assignRoom(scanner);
                    break;
                case 4:
                    releaseRoom(scanner);
                    break;
                case 5:
                    viewRoomStatus(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addRoom(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  // Enter key 처리
        System.out.print("병실 유형 (GENERAL, ICU, PRIVATE, WARD): ");
        String roomTypeStr = scanner.nextLine();
        RoomType roomType;
        try {
            roomType = RoomType.valueOf(roomTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 병실 유형입니다.");
            return;
        }
        RoomDTO room = new RoomDTO(roomId, roomType);
        rooms.add(room);
        System.out.println("병실이 추가되었습니다.");
    }

    private static void viewRoomInfo(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  // Enter key 처리
        RoomDTO room = findRoomById(roomId);
        if (room != null) {
            viewRoomStatus(room);
        } else {
            System.out.println("해당 ID의 병실이 없습니다.");
        }
    }

    private static void assignRoom(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  // Enter key 처리
        RoomDTO room = findRoomById(roomId);
        if (room == null) {
            System.out.println("해당 ID의 병실이 없습니다.");
            return;
        }
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        PatientDTO patient = PatientManager.findPatientByName(patientName);
        if (patient != null) {
            room.assignRoom(patient);
            System.out.println(patient.getName() + " 환자가 병실에 배정되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    private static void releaseRoom(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  // Enter key 처리
        RoomDTO room = findRoomById(roomId);
        if (room == null) {
            System.out.println("해당 ID의 병실이 없습니다.");
            return;
        }
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        PatientDTO patient = PatientManager.findPatientByName(patientName);
        if (patient != null) {
            room.releaseRoom(patient);
            System.out.println(patient.getName() + " 환자가 병실에서 해제되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    private static void viewRoomStatus(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  // Enter key 처리
        RoomDTO room = findRoomById(roomId);
        if (room != null) {
            viewRoomStatus(room);
        } else {
            System.out.println("해당 ID의 병실이 없습니다.");
        }
    }

    private static void viewRoomStatus(RoomDTO room) {
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
    }

    private static RoomDTO findRoomById(int roomId) {
        for (RoomDTO room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }
}
