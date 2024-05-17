import java.util.Date;

public class Appointment {
    // 진료 예약의 고유 ID
    private int appointmentId;
    // 진료 예약에 해당하는 환자의 ID
    private int patientId;
    // 진료 예약에 해당하는 의사의 ID
    private int doctorId;
    // 진료 예약 날짜
    private Date appointmentDate;
    // 진료 예약 시간
    private String appointmentTime;
    // 진료 예약 상태
    private String status;

    // 생성자
    public Appointment(int appointmentId, int patientId, int doctorId, Date appointmentDate, String appointmentTime, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // 진료 예약 스케줄
    public void scheduleAppointment() {
        System.out.println("진료 예약이 성공적으로 스케줄되었습니다.");
    }

    // 진료 예약 업데이트
    public void updateAppointment(Date newDate, String newTime) {
        this.appointmentDate = newDate;
        this.appointmentTime = newTime;
        System.out.println("진료 예약이 성공적으로 업데이트되었습니다.");
    }

    // 진료 예약 취소
    public void cancelAppointment() {
        this.status = "취소됨";
        System.out.println("진료 예약이 성공적으로 취소되었습니다.");
    }

    // 진료 예약 정보 출력
    public void viewAppointment() {
        System.out.println("예약 ID: " + appointmentId);
        System.out.println("환자 ID: " + patientId);
        System.out.println("의사 ID: " + doctorId);
        System.out.println("예약 날짜: " + appointmentDate);
        System.out.println("예약 시간: " + appointmentTime);
        System.out.println("상태: " + status);
    }

    // Getter 및 Setter 메소드
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
