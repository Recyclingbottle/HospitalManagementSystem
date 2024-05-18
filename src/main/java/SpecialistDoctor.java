public class SpecialistDoctor extends Doctor {
    private String subSpecialty;

    public SpecialistDoctor(String name, int age, String contactInfo, boolean isOnDuty, double salary, String specialty, String subSpecialty) {
        super(name, age, contactInfo, isOnDuty, salary, specialty);
        this.subSpecialty = subSpecialty;
    }

    // 전문 분야와 하위 전문 분야를 출력하는 메소드
    public void viewSpecialtyInfo() {
        viewInfo();
        System.out.println("하위 전문 분야: " + subSpecialty);
    }

    // 전문의사 정보를 출력하는 메소드 (오버라이딩)
    @Override
    public void viewInfo() {
        super.viewInfo();
        System.out.println("하위 전문 분야: " + subSpecialty);
    }

    // Getter와 Setter 메소드
    public String getSubSpecialty() {
        return subSpecialty;
    }

    public void setSubSpecialty(String subSpecialty) {
        this.subSpecialty = subSpecialty;
    }
}
