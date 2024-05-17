import java.util.ArrayList;
import java.util.List;

public class Patient extends User {
    // 환자의 진료 기록 목록
    private List<String> medicalHistory;
    // 환자가 현재 복용 중인 약물 목록
    private List<String> currentMedication;
    // 환자에게 배정된 의사 이름 또는 ID
    private String assignedDoctor;

    // 생성자
    public Patient(int userId, String name, int age, String contactInfo, String assignedDoctor) {
        super(userId, name, age, contactInfo);
        this.medicalHistory = new ArrayList<>();
        this.currentMedication = new ArrayList<>();
        this.assignedDoctor = assignedDoctor;
    }

    // 진료 기록 조회
    public void viewMedicalHistory() {
        System.out.println("진료 기록:");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }

    // 진료 기록 업데이트
    public void updateMedicalHistory(String newRecord) {
        medicalHistory.add(newRecord);
        System.out.println("진료 기록이 성공적으로 업데이트되었습니다.");
    }

    // 현재 복용 중인 약물 조회
    public void viewCurrentMedication() {
        System.out.println("현재 복용 중인 약물:");
        for (String medication : currentMedication) {
            System.out.println("- " + medication);
        }
    }

    // 현재 복용 중인 약물 업데이트
    public void updateCurrentMedication(String newMedication) {
        currentMedication.add(newMedication);
        System.out.println("현재 복용 중인 약물이 성공적으로 업데이트되었습니다.");
    }

    // 환자 정보 출력 (오버라이딩)
    @Override
    public void viewInfo() {
        super.viewInfo();
        System.out.println("배정된 의사: " + assignedDoctor);
    }

    // Getter 및 Setter 메소드
    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<String> getCurrentMedication() {
        return currentMedication;
    }

    public void setCurrentMedication(List<String> currentMedication) {
        this.currentMedication = currentMedication;
    }

    public String getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(String assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }
}
