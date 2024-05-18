import java.util.ArrayList;
import java.util.List;

public class Doctor extends Crew {
    private String specialty;
    private List<Patient> assignedPatients;

    public Doctor(String name, int age, String contactInfo, boolean isOnDuty, double salary, String specialty) {
        super(name, age, contactInfo, isOnDuty, salary);
        if (specialty == null || specialty.trim().isEmpty()) {
            throw new IllegalArgumentException("전문 분야는 비어 있을 수 없습니다.");
        }
        this.specialty = specialty;
        this.assignedPatients = new ArrayList<>();
    }

    // 의사 정보를 출력하는 메소드
    @Override
    public void viewInfo() {
        super.viewInfo();
        System.out.println("전문 분야: " + specialty);
        viewAssignedPatients();
    }

    // 환자 목록을 출력하는 메소드
    public void viewAssignedPatients() {
        if (assignedPatients.isEmpty()) {
            System.out.println("배정된 환자가 없습니다.");
        } else {
            System.out.println("배정된 환자 목록:");
            for (Patient patient : assignedPatients) {
                System.out.println("- " + patient.getName());
            }
        }
    }

    // 환자를 추가하는 메소드
    public void addPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("유효한 환자 정보를 입력해야 합니다.");
        }
        if (!assignedPatients.contains(patient)) {
            assignedPatients.add(patient);
            System.out.println(patient.getName() + " 환자가 배정되었습니다.");
        } else {
            System.out.println("해당 환자는 이미 배정되어 있습니다.");
        }
    }

    // 환자를 제거하는 메소드
    public void removePatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("유효한 환자 정보를 입력해야 합니다.");
        }
        if (assignedPatients.contains(patient)) {
            assignedPatients.remove(patient);
            System.out.println(patient.getName() + " 환자가 해제되었습니다.");
        } else {
            System.out.println("해당 환자는 배정되지 않았습니다.");
        }
    }

    // Getter와 Setter 메소드
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        if (specialty == null || specialty.trim().isEmpty()) {
            throw new IllegalArgumentException("전문 분야는 비어 있을 수 없습니다.");
        }
        this.specialty = specialty;
    }

    public List<Patient> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<Patient> assignedPatients) {
        if (assignedPatients == null) {
            throw new IllegalArgumentException("환자 목록은 null일 수 없습니다.");
        }
        this.assignedPatients = assignedPatients;
    }
}
