public abstract class Crew extends User {
    private boolean isOnDuty;
    private double salary;

    public Crew(String name, int age, String contactInfo, boolean isOnDuty, double salary) {
        super(name, age, contactInfo);
        if (salary < 0) {
            throw new IllegalArgumentException("월급은 음수일 수 없습니다.");
        }
        this.isOnDuty = isOnDuty;
        this.salary = salary;
    }

    @Override
    public void viewInfo() {
        super.viewInfo();
        System.out.println("근무 상태: " + (isOnDuty ? "출근 중" : "퇴근 중"));
        System.out.println("월급: " + salary);
    }

    // Getter와 Setter 메소드
    public boolean isOnDuty() {
        return isOnDuty;
    }

    public void setOnDuty(boolean onDuty) {
        isOnDuty = onDuty;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("월급은 음수일 수 없습니다.");
        }
        this.salary = salary;
    }
}
