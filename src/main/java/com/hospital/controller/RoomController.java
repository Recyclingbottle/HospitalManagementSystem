package com.hospital.controller;

import com.hospital.dto.PatientDTO;
import com.hospital.dto.RoomType;
import com.hospital.service.RoomService;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomController {
    private RoomService roomService;
    private ExecutorService executor;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
        this.executor = Executors.newFixedThreadPool(5);
    }

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
            scanner.nextLine();  // Enter key 처리

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executor.submit(new AddRoomTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewRoomInfoTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new AssignRoomTask(scanner, latch));
                    break;
                case 4:
                    executor.submit(new ReleaseRoomTask(scanner, latch));
                    break;
                case 5:
                    executor.submit(new ViewRoomStatusTask(scanner, latch));
                    break;
                case 6:
                    executor.shutdown();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    latch.countDown();
                    break;
            }

            try {
                latch.await();  // 비동기 작업이 완료될 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class AddRoomTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddRoomTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
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
                latch.countDown();
                return;
            }
            roomService.addRoom(roomId, roomType);
            latch.countDown();
        }
    }

    private class ViewRoomInfoTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewRoomInfoTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("병실 ID: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            roomService.viewRoomInfo(roomId);
            latch.countDown();
        }
    }

    private class AssignRoomTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AssignRoomTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("병실 ID: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            PatientDTO patient = new PatientDTO(0, patientName, 0, "");
            roomService.assignRoom(roomId, patient);
            latch.countDown();
        }
    }

    private class ReleaseRoomTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ReleaseRoomTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("병실 ID: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            PatientDTO patient = new PatientDTO(0, patientName, 0, "");
            roomService.releaseRoom(roomId, patient);
            latch.countDown();
        }
    }

    private class ViewRoomStatusTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewRoomStatusTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("병실 ID: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리
            roomService.viewRoomStatus(roomId);
            latch.countDown();
        }
    }
}
