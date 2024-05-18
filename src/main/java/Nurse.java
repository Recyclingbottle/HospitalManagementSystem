import java.util.ArrayList;
import java.util.List;

public class Nurse extends Crew {
    private List<String> assignedWards;

    public Nurse(String name, int age, String contactInfo, boolean isOnDuty, double salary) {
        super(name, age, contactInfo, isOnDuty, salary);
        this.assignedWards = new ArrayList<>();
    }

    // 간호사 정보를 출력하는 메소드
    @Override
    public void viewInfo() {
        super.viewInfo();
        viewAssignedWards();
    }

    // 배정된 병동 목록을 출력하는 메소드
    public void viewAssignedWards() {
        if (assignedWards.isEmpty()) {
            System.out.println("배정된 병동이 없습니다.");
        } else {
            System.out.println("배정된 병동 목록:");
            for (String ward : assignedWards) {
                System.out.println("- " + ward);
            }
        }
    }

    // 병동을 추가하는 메소드
    public void addWard(String ward) {
        if (ward == null || ward.trim().isEmpty()) {
            throw new IllegalArgumentException("유효한 병동 이름을 입력해야 합니다.");
        }
        if (!assignedWards.contains(ward)) {
            assignedWards.add(ward);
            System.out.println(ward + " 병동이 배정되었습니다.");
        } else {
            System.out.println("해당 병동은 이미 배정되어 있습니다.");
        }
    }

    // 병동을 제거하는 메소드
    public void removeWard(String ward) {
        if (ward == null || ward.trim().isEmpty()) {
            throw new IllegalArgumentException("유효한 병동 이름을 입력해야 합니다.");
        }
        if (assignedWards.contains(ward)) {
            assignedWards.remove(ward);
            System.out.println(ward + " 병동이 해제되었습니다.");
        } else {
            System.out.println("해당 병동은 배정되지 않았습니다.");
        }
    }

    // Getter와 Setter 메소드
    public List<String> getAssignedWards() {
        return assignedWards;
    }

    public void setAssignedWards(List<String> assignedWards) {
        if (assignedWards == null) {
            throw new IllegalArgumentException("배정된 병동 목록은 null일 수 없습니다.");
        }
        this.assignedWards = assignedWards;
    }
}
