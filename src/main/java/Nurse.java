import java.util.ArrayList;
import java.util.List;

public class Nurse extends User {
    // 간호사에게 배정된 병동 목록
    private List<String> assignedWards;

    // 생성자
    public Nurse(int userId, String name, int age, String contactInfo) {
        super(userId, name, age, contactInfo);
        this.assignedWards = new ArrayList<>();
    }

    // 배정된 병동 조회
    public void viewAssignedWards() {
        System.out.println("배정된 병동 목록:");
        for (String ward : assignedWards) {
            System.out.println("- " + ward);
        }
    }

    // 병동 배정
    public void addWard(String ward) {
        assignedWards.add(ward);
        System.out.println("병동이 성공적으로 배정되었습니다: " + ward);
    }

    // 병동 해제
    public void removeWard(String ward) {
        assignedWards.remove(ward);
        System.out.println("병동이 성공적으로 해제되었습니다: " + ward);
    }

    // 간호사 정보 출력 (오버라이딩)
    @Override
    public void viewInfo() {
        super.viewInfo();
        System.out.println("배정된 병동 목록:");
        for (String ward : assignedWards) {
            System.out.println("- " + ward);
        }
    }

    // Getter 및 Setter 메소드
    public List<String> getAssignedWards() {
        return assignedWards;
    }

    public void setAssignedWards(List<String> assignedWards) {
        this.assignedWards = assignedWards;
    }
}
