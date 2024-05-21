package com.hospital.controller;

import com.hospital.dto.PatientDTO;
import com.hospital.dto.RoomType;
import com.hospital.service.PatientService;
import com.hospital.service.RoomService;

import java.util.Scanner;

public class RoomController {
    private RoomService roomService = new RoomService();
    private PatientService patientService = new PatientService();

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 병실 추가");
            System.out.println("2. 병실 정보 보기");
            System.out.println("3. 병실 배정");
            System.out.println("4. 병실 배정 해제");
            System.out.println("5. 병실 상태 보기");
            System.out.println("6. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

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

    private void addRoom(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("병실 유형 (GENERAL, ICU, PRIVATE, WARD): ");
        String roomTypeStr = scanner.nextLine();
        RoomType roomType;
        try {
            roomType = RoomType.valueOf(roomTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 병실 유형입니다.");
            return;
        }
        roomService.addRoom(roomId, roomType);
    }

    private void viewRoomInfo(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  
        roomService.viewRoomInfo(roomId);
    }

    private void assignRoom(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        PatientDTO patient = patientService.findPatientByName(patientName);
        if (patient != null) {
            roomService.assignRoom(roomId, patient);
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    private void releaseRoom(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        PatientDTO patient = patientService.findPatientByName(patientName);
        if (patient != null) {
            roomService.releaseRoom(roomId, patient);
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    private void viewRoomStatus(Scanner scanner) {
        System.out.print("병실 ID: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();  
        roomService.viewRoomStatus(roomId);
    }
}
