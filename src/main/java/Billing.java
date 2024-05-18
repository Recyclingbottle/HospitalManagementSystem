public class Billing {
    private int billingId;
    private Patient patient;
    private double totalAmount;
    private String paymentStatus;

    // 미리 정의된 결제 상태 목록
    private static final String[] VALID_PAYMENT_STATUSES = {"미결제", "결제 완료"};

    public Billing(int billingId, Patient patient, double totalAmount) {
        if (patient == null) {
            throw new IllegalArgumentException("유효한 환자 정보를 입력해야 합니다.");
        }
        if (totalAmount < 0) {
            throw new IllegalArgumentException("총 청구 금액은 음수일 수 없습니다.");
        }

        this.billingId = billingId;
        this.patient = patient;
        this.totalAmount = totalAmount;
        this.paymentStatus = "미결제";
    }

    // 청구서를 생성하는 메소드
    public void generateBill() {
        System.out.println(patient.getName() + " 환자의 청구서가 생성되었습니다.");
        System.out.println("청구 금액: " + totalAmount);
        System.out.println("결제 상태: " + paymentStatus);
    }

    // 결제 상태를 업데이트하는 메소드
    public void updatePaymentStatus(String newStatus) {
        if (!isValidPaymentStatus(newStatus)) {
            throw new IllegalArgumentException("유효하지 않은 결제 상태입니다. 가능한 상태: " + String.join(", ", VALID_PAYMENT_STATUSES));
        }
        this.paymentStatus = newStatus;
        System.out.println("결제 상태가 " + newStatus + "(으)로 업데이트되었습니다.");
    }

    // 청구서의 상세 정보를 출력하는 메소드
    public void viewBill() {
        System.out.println("청구서 ID: " + billingId);
        System.out.println("환자: " + patient.getName());
        System.out.println("청구 금액: " + totalAmount);
        System.out.println("결제 상태: " + paymentStatus);
    }

    // 결제 상태 유효성 검사 메소드
    private boolean isValidPaymentStatus(String status) {
        for (String validStatus : VALID_PAYMENT_STATUSES) {
            if (validStatus.equals(status)) {
                return true;
            }
        }
        return false;
    }

    // Getter와 Setter 메소드
    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("유효한 환자 정보를 입력해야 합니다.");
        }
        this.patient = patient;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount < 0) {
            throw new IllegalArgumentException("총 청구 금액은 음수일 수 없습니다.");
        }
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        if (!isValidPaymentStatus(paymentStatus)) {
            throw new IllegalArgumentException("유효하지 않은 결제 상태입니다. 가능한 상태: " + String.join(", ", VALID_PAYMENT_STATUSES));
        }
        this.paymentStatus = paymentStatus;
    }
}
