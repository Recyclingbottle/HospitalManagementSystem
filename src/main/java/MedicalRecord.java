import java.util.Date;

public class MedicalRecord {
    private int recordId;
    private Patient patient;
    private Doctor doctor;
    private Date visitDate;
    private String diagnosis;
    private String treatment;

    public MedicalRecord(int recordId, Patient patient, Doctor doctor, Date visitDate, String diagnosis, String treatment) {
        if (patient == null || doctor == null || visitDate == null || diagnosis == null || treatment == null) {
            throw new IllegalArgumentException("모든 필드는 null일 수 없습니다.");
        }
        this.recordId = recordId;
        this.patient = patient;
        this.doctor = doctor;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    // 진료 기록을 추가하는 메소드
    public void addRecord() {
        System.out.println(patient.getName() + " 환자의 진료 기록이 추가되었습니다.");
        viewRecord();
    }

    // 진료 기록을 업데이트하는 메소드
    public void updateRecord(String newDiagnosis, String newTreatment) {
        if (newDiagnosis == null || newTreatment == null || newDiagnosis.trim().isEmpty() || newTreatment.trim().isEmpty()) {
            throw new IllegalArgumentException("진단과 치료 내용은 비어 있을 수 없습니다.");
        }
        this.diagnosis = newDiagnosis;
        this.treatment = newTreatment;
        System.out.println(patient.getName() + " 환자의 진료 기록이 업데이트되었습니다.");
    }

    // 진료 기록의 상세 정보를 출력하는 메소드
    public void viewRecord() {
        System.out.println("진료 기록 ID: " + recordId);
        System.out.println("환자: " + patient.getName());
        System.out.println("의사: " + doctor.getName());
        System.out.println("방문 날짜: " + visitDate);
        System.out.println("진단: " + diagnosis);
        System.out.println("치료: " + treatment);
    }

    // Getter와 Setter 메소드
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
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

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        if (visitDate == null) {
            throw new IllegalArgumentException("유효한 방문 날짜를 입력해야 합니다.");
        }
        this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.trim().isEmpty()) {
            throw new IllegalArgumentException("진단 내용은 비어 있을 수 없습니다.");
        }
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        if (treatment == null || treatment.trim().isEmpty()) {
            throw new IllegalArgumentException("치료 내용은 비어 있을 수 없습니다.");
        }
        this.treatment = treatment;
    }
}
