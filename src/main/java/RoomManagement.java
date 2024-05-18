import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManagement {
    private static List<Room> rooms = new ArrayList<>();

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

    private static void addRoom(Scanner scanner) {
        try {
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
            Room room = new Room(roomId, roomType);
            rooms.add(room);
            System.out.println("병실이 추가되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();    
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();    
        }
    }

    private static void viewRoomInfo(Scanner scanner) {
        try {
            System.out.print("병실 ID: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();    
            Room room = findRoomById(roomId);
            if (room != null) {
                room.viewRoomStatus();
            } else {
                System.out.println("해당 ID의 병실이 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();    
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();    
        }
    }

    private static void assignRoom(Scanner scanner) {
        try {
            System.out.print("병실 ID: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();    
            Room room = findRoomById(roomId);
            if (room == null) {
                System.out.println("해당 ID의 병실이 없습니다.");
                return;
            }
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            Patient patient = PatientManagement.findPatientByName(patientName);
            if (patient != null) {
                room.assignRoom(patient);
            } else {
                System.out.println("해당 이름의 환자가 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();    
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();    
        }
    }

    private static void releaseRoom(Scanner scanner) {
        try {
            System.out.print("병실 ID: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();    
            Room room = findRoomById(roomId);
            if (room == null) {
                System.out.println("해당 ID의 병실이 없습니다.");
                return;
            }
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            Patient patient = PatientManagement.findPatientByName(patientName);
            if (patient != null) {
                room.releaseRoom(patient);
            } else {
                System.out.println("해당 이름의 환자가 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();    
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();    
        }
    }

    private static void viewRoomStatus(Scanner scanner) {
        try {
            System.out.print("병실 ID: ");
            int roomId = scanner.nextInt();
            scanner.nextLine();    
            Room room = findRoomById(roomId);
            if (room != null) {
                room.viewRoomStatus();
            } else {
                System.out.println("해당 ID의 병실이 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();    
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();    
        }
    }

    private static Room findRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }
}
