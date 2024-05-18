import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomId;
    private RoomType roomType;
    private boolean availability;
    private List<Patient> assignedPatients;

    public Room(int roomId, RoomType roomType) {
        if (roomId <= 0) {
            throw new IllegalArgumentException("유효한 병실 ID를 입력해야 합니다.");
        }
        this.roomId = roomId;
        this.roomType = roomType;
        this.availability = true;
        this.assignedPatients = new ArrayList<>();
    }

    // 병실을 환자에게 배정하는 메소드
    public void assignRoom(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("유효한 환자 정보를 입력해야 합니다.");
        }
        if (!assignedPatients.contains(patient)) {
            assignedPatients.add(patient);
            this.availability = false;
            System.out.println(patient.getName() + " 환자가 " + roomType + " 병실에 배정되었습니다.");
        } else {
            System.out.println("해당 환자는 이미 배정되어 있습니다.");
        }
    }

    // 병실 배정을 해제하는 메소드
    public void releaseRoom(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("유효한 환자 정보를 입력해야 합니다.");
        }
        if (assignedPatients.contains(patient)) {
            assignedPatients.remove(patient);
            System.out.println(patient.getName() + " 환자가 " + roomType + " 병실에서 해제되었습니다.");
            if (assignedPatients.isEmpty()) {
                this.availability = true;
            }
        } else {
            System.out.println("해당 환자는 이 병실에 배정되지 않았습니다.");
        }
    }

    // 병실 상태를 출력하는 메소드
    public void viewRoomStatus() {
        System.out.println("병실 ID: " + roomId);
        System.out.println("병실 유형: " + roomType);
        System.out.println("이용 가능 여부: " + availability);
        System.out.print("배정된 환자 목록: ");
        if (assignedPatients.isEmpty()) {
            System.out.println("없음");
        } else {
            for (Patient patient : assignedPatients) {
                System.out.print(patient.getName() + " ");
            }
            System.out.println();
        }
    }

    // Getter와 Setter 메소드
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        if (roomId <= 0) {
            throw new IllegalArgumentException("유효한 병실 ID를 입력해야 합니다.");
        }
        this.roomId = roomId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        if (roomType == null) {
            throw new IllegalArgumentException("유효한 병실 유형을 입력해야 합니다.");
        }
        this.roomType = roomType;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
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
