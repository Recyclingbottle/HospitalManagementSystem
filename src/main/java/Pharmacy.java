import java.util.HashMap;
import java.util.Map;

public class Pharmacy {
    private Map<String, Drug> drugInventory;

    public Pharmacy() {
        this.drugInventory = new HashMap<>();
    }

    // 약품 정보를 출력하는 메소드
    public void viewDrugInfo(String drugName) {
        try {
            if (drugName == null || drugName.trim().isEmpty()) {
                throw new IllegalArgumentException("유효한 약품 이름을 입력해야 합니다.");
            }
            Drug drug = drugInventory.get(drugName);
            if (drug != null) {
                drug.viewInfo();
            } else {
                System.out.println(drugName + " 약품이 존재하지 않습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        }
    }

    // 약품을 추가하는 메소드
    public void addDrug(String drugName, int quantity, double price) {
        try {
            if (drugName == null || drugName.trim().isEmpty() || quantity <= 0 || price <= 0) {
                throw new IllegalArgumentException("유효한 약품 이름, 수량 및 가격을 입력해야 합니다.");
            }
            Drug drug = drugInventory.get(drugName);
            if (drug == null) {
                drug = new Drug(drugName, quantity, price);
                drugInventory.put(drugName, drug);
                System.out.println(drugName + " 약품이 추가되었습니다.");
            } else {
                drug.addQuantity(quantity);
                drug.setPrice(price);
                System.out.println(drugName + " 약품 정보가 업데이트되었습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        }
    }

    // 약품을 조제하는 메소드
    public void dispenseDrug(String drugName, int quantity) {
        try {
            if (drugName == null || drugName.trim().isEmpty() || quantity <= 0) {
                throw new IllegalArgumentException("유효한 약품 이름 및 수량을 입력해야 합니다.");
            }
            Drug drug = drugInventory.get(drugName);
            if (drug != null && drug.getQuantity() >= quantity) {
                drug.dispense(quantity);
                System.out.println(quantity + "개의 " + drugName + " 약품이 조제되었습니다.");
            } else {
                System.out.println(drugName + " 약품의 재고가 부족하거나 존재하지 않습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        }
    }

    // 약국의 모든 약품 정보를 출력하는 메소드
    public void viewAllDrugs() {
        if (drugInventory.isEmpty()) {
            System.out.println("약국에 등록된 약품이 없습니다.");
        } else {
            System.out.println("약국 약품 목록:");
            for (Drug drug : drugInventory.values()) {
                drug.viewInfo();
            }
        }
    }
}

class Drug {
    private String name;
    private int quantity;
    private double price;

    public Drug(String name, int quantity, double price) {
        if (name == null || name.trim().isEmpty() || quantity <= 0 || price <= 0) {
            throw new IllegalArgumentException("유효한 약품 이름, 수량 및 가격을 입력해야 합니다.");
        }
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // 약품 정보를 출력하는 메소드
    public void viewInfo() {
        System.out.println("약품 이름: " + name);
        System.out.println("재고 수량: " + quantity);
        System.out.println("가격: " + price);
    }

    // 재고를 추가하는 메소드
    public void addQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("추가할 수량은 0보다 커야 합니다.");
        }
        this.quantity += quantity;
    }

    // 약품을 조제하는 메소드
    public void dispense(int quantity) {
        if (quantity <= 0 || quantity > this.quantity) {
            throw new IllegalArgumentException("유효한 조제 수량을 입력해야 합니다.");
        }
        this.quantity -= quantity;
    }

    // Getter와 Setter 메소드
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("수량은 0보다 작을 수 없습니다.");
        }
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("가격은 0보다 커야 합니다.");
        }
        this.price = price;
    }
}
