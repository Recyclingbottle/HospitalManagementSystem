import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {
    // 환자 목록
    private static List<Patient> patients = new ArrayList<>();
    // 의사 목록
    private static List<Doctor> doctors = new ArrayList<>();
    // 간호사 목록
    private static List<Nurse> nurses = new ArrayList<>();
    // 전문의사 목록
    private static List<SpecialistDoctor> specialistDoctors = new ArrayList<>();
    // 진료 예약 목록
    private static List<Appointment> appointments = new ArrayList<>();
    // 병실 목록
    private static List<Room> rooms = new ArrayList<>();
    // 약국 목록
    private static List<Pharmacy> pharmacies = new ArrayList<>();
    // 진료 기록 목록
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    // 청구서 목록
    private static List<Billing> billings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
//            System.out.println("종합 병원 관리 시스템에 오신 것을 환영합니다");
            System.out.println("┌────────────────────────────────────────────┐");
            System.out.println("│                                            │");
            System.out.println("│      ⟅⦓⦔⟆⟅⦓⦔⟆⟅⦓⦔⟆⟅⦓⦔⟆⟅⦓⦔⟆⟅⦓⦔⟆         │");
            System.out.println("│                                            │");
            System.out.println("│        Welcome to the Hospital             │");
            System.out.println("│                                            │");
            System.out.println("│        종합 병원 관리 시스템에 오신 것을        │");
            System.out.println("│                환영합니다                    │");
            System.out.println("│                                            │");
            System.out.println("│      ⟆⦓⦔⟅⟆⦓⦔⟅⟆⦓⦔⟅⟆⦓⦔⟅⟆⦓⦔⟅⟆⦓⦔⟅         │");
            System.out.println("│                                            │");
            System.out.println("└────────────────────────────────────────────┘");
            System.out.println("===========================================");
            System.out.println("1. 환자 관리");
            System.out.println("2. 의사 관리");
            System.out.println("3. 간호사 관리");
            System.out.println("4. 전문의사 관리");
            System.out.println("5. 진료 예약 관리");
            System.out.println("6. 병실 관리");
            System.out.println("7. 약국 관리");
            System.out.println("8. 진료 기록 관리");
            System.out.println("9. 청구 및 결제 관리");
            System.out.println("10. 종료");
            System.out.print("원하는 옵션을 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 입력받기

            switch (choice) {
                case 1:
                    managePatients(scanner);
                    break;
                case 2:
                    manageDoctors(scanner);
                    break;
                case 3:
                    manageNurses(scanner);
                    break;
                case 4:
                    manageSpecialistDoctors(scanner);
                    break;
                case 5:
                    manageAppointments(scanner);
                    break;
                case 6:
                    manageRooms(scanner);
                    break;
                case 7:
                    managePharmacy(scanner);
                    break;
                case 8:
                    manageMedicalRecords(scanner);
                    break;
                case 9:
                    manageBilling(scanner);
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }

        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }

    // 환자 관리 기능
    private static void managePatients(Scanner scanner) {
        System.out.println("환자 관리");
        System.out.println("1. 새로운 환자 등록");
        System.out.println("2. 환자 정보 업데이트");
        System.out.println("3. 환자 조회");
        System.out.print("원하는 옵션을 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 입력받기

        switch (choice) {
            case 1:
                System.out.print("환자 이름을 입력하세요: ");
                String name = scanner.nextLine();
                System.out.print("환자 나이를 입력하세요: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // 입력받기
                System.out.print("환자 연락처를 입력하세요: ");
                String contactInfo = scanner.nextLine();
                System.out.print("배정된 의사 이름을 입력하세요: ");
                String assignedDoctor = scanner.nextLine();

                Patient newPatient = new Patient(patients.size() + 1, name, age, contactInfo, assignedDoctor);
                patients.add(newPatient);
                System.out.println("환자가 성공적으로 등록되었습니다.");
                break;

            case 2:
                System.out.print("업데이트할 환자 ID를 입력하세요: ");
                int patientId = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Patient patientToUpdate = findPatientById(patientId);
                if (patientToUpdate != null) {
                    System.out.print("새로운 환자 이름을 입력하세요: ");
                    patientToUpdate.setName(scanner.nextLine());
                    System.out.print("새로운 환자 나이를 입력하세요: ");
                    patientToUpdate.setAge(scanner.nextInt());
                    scanner.nextLine(); // 입력받기
                    System.out.print("새로운 환자 연락처를 입력하세요: ");
                    patientToUpdate.setContactInfo(scanner.nextLine());
                    System.out.println("환자 정보가 성공적으로 업데이트되었습니다.");
                } else {
                    System.out.println("해당 ID의 환자를 찾을 수 없습니다.");
                }
                break;

            case 3:
                System.out.print("조회할 환자 ID를 입력하세요: ");
                int patientIdToView = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Patient patientToView = findPatientById(patientIdToView);
                if (patientToView != null) {
                    patientToView.viewInfo();
                } else {
                    System.out.println("해당 ID의 환자를 찾을 수 없습니다.");
                }
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
    }

    // 의사 관리 기능
    private static void manageDoctors(Scanner scanner) {
        System.out.println("의사 관리");
        System.out.println("1. 새로운 의사 등록");
        System.out.println("2. 의사 정보 업데이트");
        System.out.println("3. 의사 조회");
        System.out.print("원하는 옵션을 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 입력받기

        switch (choice) {
            case 1:
                System.out.print("의사 이름을 입력하세요: ");
                String name = scanner.nextLine();
                System.out.print("의사 나이를 입력하세요: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // 입력받기
                System.out.print("의사 연락처를 입력하세요: ");
                String contactInfo = scanner.nextLine();
                System.out.print("의사 전문 분야를 입력하세요: ");
                String specialty = scanner.nextLine();

                Doctor newDoctor = new Doctor(doctors.size() + 1, name, age, contactInfo, specialty);
                doctors.add(newDoctor);
                System.out.println("의사가 성공적으로 등록되었습니다.");
                break;

            case 2:
                System.out.print("업데이트할 의사 ID를 입력하세요: ");
                int doctorId = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Doctor doctorToUpdate = findDoctorById(doctorId);
                if (doctorToUpdate != null) {
                    System.out.print("새로운 의사 이름을 입력하세요: ");
                    doctorToUpdate.setName(scanner.nextLine());
                    System.out.print("새로운 의사 나이를 입력하세요: ");
                    doctorToUpdate.setAge(scanner.nextInt());
                    scanner.nextLine(); // 입력받기
                    System.out.print("새로운 의사 연락처를 입력하세요: ");
                    doctorToUpdate.setContactInfo(scanner.nextLine());
                    System.out.print("새로운 전문 분야를 입력하세요: ");
                    doctorToUpdate.setSpecialty(scanner.nextLine());
                    System.out.println("의사 정보가 성공적으로 업데이트되었습니다.");
                } else {
                    System.out.println("해당 ID의 의사를 찾을 수 없습니다.");
                }
                break;

            case 3:
                System.out.print("조회할 의사 ID를 입력하세요: ");
                int doctorIdToView = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Doctor doctorToView = findDoctorById(doctorIdToView);
                if (doctorToView != null) {
                    doctorToView.viewInfo();
                    doctorToView.viewAssignedPatients();
                } else {
                    System.out.println("해당 ID의 의사를 찾을 수 없습니다.");
                }
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
    }

    // 간호사 관리 기능
    private static void manageNurses(Scanner scanner) {
        System.out.println("간호사 관리");
        System.out.println("1. 새로운 간호사 등록");
        System.out.println("2. 간호사 정보 업데이트");
        System.out.println("3. 간호사 조회");
        System.out.print("원하는 옵션을 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 입력받기

        switch (choice) {
            case 1:
                System.out.print("간호사 이름을 입력하세요: ");
                String name = scanner.nextLine();
                System.out.print("간호사 나이를 입력하세요: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // 입력받기
                System.out.print("간호사 연락처를 입력하세요: ");
                String contactInfo = scanner.nextLine();

                Nurse newNurse = new Nurse(nurses.size() + 1, name, age, contactInfo);
                nurses.add(newNurse);
                System.out.println("간호사가 성공적으로 등록되었습니다.");
                break;

            case 2:
                System.out.print("업데이트할 간호사 ID를 입력하세요: ");
                int nurseId = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Nurse nurseToUpdate = findNurseById(nurseId);
                if (nurseToUpdate != null) {
                    System.out.print("새로운 간호사 이름을 입력하세요: ");
                    nurseToUpdate.setName(scanner.nextLine());
                    System.out.print("새로운 간호사 나이를 입력하세요: ");
                    nurseToUpdate.setAge(scanner.nextInt());
                    scanner.nextLine(); // 입력받기
                    System.out.print("새로운 간호사 연락처를 입력하세요: ");
                    nurseToUpdate.setContactInfo(scanner.nextLine());
                    System.out.println("간호사 정보가 성공적으로 업데이트되었습니다.");
                } else {
                    System.out.println("해당 ID의 간호사를 찾을 수 없습니다.");
                }
                break;

            case 3:
                System.out.print("조회할 간호사 ID를 입력하세요: ");
                int nurseIdToView = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Nurse nurseToView = findNurseById(nurseIdToView);
                if (nurseToView != null) {
                    nurseToView.viewInfo();
                } else {
                    System.out.println("해당 ID의 간호사를 찾을 수 없습니다.");
                }
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
    }

    // 전문의사 관리 기능
    private static void manageSpecialistDoctors(Scanner scanner) {
        System.out.println("전문의사 관리");
        System.out.println("1. 새로운 전문의사 등록");
        System.out.println("2. 전문의사 정보 업데이트");
        System.out.println("3. 전문의사 조회");
        System.out.print("원하는 옵션을 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 입력받기

        switch (choice) {
            case 1:
                System.out.print("의사 이름을 입력하세요: ");
                String name = scanner.nextLine();
                System.out.print("의사 나이를 입력하세요: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // 입력받기
                System.out.print("의사 연락처를 입력하세요: ");
                String contactInfo = scanner.nextLine();
                System.out.print("의사 전문 분야를 입력하세요: ");
                String specialty = scanner.nextLine();
                System.out.print("의사 하위 전문 분야를 입력하세요: ");
                String subSpecialty = scanner.nextLine();

                SpecialistDoctor newSpecialistDoctor = new SpecialistDoctor(specialistDoctors.size() + 1, name, age, contactInfo, specialty, subSpecialty);
                specialistDoctors.add(newSpecialistDoctor);
                System.out.println("전문의사가 성공적으로 등록되었습니다.");
                break;

            case 2:
                System.out.print("업데이트할 전문의사 ID를 입력하세요: ");
                int specialistDoctorId = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                SpecialistDoctor specialistDoctorToUpdate = findSpecialistDoctorById(specialistDoctorId);
                if (specialistDoctorToUpdate != null) {
                    System.out.print("새로운 의사 이름을 입력하세요: ");
                    specialistDoctorToUpdate.setName(scanner.nextLine());
                    System.out.print("새로운 의사 나이를 입력하세요: ");
                    specialistDoctorToUpdate.setAge(scanner.nextInt());
                    scanner.nextLine(); // 입력받기
                    System.out.print("새로운 의사 연락처를 입력하세요: ");
                    specialistDoctorToUpdate.setContactInfo(scanner.nextLine());
                    System.out.print("새로운 전문 분야를 입력하세요: ");
                    specialistDoctorToUpdate.setSpecialty(scanner.nextLine());
                    System.out.print("새로운 하위 전문 분야를 입력하세요: ");
                    specialistDoctorToUpdate.setSubSpecialty(scanner.nextLine());
                    System.out.println("전문의사 정보가 성공적으로 업데이트되었습니다.");
                } else {
                    System.out.println("해당 ID의 전문의사를 찾을 수 없습니다.");
                }
                break;

            case 3:
                System.out.print("조회할 전문의사 ID를 입력하세요: ");
                int specialistDoctorIdToView = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                SpecialistDoctor specialistDoctorToView = findSpecialistDoctorById(specialistDoctorIdToView);
                if (specialistDoctorToView != null) {
                    specialistDoctorToView.viewSpecialtyInfo();
                } else {
                    System.out.println("해당 ID의 전문의사를 찾을 수 없습니다.");
                }
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
    }

    // 진료 예약 관리 기능
    private static void manageAppointments(Scanner scanner) {
        System.out.println("진료 예약 관리");
        System.out.println("1. 새로운 진료 예약");
        System.out.println("2. 예약 정보 업데이트");
        System.out.println("3. 예약 조회");
        System.out.print("원하는 옵션을 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 입력받기

        switch (choice) {
            case 1:
                System.out.print("환자 ID를 입력하세요: ");
                int patientId = scanner.nextInt();
                scanner.nextLine(); // 입력받기
                System.out.print("의사 ID를 입력하세요: ");
                int doctorId = scanner.nextInt();
                scanner.nextLine(); // 입력받기
                System.out.print("예약 날짜를 입력하세요 (yyyy-MM-dd): ");
                String date = scanner.nextLine();
                System.out.print("예약 시간을 입력하세요 (HH:mm): ");
                String time = scanner.nextLine();

                Appointment newAppointment = new Appointment(appointments.size() + 1, patientId, doctorId, java.sql.Date.valueOf(date), time, "예약됨");
                appointments.add(newAppointment);
                System.out.println("진료 예약이 성공적으로 추가되었습니다.");
                break;

            case 2:
                System.out.print("업데이트할 예약 ID를 입력하세요: ");
                int appointmentId = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Appointment appointmentToUpdate = findAppointmentById(appointmentId);
                if (appointmentToUpdate != null) {
                    System.out.print("새로운 예약 날짜를 입력하세요 (yyyy-MM-dd): ");
                    appointmentToUpdate.setAppointmentDate(java.sql.Date.valueOf(scanner.nextLine()));
                    System.out.print("새로운 예약 시간을 입력하세요 (HH:mm): ");
                    appointmentToUpdate.setAppointmentTime(scanner.nextLine());
                    System.out.println("예약 정보가 성공적으로 업데이트되었습니다.");
                } else {
                    System.out.println("해당 ID의 예약을 찾을 수 없습니다.");
                }
                break;

            case 3:
                System.out.print("조회할 예약 ID를 입력하세요: ");
                int appointmentIdToView = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Appointment appointmentToView = findAppointmentById(appointmentIdToView);
                if (appointmentToView != null) {
                    appointmentToView.viewAppointment();
                } else {
                    System.out.println("해당 ID의 예약을 찾을 수 없습니다.");
                }
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
    }

    // 병실 관리 기능
    private static void manageRooms(Scanner scanner) {
        System.out.println("병실 관리");
        System.out.println("1. 병실 배정");
        System.out.println("2. 병실 해제");
        System.out.println("3. 병실 상태 조회");
        System.out.print("원하는 옵션을 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 입력받기

        switch (choice) {
            case 1:
                System.out.print("환자 ID를 입력하세요: ");
                int patientId = scanner.nextInt();
                scanner.nextLine(); // 입력받기
                System.out.print("병실 ID를 입력하세요: ");
                int roomId = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Room roomToAssign = findRoomById(roomId);
                if (roomToAssign != null && roomToAssign.isAvailable()) {
                    roomToAssign.assignRoom(patientId);
                    System.out.println("병실이 성공적으로 배정되었습니다.");
                } else {
                    System.out.println("해당 병실을 사용할 수 없습니다.");
                }
                break;

            case 2:
                System.out.print("해제할 병실 ID를 입력하세요: ");
                int roomIdToRelease = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Room roomToRelease = findRoomById(roomIdToRelease);
                if (roomToRelease != null && !roomToRelease.isAvailable()) {
                    roomToRelease.releaseRoom();
                    System.out.println("병실이 성공적으로 해제되었습니다.");
                } else {
                    System.out.println("해당 병실을 사용할 수 없습니다.");
                }
                break;

            case 3:
                System.out.print("조회할 병실 ID를 입력하세요: ");
                int roomIdToView = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Room roomToView = findRoomById(roomIdToView);
                if (roomToView != null) {
                    roomToView.viewRoomStatus();
                } else {
                    System.out.println("해당 ID의 병실을 찾을 수 없습니다.");
                }
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
    }

    // 약국 관리 기능
    private static void managePharmacy(Scanner scanner) {
        System.out.println("약국 관리");
        System.out.println("1. 약품 추가");
        System.out.println("2. 약품 정보 업데이트");
        System.out.println("3. 약품 조회");
        System.out.print("원하는 옵션을 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 입력받기

        switch (choice) {
            case 1:
                System.out.print("약품 이름을 입력하세요: ");
                String drugName = scanner.nextLine();
                System.out.print("재고 수량을 입력하세요: ");
                int stockQuantity = scanner.nextInt();
                System.out.print("가격을 입력하세요: ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // 입력받기

                Pharmacy newDrug = new Pharmacy(pharmacies.size() + 1, drugName, stockQuantity, price);
                pharmacies.add(newDrug);
                System.out.println("약품이 성공적으로 추가되었습니다.");
                break;

            case 2:
                System.out.print("업데이트할 약품 ID를 입력하세요: ");
                int drugId = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Pharmacy drugToUpdate = findDrugById(drugId);
                if (drugToUpdate != null) {
                    System.out.print("새로운 약품 이름을 입력하세요: ");
                    drugToUpdate.setDrugName(scanner.nextLine());
                    System.out.print("새로운 가격을 입력하세요: ");
                    drugToUpdate.setPrice(scanner.nextDouble());
                    scanner.nextLine(); // 입력받기
                    System.out.println("약품 정보가 성공적으로 업데이트되었습니다.");
                } else {
                    System.out.println("해당 ID의 약품을 찾을 수 없습니다.");
                }
                break;

            case 3:
                System.out.print("조회할 약품 ID를 입력하세요: ");
                int drugIdToView = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Pharmacy drugToView = findDrugById(drugIdToView);
                if (drugToView != null) {
                    drugToView.viewDrugInfo();
                } else {
                    System.out.println("해당 ID의 약품을 찾을 수 없습니다.");
                }
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
    }

    // 진료 기록 관리 기능
    private static void manageMedicalRecords(Scanner scanner) {
        System.out.println("진료 기록 관리");
        System.out.println("1. 진료 기록 추가");
        System.out.println("2. 진료 기록 업데이트");
        System.out.println("3. 진료 기록 조회");
        System.out.print("원하는 옵션을 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 입력받기

        switch (choice) {
            case 1:
                System.out.print("환자 ID를 입력하세요: ");
                int patientId = scanner.nextInt();
                scanner.nextLine(); // 입력받기
                System.out.print("의사 ID를 입력하세요: ");
                int doctorId = scanner.nextInt();
                scanner.nextLine(); // 입력받기
                System.out.print("방문 날짜를 입력하세요 (yyyy-MM-dd): ");
                String visitDate = scanner.nextLine();
                System.out.print("진단 내용을 입력하세요: ");
                String diagnosis = scanner.nextLine();
                System.out.print("치료 내용을 입력하세요: ");
                String treatment = scanner.nextLine();

                MedicalRecord newRecord = new MedicalRecord(medicalRecords.size() + 1, patientId, doctorId, java.sql.Date.valueOf(visitDate), diagnosis, treatment);
                medicalRecords.add(newRecord);
                System.out.println("진료 기록이 성공적으로 추가되었습니다.");
                break;

            case 2:
                System.out.print("업데이트할 진료 기록 ID를 입력하세요: ");
                int recordId = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                MedicalRecord recordToUpdate = findRecordById(recordId);
                if (recordToUpdate != null) {
                    System.out.print("새로운 진단 내용을 입력하세요: ");
                    recordToUpdate.setDiagnosis(scanner.nextLine());
                    System.out.print("새로운 치료 내용을 입력하세요: ");
                    recordToUpdate.setTreatment(scanner.nextLine());
                    System.out.println("진료 기록이 성공적으로 업데이트되었습니다.");
                } else {
                    System.out.println("해당 ID의 진료 기록을 찾을 수 없습니다.");
                }
                break;

            case 3:
                System.out.print("조회할 진료 기록 ID를 입력하세요: ");
                int recordIdToView = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                MedicalRecord recordToView = findRecordById(recordIdToView);
                if (recordToView != null) {
                    recordToView.viewRecord();
                } else {
                    System.out.println("해당 ID의 진료 기록을 찾을 수 없습니다.");
                }
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
    }

    // 청구 및 결제 관리 기능
    private static void manageBilling(Scanner scanner) {
        System.out.println("청구 및 결제 관리");
        System.out.println("1. 청구서 생성");
        System.out.println("2. 결제 상태 업데이트");
        System.out.println("3. 청구서 조회");
        System.out.print("원하는 옵션을 선택하세요: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // 입력받기

        switch (choice) {
            case 1:
                System.out.print("환자 ID를 입력하세요: ");
                int patientId = scanner.nextInt();
                System.out.print("총 금액을 입력하세요: ");
                double totalAmount = scanner.nextDouble();
                scanner.nextLine(); // 입력받기

                Billing newBill = new Billing(billings.size() + 1, patientId, totalAmount);
                billings.add(newBill);
                System.out.println("청구서가 성공적으로 생성되었습니다.");
                break;

            case 2:
                System.out.print("업데이트할 청구 ID를 입력하세요: ");
                int billingId = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Billing billToUpdate = findBillById(billingId);
                if (billToUpdate != null) {
                    System.out.print("새로운 결제 상태를 입력하세요 (결제됨, 보류 중, 취소됨): ");
                    billToUpdate.setPaymentStatus(scanner.nextLine());
                    System.out.println("결제 상태가 성공적으로 업데이트되었습니다.");
                } else {
                    System.out.println("해당 청구서를 찾을 수 없습니다.");
                }
                break;

            case 3:
                System.out.print("조회할 청구 ID를 입력하세요: ");
                int billingIdToView = scanner.nextInt();
                scanner.nextLine(); // 입력받기

                Billing billToView = findBillById(billingIdToView);
                if (billToView != null) {
                    billToView.viewBill();
                } else {
                    System.out.println("해당 청구서를 찾을 수 없습니다.");
                }
                break;

            default:
                System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
    }

    // 환자 ID로 환자 찾기
    private static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getUserId() == id) {
                return patient;
            }
        }
        return null;
    }

    // 의사 ID로 의사 찾기
    private static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getUserId() == id) {
                return doctor;
            }
        }
        return null;
    }

    // 간호사 ID로 간호사 찾기
    private static Nurse findNurseById(int id) {
        for (Nurse nurse : nurses) {
            if (nurse.getUserId() == id) {
                return nurse;
            }
        }
        return null;
    }

    // 전문의사 ID로 전문의사 찾기
    private static SpecialistDoctor findSpecialistDoctorById(int id) {
        for (SpecialistDoctor specialistDoctor : specialistDoctors) {
            if (specialistDoctor.getUserId() == id) {
                return specialistDoctor;
            }
        }
        return null;
    }

    // 진료 예약 ID로 진료 예약 찾기
    private static Appointment findAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == id) {
                return appointment;
            }
        }
        return null;
    }

    // 병실 ID로 병실 찾기
    private static Room findRoomById(int id) {
        for (Room room : rooms) {
            if (room.getRoomId() == id) {
                return room;
            }
        }
        return null;
    }

    // 약품 ID로 약품 찾기
    private static Pharmacy findDrugById(int id) {
        for (Pharmacy drug : pharmacies) {
            if (drug.getDrugId() == id) {
                return drug;
            }
        }
        return null;
    }

    // 진료 기록 ID로 진료 기록 찾기
    private static MedicalRecord findRecordById(int id) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordId() == id) {
                return record;
            }
        }
        return null;
    }

    // 청구서 ID로 청구서 찾기
    private static Billing findBillById(int id) {
        for (Billing bill : billings) {
            if (bill.getBillingId() == id) {
                return bill;
            }
        }
        return null;
    }
}
