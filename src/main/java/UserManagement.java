import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagement {
    private static List<User> users = new ArrayList<>();

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 사용자 추가");
            System.out.println("2. 사용자 정보 보기");
            System.out.println("3. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();    

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    viewUserInfo(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addUser(Scanner scanner) {
        try {
            System.out.print("사용자 이름: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("이름을 입력해야 합니다.");
            }

            System.out.print("사용자 나이: ");
            int age = scanner.nextInt();
            if (age <= 0) {
                throw new IllegalArgumentException("유효한 나이를 입력해야 합니다.");
            }

            scanner.nextLine();    
            System.out.print("연락처: ");
            String contactInfo = scanner.nextLine();
            if (contactInfo.isEmpty()) {
                throw new IllegalArgumentException("연락처를 입력해야 합니다.");
            }

            User user = new User(name, age, contactInfo);
            users.add(user);
            System.out.println("사용자가 추가되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();    
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();    
        }
    }

    private static void viewUserInfo(Scanner scanner) {
        try {
            System.out.print("사용자 이름: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("이름을 입력해야 합니다.");
            }

            User user = findUserByName(name);
            if (user != null) {
                user.viewInfo();
            } else {
                System.out.println("해당 이름의 사용자가 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
        }
    }

    public static User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
}
