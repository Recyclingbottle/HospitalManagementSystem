import java.util.Date;

public class Appointment {
    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private Date appointmentDate;
    private String appointmentTime;
    private String status;

    public Appointment(Patient patient, Doctor doctor, Date appointmentDate, String appointmentTime, String status) {
        if (patient == null || doctor == null || appointmentDate == null || appointmentTime == null || status == null) {
            throw new IllegalArgumentException("모든 필드를 올바르게 입력해야 합니다.");
        }
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // 진료 예약을 스케줄하는 메소드
    public void scheduleAppointment() {
        if (doctor == null || patient == null || appointmentDate == null || appointmentTime == null || status == null) {
            throw new IllegalStateException("예약 정보를 올바르게 설정해야 합니다.");
        }
        System.out.println(doctor.getName() + " 의사와 " + patient.getName() + " 환자의 예약이 " + appointmentDate + " " + appointmentTime + "에 스케줄되었습니다. 상태: " + status);
    }

    // 진료 예약 일자와 시간을 업데이트하는 메소드
    public void updateAppointment(Date newDate, String newTime) {
        if (newDate == null || newTime == null) {
            throw new IllegalArgumentException("새로운 날짜와 시간을 올바르게 입력해야 합니다.");
        }
        this.appointmentDate = newDate;
        this.appointmentTime = newTime;
        System.out.println("예약이 " + appointmentDate + " " + appointmentTime + "로 업데이트되었습니다.");
    }

    // 진료 예약을 취소하는 메소드
    public void cancelAppointment() {
        if (status.equals("취소됨")) {
            System.out.println("해당 예약은 이미 취소되었습니다.");
        } else {
            this.status = "취소됨";
            System.out.println(doctor.getName() + " 의사와 " + patient.getName() + " 환자의 예약이 취소되었습니다.");
        }
    }

    // 진료 예약의 상세 정보를 출력하는 메소드
    public void viewAppointment() {
        if (appointmentId == 0 || patient == null || doctor == null || appointmentDate == null || appointmentTime == null || status == null) {
            throw new IllegalStateException("예약 정보가 올바르게 설정되지 않았습니다.");
        }
        System.out.println("예약 ID: " + appointmentId);
        System.out.println("환자: " + patient.getName());
        System.out.println("의사: " + doctor.getName());
        System.out.println("날짜: " + appointmentDate);
        System.out.println("시간: " + appointmentTime);
        System.out.println("상태: " + status);
    }

    // Getter와 Setter 메소드
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        if (appointmentId <= 0) {
            throw new IllegalArgumentException("유효한 예약 ID를 입력해야 합니다.");
        }
        this.appointmentId = appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("유효한 환자 정보를 입력해야 합니다.");
        }
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("유효한 의사 정보를 입력해야 합니다.");
        }
        this.doctor = doctor;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("유효한 날짜를 입력해야 합니다.");
        }
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        if (appointmentTime == null || appointmentTime.trim().isEmpty()) {
            throw new IllegalArgumentException("유효한 시간을 입력해야 합니다.");
        }
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("유효한 상태를 입력해야 합니다.");
        }
        this.status = status;
    }
}
