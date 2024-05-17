public class SpecialistDoctor extends Doctor {
    // 의사의 하위 전문 분야
    private String subSpecialty;

    // 생성자
    public SpecialistDoctor(int userId, String name, int age, String contactInfo, String specialty, String subSpecialty) {
        super(userId, name, age, contactInfo, specialty);
        this.subSpecialty = subSpecialty;
    }

    // 하위 전문 분야 정보 출력
    public void viewSpecialtyInfo() {
        viewInfo();
        System.out.println("하위 전문 분야: " + subSpecialty);
    }

    // 전문의 정보 출력 (오버라이딩)
    @Override
    public void viewInfo() {
        super.viewInfo();
        System.out.println("하위 전문 분야: " + subSpecialty);
    }

    // Getter 및 Setter 메소드
    public String getSubSpecialty() {
        return subSpecialty;
    }

    public void setSubSpecialty(String subSpecialty) {
        this.subSpecialty = subSpecialty;
    }
}
