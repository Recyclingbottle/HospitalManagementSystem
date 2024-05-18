import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewManagement {
    private static List<Crew> crewMembers = new ArrayList<>();

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 병원 직원 추가");
            System.out.println("2. 병원 직원 정보 보기");
            System.out.println("3. 병원 직원 리스트 보기");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();   

            switch (choice) {
                case 1:
                    addCrewMember(scanner);
                    break;
                case 2:
                    viewCrewInfo(scanner);
                    break;
                case 3:
                    viewAllCrewMembers();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addCrewMember(Scanner scanner) {
        try {
            System.out.print("직원 이름: ");
            String name = scanner.nextLine();
            System.out.print("직원 나이: ");
            int age = scanner.nextInt();
            scanner.nextLine();   
            System.out.print("연락처: ");
            String contactInfo = scanner.nextLine();
            System.out.print("근무 상태 (true/false): ");
            boolean isOnDuty = scanner.nextBoolean();
            System.out.print("월급: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();   

            // Crew는 추상 클래스이므로 인스턴스를 직접 생성할 수 없습니다.
            // 따라서, 구체적인 Crew의 서브 클래스(예: Doctor, Nurse)를 생성합니다.
            // 예시로 간단히 익명 클래스로 Crew 인스턴스를 생성하겠습니다.
            Crew crewMember = new Crew(name, age, contactInfo, isOnDuty, salary) {
            };

            crewMembers.add(crewMember);
            System.out.println("병원 직원이 추가되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();  // 잘못된 입력 처리 후 남은 입력 제거
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();  // 잘못된 입력 처리 후 남은 입력 제거
        }
    }

    private static void viewCrewInfo(Scanner scanner) {
        System.out.print("직원 이름: ");
        String name = scanner.nextLine();
        Crew crewMember = findCrewByName(name);
        if (crewMember != null) {
            crewMember.viewInfo();
        } else {
            System.out.println("해당 이름의 직원이 없습니다.");
        }
    }

    private static void viewAllCrewMembers() {
        if (crewMembers.isEmpty()) {
            System.out.println("등록된 직원이 없습니다.");
        } else {
            for (Crew crew : crewMembers) {
                crew.viewInfo();
                System.out.println("--------------------");
            }
        }
    }

    public static Crew findCrewByName(String name) {
        for (Crew crew : crewMembers) {
            if (crew.getName().equalsIgnoreCase(name)) {
                return crew;
            }
        }
        return null;
    }
}
