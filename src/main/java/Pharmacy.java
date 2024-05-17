public class Pharmacy {
    // 약품의 고유 ID
    private int drugId;
    // 약품 이름
    private String drugName;
    // 약품 재고 수량
    private int stockQuantity;
    // 약품 가격
    private double price;

    // 생성자
    public Pharmacy(int drugId, String drugName, int stockQuantity, double price) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    // 약품 추가
    public void addDrug(int quantity) {
        this.stockQuantity += quantity;
        System.out.println("약품이 성공적으로 추가되었습니다. 새로운 재고 수량: " + stockQuantity);
    }

    // 약품 정보 업데이트
    public void updateDrugInfo(String newName, double newPrice) {
        this.drugName = newName;
        this.price = newPrice;
        System.out.println("약품 정보가 성공적으로 업데이트되었습니다.");
    }

    // 약품 정보 조회
    public void viewDrugInfo() {
        System.out.println("약품 ID: " + drugId);
        System.out.println("약품 이름: " + drugName);
        System.out.println("재고 수량: " + stockQuantity);
        System.out.println("가격: " + price);
    }

    // 약품 조제
    public void dispenseDrug(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            System.out.println("약품이 성공적으로 조제되었습니다. 새로운 재고 수량: " + stockQuantity);
        } else {
            System.out.println("재고가 부족합니다.");
        }
    }

    // Getter 및 Setter 메소드
    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
