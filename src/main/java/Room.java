public class Room {
    // 병실의 고유 ID
    private int roomId;
    // 병실의 유형 (예: 일반 병실, 중환자실 등)
    private String roomType;
    // 병실의 이용 가능 여부
    private boolean availability;
    // 병실에 배정된 환자의 ID
    private int assignedPatient;

    // 생성자
    public Room(int roomId, String roomType, boolean availability) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.availability = availability;
        this.assignedPatient = -1; // No patient assigned
    }

    // 병실 배정
    public void assignRoom(int patientId) {
        this.assignedPatient = patientId;
        this.availability = false;
        System.out.println("병실이 환자에게 성공적으로 배정되었습니다: " + patientId);
    }

    // 병실 배정 해제
    public void releaseRoom() {
        this.assignedPatient = -1;
        this.availability = true;
        System.out.println("병실 배정이 성공적으로 해제되었습니다.");
    }

    // 병실 상태 조회
    public void viewRoomStatus() {
        System.out.println("병실 ID: " + roomId);
        System.out.println("병실 유형: " + roomType);
        System.out.println("이용 가능 여부: " + (availability ? "사용 가능" : "사용 중"));
        if (!availability) {
            System.out.println("배정된 환자 ID: " + assignedPatient);
        }
    }

    // Getter 및 Setter 메소드
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getAssignedPatient() {
        return assignedPatient;
    }

    public void setAssignedPatient(int assignedPatient) {
        this.assignedPatient = assignedPatient;
    }
}
