import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicalRecordManagement {
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 진료 기록 추가");
            System.out.println("2. 진료 기록 정보 보기");
            System.out.println("3. 진료 기록 업데이트");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMedicalRecord(scanner);
                    break;
                case 2:
                    viewMedicalRecordInfo(scanner);
                    break;
                case 3:
                    updateMedicalRecord(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addMedicalRecord(Scanner scanner) {
        try {
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            Patient patient = PatientManagement.findPatientByName(patientName);
            if (patient == null) {
                System.out.println("해당 이름의 환자가 없습니다.");
                return;
            }

            System.out.print("의사 이름: ");
            String doctorName = scanner.nextLine();
            Doctor doctor = DoctorManagement.findDoctorByName(doctorName);
            if (doctor == null) {
                System.out.println("해당 이름의 의사가 없습니다.");
                return;
            }

            System.out.print("방문 날짜 (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            Date visitDate;
            try {
                visitDate = dateFormat.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("날짜 형식이 잘못되었습니다.");
                return;
            }

            System.out.print("진단: ");
            String diagnosis = scanner.nextLine();
            System.out.print("치료: ");
            String treatment = scanner.nextLine();

            if (diagnosis == null || diagnosis.trim().isEmpty() || treatment == null || treatment.trim().isEmpty()) {
                throw new IllegalArgumentException("진단과 치료 내용은 비어 있을 수 없습니다.");
            }

            int recordId = medicalRecords.size() + 1;
            MedicalRecord medicalRecord = new MedicalRecord(recordId, patient, doctor, visitDate, diagnosis, treatment);
            medicalRecords.add(medicalRecord);
            medicalRecord.addRecord();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
        }
    }

    private static void viewMedicalRecordInfo(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        MedicalRecord medicalRecord = findMedicalRecordByPatientName(patientName);
        if (medicalRecord != null) {
            medicalRecord.viewRecord();
        } else {
            System.out.println("해당 이름의 진료 기록이 없습니다.");
        }
    }

    private static void updateMedicalRecord(Scanner scanner) {
        try {
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            MedicalRecord medicalRecord = findMedicalRecordByPatientName(patientName);
            if (medicalRecord != null) {
                System.out.print("새 진단: ");
                String newDiagnosis = scanner.nextLine();
                System.out.print("새 치료: ");
                String newTreatment = scanner.nextLine();

                if (newDiagnosis == null || newDiagnosis.trim().isEmpty() || newTreatment == null || newTreatment.trim().isEmpty()) {
                    throw new IllegalArgumentException("진단과 치료 내용은 비어 있을 수 없습니다.");
                }

                medicalRecord.updateRecord(newDiagnosis, newTreatment);
            } else {
                System.out.println("해당 이름의 진료 기록이 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
        }
    }

    private static MedicalRecord findMedicalRecordByPatientName(String name) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getPatient().getName().equalsIgnoreCase(name)) {
                return medicalRecord;
            }
        }
        return null;
    }
}
