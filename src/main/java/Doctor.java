import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {
    // 의사의 전문 분야
    private String specialty;
    // 의사에게 배정된 환자 목록
    private List<Patient> assignedPatients;

    // 생성자
    public Doctor(int userId, String name, int age, String contactInfo, String specialty) {
        super(userId, name, age, contactInfo);
        this.specialty = specialty;
        this.assignedPatients = new ArrayList<>();
    }

    // 배정된 환자 조회
    public void viewAssignedPatients() {
        System.out.println("배정된 환자 목록:");
        for (Patient patient : assignedPatients) {
            System.out.println("- 환자 ID: " + patient.getUserId() + ", 이름: " + patient.getName());
        }
    }

    // 환자 배정
    public void addPatient(Patient patient) {
        assignedPatients.add(patient);
        System.out.println("환자가 성공적으로 배정되었습니다: " + patient.getName());
    }

    // 환자 해제
    public void removePatient(Patient patient) {
        assignedPatients.remove(patient);
        System.out.println("환자가 성공적으로 해제되었습니다: " + patient.getName());
    }

    // 의사 정보 출력 (오버라이딩)
    @Override
    public void viewInfo() {
        super.viewInfo();
        System.out.println("전문 분야: " + specialty);
    }

    // Getter 및 Setter 메소드
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Patient> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<Patient> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }
}
