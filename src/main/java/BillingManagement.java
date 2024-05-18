import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillingManagement {
    private static List<Billing> billings = new ArrayList<>();
    private static final String[] PAYMENT_STATUSES = {"미결제", "결제 완료"};

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 청구서 생성");
            System.out.println("2. 청구서 정보 보기");
            System.out.println("3. 결제 상태 업데이트");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();   

            switch (choice) {
                case 1:
                    createBilling(scanner);
                    break;
                case 2:
                    viewBillingInfo(scanner);
                    break;
                case 3:
                    updatePaymentStatus(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void createBilling(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        Patient patient = PatientManagement.findPatientByName(patientName);
        if (patient == null) {
            System.out.println("해당 이름의 환자가 없습니다.");
            return;
        }

        System.out.print("청구 금액: ");
        double totalAmount;
        try {
            totalAmount = scanner.nextDouble();
            scanner.nextLine();   
            if (totalAmount < 0) {
                throw new IllegalArgumentException("청구 금액은 음수일 수 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("잘못된 금액입니다. 다시 시도하세요.");
            scanner.nextLine();  // 잘못된 입력 처리 후 남은 입력 제거
            return;
        }

        int billingId = billings.size() + 1;
        try {
            Billing billing = new Billing(billingId, patient, totalAmount);
            billings.add(billing);
            billing.generateBill();
        } catch (IllegalArgumentException e) {
            System.out.println("청구서 생성 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void viewBillingInfo(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        Billing billing = findBillingByPatientName(patientName);
        if (billing != null) {
            billing.viewBill();
        } else {
            System.out.println("해당 이름의 청구서가 없습니다.");
        }
    }

    private static void updatePaymentStatus(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        Billing billing = findBillingByPatientName(patientName);
        if (billing != null) {
            System.out.println("새 결제 상태 번호를 선택하세요:");
            for (int i = 0; i < PAYMENT_STATUSES.length; i++) {
                System.out.println((i + 1) + ". " + PAYMENT_STATUSES[i]);
            }
            System.out.print("선택: ");
            int statusChoice;
            try {
                statusChoice = scanner.nextInt();
                scanner.nextLine();   
                if (statusChoice < 1 || statusChoice > PAYMENT_STATUSES.length) {
                    throw new IllegalArgumentException("잘못된 번호입니다.");
                }
                String newStatus = PAYMENT_STATUSES[statusChoice - 1];
                billing.updatePaymentStatus(newStatus);
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                scanner.nextLine();  // 잘못된 입력 처리 후 남은 입력 제거
            }
        } else {
            System.out.println("해당 이름의 청구서가 없습니다.");
        }
    }

    private static Billing findBillingByPatientName(String name) {
        for (Billing billing : billings) {
            if (billing.getPatient().getName().equalsIgnoreCase(name)) {
                return billing;
            }
        }
        return null;
    }
}
