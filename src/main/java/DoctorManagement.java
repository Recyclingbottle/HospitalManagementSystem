import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorManagement {
    private static List<Doctor> doctors = new ArrayList<>();

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 의사 추가");
            System.out.println("2. 의사 정보 보기");
            System.out.println("3. 의사 배정 환자 보기");
            System.out.println("4. 환자 추가");
            System.out.println("5. 환자 제거");
            System.out.println("6. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();    

            switch (choice) {
                case 1:
                    addDoctor(scanner);
                    break;
                case 2:
                    viewDoctorInfo(scanner);
                    break;
                case 3:
                    viewAssignedPatients(scanner);
                    break;
                case 4:
                    addPatientToDoctor(scanner);
                    break;
                case 5:
                    removePatientFromDoctor(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    public static void addDoctor(Scanner scanner) {
        try {
            System.out.print("의사 이름: ");
            String name = scanner.nextLine();
            System.out.print("의사 나이: ");
            int age = scanner.nextInt();
            scanner.nextLine();    
            System.out.print("연락처: ");
            String contactInfo = scanner.nextLine();
            System.out.print("근무 상태 (true/false): ");
            boolean isOnDuty = scanner.nextBoolean();
            System.out.print("월급: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();    
            System.out.print("전문 분야: ");
            String specialty = scanner.nextLine();

            Doctor doctor = new Doctor(name, age, contactInfo, isOnDuty, salary, specialty);
            doctors.add(doctor);
            System.out.println("의사가 추가되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();   
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();   
        }
    }

    private static void viewDoctorInfo(Scanner scanner) {
        System.out.print("의사 이름: ");
        String name = scanner.nextLine();
        Doctor doctor = findDoctorByName(name);
        if (doctor != null) {
            doctor.viewInfo();
        } else {
            System.out.println("해당 이름의 의사가 없습니다.");
        }
    }

    private static void viewAssignedPatients(Scanner scanner) {
        System.out.print("의사 이름: ");
        String name = scanner.nextLine();
        Doctor doctor = findDoctorByName(name);
        if (doctor != null) {
            doctor.viewAssignedPatients();
        } else {
            System.out.println("해당 이름의 의사가 없습니다.");
        }
    }

    private static void addPatientToDoctor(Scanner scanner) {
        try {
            System.out.print("의사 이름: ");
            String doctorName = scanner.nextLine();
            Doctor doctor = findDoctorByName(doctorName);
            if (doctor == null) {
                System.out.println("해당 이름의 의사가 없습니다.");
                return;
            }
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            Patient patient = PatientManagement.findPatientByName(patientName);
            if (patient != null) {
                doctor.addPatient(patient);
            } else {
                System.out.println("해당 이름의 환자가 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();   
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();   
        }
    }

    private static void removePatientFromDoctor(Scanner scanner) {
        try {
            System.out.print("의사 이름: ");
            String doctorName = scanner.nextLine();
            Doctor doctor = findDoctorByName(doctorName);
            if (doctor == null) {
                System.out.println("해당 이름의 의사가 없습니다.");
                return;
            }
            System.out.print("환자 이름: ");
            String patientName = scanner.nextLine();
            Patient patient = PatientManagement.findPatientByName(patientName);
            if (patient != null) {
                doctor.removePatient(patient);
            } else {
                System.out.println("해당 이름의 환자가 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력: " + e.getMessage());
            scanner.nextLine();   
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도하세요.");
            scanner.nextLine();   
        }
    }

    public static Doctor findDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                return doctor;
            }
        }
        return null;
    }
}
