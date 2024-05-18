import java.util.Scanner;

public class PharmacyManagement {
    private static Pharmacy pharmacy = new Pharmacy();

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 약품 추가");
            System.out.println("2. 약품 정보 보기");
            System.out.println("3. 약품 조제");
            System.out.println("4. 약국 약품 목록 보기");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();   

            switch (choice) {
                case 1:
                    addDrug(scanner);
                    break;
                case 2:
                    viewDrugInfo(scanner);
                    break;
                case 3:
                    dispenseDrug(scanner);
                    break;
                case 4:
                    viewAllDrugs(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addDrug(Scanner scanner) {
        try {
            System.out.print("약품 이름: ");
            String drugName = scanner.nextLine();
            System.out.print("재고 수량: ");
            int quantity = scanner.nextInt();
            System.out.print("가격: ");
            double price = scanner.nextDouble();
            scanner.nextLine();   
            pharmacy.addDrug(drugName, quantity, price);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();   
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();   
        }
    }

    private static void viewDrugInfo(Scanner scanner) {
        try {
            System.out.print("약품 이름: ");
            String drugName = scanner.nextLine();
            pharmacy.viewDrugInfo(drugName);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
        }
    }

    private static void dispenseDrug(Scanner scanner) {
        try {
            System.out.print("약품 이름: ");
            String drugName = scanner.nextLine();
            System.out.print("조제 수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();   
            pharmacy.dispenseDrug(drugName, quantity);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();   
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();   
        }
    }

    private static void viewAllDrugs(Scanner scanner) {
        try {
            pharmacy.viewAllDrugs();
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
        }
    }
}
