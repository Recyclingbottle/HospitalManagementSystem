import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseManagement {
    private static List<Nurse> nurses = new ArrayList<>();

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 간호사 추가");
            System.out.println("2. 간호사 정보 보기");
            System.out.println("3. 배정된 병동 보기");
            System.out.println("4. 병동 배정");
            System.out.println("5. 병동 해제");
            System.out.println("6. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();   

            switch (choice) {
                case 1:
                    addNurse(scanner);
                    break;
                case 2:
                    viewNurseInfo(scanner);
                    break;
                case 3:
                    viewAssignedWards(scanner);
                    break;
                case 4:
                    addWardToNurse(scanner);
                    break;
                case 5:
                    removeWardFromNurse(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addNurse(Scanner scanner) {
        try {
            System.out.print("간호사 이름: ");
            String name = scanner.nextLine();
            System.out.print("간호사 나이: ");
            int age = scanner.nextInt();
            scanner.nextLine();   
            System.out.print("연락처: ");
            String contactInfo = scanner.nextLine();
            System.out.print("근무 상태 (true/false): ");
            boolean isOnDuty = scanner.nextBoolean();
            System.out.print("월급: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();   

            // 생성자에서 발생하는 예외 처리
            Nurse nurse = new Nurse(name, age, contactInfo, isOnDuty, salary);
            nurses.add(nurse);
            System.out.println("간호사가 추가되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();   
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();   
        }
    }

    private static void viewNurseInfo(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String name = scanner.nextLine();
        Nurse nurse = findNurseByName(name);
        if (nurse != null) {
            nurse.viewInfo();
        } else {
            System.out.println("해당 이름의 간호사가 없습니다.");
        }
    }

    private static void viewAssignedWards(Scanner scanner) {
        System.out.print("간호사 이름: ");
        String name = scanner.nextLine();
        Nurse nurse = findNurseByName(name);
        if (nurse != null) {
            nurse.viewAssignedWards();
        } else {
            System.out.println("해당 이름의 간호사가 없습니다.");
        }
    }

    private static void addWardToNurse(Scanner scanner) {
        try {
            System.out.print("간호사 이름: ");
            String nurseName = scanner.nextLine();
            Nurse nurse = findNurseByName(nurseName);
            if (nurse == null) {
                System.out.println("해당 이름의 간호사가 없습니다.");
                return;
            }
            System.out.print("병동 이름: ");
            String wardName = scanner.nextLine();
            nurse.addWard(wardName);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
        }
    }

    private static void removeWardFromNurse(Scanner scanner) {
        try {
            System.out.print("간호사 이름: ");
            String nurseName = scanner.nextLine();
            Nurse nurse = findNurseByName(nurseName);
            if (nurse == null) {
                System.out.println("해당 이름의 간호사가 없습니다.");
                return;
            }
            System.out.print("병동 이름: ");
            String wardName = scanner.nextLine();
            nurse.removeWard(wardName);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
        }
    }

    public static Nurse findNurseByName(String name) {
        for (Nurse nurse : nurses) {
            if (nurse.getName().equalsIgnoreCase(name)) {
                return nurse;
            }
        }
        return null;
    }
}
