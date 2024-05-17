public class Billing {
    // 청구서의 고유 ID
    private int billingId;
    // 청구서에 해당하는 환자의 ID
    private int patientId;
    // 총 청구 금액
    private double totalAmount;
    // 결제 상태
    private String paymentStatus;

    // 생성자
    public Billing(int billingId, int patientId, double totalAmount) {
        this.billingId = billingId;
        this.patientId = patientId;
        this.totalAmount = totalAmount;
        this.paymentStatus = "미결제";
    }

    // 청구서 생성
    public void generateBill() {
        System.out.println("청구서가 성공적으로 생성되었습니다. 총 금액: " + totalAmount);
    }

    // 결제 상태 업데이트
    public void updatePaymentStatus(String newStatus) {
        this.paymentStatus = newStatus;
        System.out.println("결제 상태가 성공적으로 업데이트되었습니다: " + newStatus);
    }

    // 청구서 조회
    public void viewBill() {
        System.out.println("청구서 ID: " + billingId);
        System.out.println("환자 ID: " + patientId);
        System.out.println("총 금액: " + totalAmount);
        System.out.println("결제 상태: " + paymentStatus);
    }

    // Getter 및 Setter 메소드
    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
