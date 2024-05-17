import java.util.Date;

public class MedicalRecord {
    // 진료 기록의 고유 ID
    private int recordId;
    // 진료 기록에 해당하는 환자의 ID
    private int patientId;
    // 진료 기록에 해당하는 의사의 ID
    private int doctorId;
    // 진료 방문 날짜
    private Date visitDate;
    // 진단 내용
    private String diagnosis;
    // 치료 내용
    private String treatment;

    // 생성자
    public MedicalRecord(int recordId, int patientId, int doctorId, Date visitDate, String diagnosis, String treatment) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    // 진료 기록 추가
    public void addRecord() {
        System.out.println("진료 기록이 성공적으로 추가되었습니다.");
    }

    // 진료 기록 업데이트
    public void updateRecord(String newDiagnosis, String newTreatment) {
        this.diagnosis = newDiagnosis;
        this.treatment = newTreatment;
        System.out.println("진료 기록이 성공적으로 업데이트되었습니다.");
    }

    // 진료 기록 조회
    public void viewRecord() {
        System.out.println("기록 ID: " + recordId);
        System.out.println("환자 ID: " + patientId);
        System.out.println("의사 ID: " + doctorId);
        System.out.println("방문 날짜: " + visitDate);
        System.out.println("진단 내용: " + diagnosis);
        System.out.println("치료 내용: " + treatment);
    }

    // Getter 및 Setter 메소드
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
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

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
