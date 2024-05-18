import java.util.ArrayList;
import java.util.List;

public class Patient extends User {
    private List<String> medicalHistory;
    private List<String> currentMedication;
    private Doctor assignedDoctor;

    public Patient(String name, int age, String contactInfo, Doctor assignedDoctor) {
        super(name, age, contactInfo);
        this.medicalHistory = new ArrayList<>();
        this.currentMedication = new ArrayList<>();
        this.assignedDoctor = assignedDoctor;
    }

    // 환자 정보를 출력하는 메소드
    @Override
    public void viewInfo() {
        super.viewInfo();
        if (assignedDoctor != null) {
            System.out.println("배정된 의사: " + assignedDoctor.getName());
        }
        viewMedicalHistory();
        viewCurrentMedication();
    }

    // 진료 기록을 출력하는 메소드
    public void viewMedicalHistory() {
        if (medicalHistory.isEmpty()) {
            System.out.println("진료 기록이 없습니다.");
        } else {
            System.out.println("진료 기록: " + medicalHistory);
        }
    }

    // 진료 기록을 업데이트하는 메소드
    public void updateMedicalHistory(String newRecord) {
        if (newRecord == null || newRecord.trim().isEmpty()) {
            throw new IllegalArgumentException("유효한 진료 기록을 입력해야 합니다.");
        }
        medicalHistory.add(newRecord);
        System.out.println("새 진료 기록이 추가되었습니다: " + newRecord);
    }

    // 현재 복용 중인 약물을 출력하는 메소드
    public void viewCurrentMedication() {
        if (currentMedication.isEmpty()) {
            System.out.println("현재 복용 중인 약물이 없습니다.");
        } else {
            System.out.println("현재 복용 약물: " + currentMedication);
        }
    }

    // 현재 복용 중인 약물을 업데이트하는 메소드
    public void updateCurrentMedication(String newMedication) {
        if (newMedication == null || newMedication.trim().isEmpty()) {
            throw new IllegalArgumentException("유효한 약물 정보를 입력해야 합니다.");
        }
        currentMedication.add(newMedication);
        System.out.println("새 약물이 추가되었습니다: " + newMedication);
    }

    // Getter와 Setter 메소드
    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        if (medicalHistory == null) {
            throw new IllegalArgumentException("진료 기록은 null일 수 없습니다.");
        }
        this.medicalHistory = medicalHistory;
    }

    public List<String> getCurrentMedication() {
        return currentMedication;
    }

    public void setCurrentMedication(List<String> currentMedication) {
        if (currentMedication == null) {
            throw new IllegalArgumentException("현재 복용 중인 약물 목록은 null일 수 없습니다.");
        }
        this.currentMedication = currentMedication;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(Doctor assignedDoctor) {
        if (assignedDoctor == null) {
            throw new IllegalArgumentException("유효한 의사 정보를 입력해야 합니다.");
        }
        this.assignedDoctor = assignedDoctor;
    }
}
