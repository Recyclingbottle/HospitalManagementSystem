import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AppointmentManagement {
    private static List<Appointment> appointments = new ArrayList<>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public static void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 진료 예약 추가");
            System.out.println("2. 진료 예약 정보 보기");
            System.out.println("3. 진료 예약 업데이트");
            System.out.println("4. 진료 예약 취소");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();   

            switch (choice) {
                case 1:
                    addAppointment(scanner);
                    break;
                case 2:
                    viewAppointmentInfo(scanner);
                    break;
                case 3:
                    updateAppointment(scanner);
                    break;
                case 4:
                    cancelAppointment(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private static void addAppointment(Scanner scanner) {
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

        System.out.print("예약 날짜 (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        Date appointmentDate;
        try {
            appointmentDate = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("날짜 형식이 잘못되었습니다.");
            return;
        }

        System.out.print("예약 시간 (HH:mm): ");
        String appointmentTime = scanner.nextLine();
        try {
            timeFormat.parse(appointmentTime);  // 시간 형식 유효성 검사
        } catch (ParseException e) {
            System.out.println("시간 형식이 잘못되었습니다.");
            return;
        }

        System.out.print("상태: ");
        String status = scanner.nextLine();

        try {
            Appointment appointment = new Appointment(patient, doctor, appointmentDate, appointmentTime, status);
            appointments.add(appointment);
            System.out.println("진료 예약이 추가되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("예약 추가 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void viewAppointmentInfo(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        Appointment appointment = findAppointmentByPatientName(patientName);
        if (appointment != null) {
            appointment.viewAppointment();
        } else {
            System.out.println("해당 이름의 진료 예약이 없습니다.");
        }
    }

    private static void updateAppointment(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        Appointment appointment = findAppointmentByPatientName(patientName);
        if (appointment != null) {
            System.out.print("새 예약 날짜 (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            Date newDate;
            try {
                newDate = dateFormat.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("날짜 형식이 잘못되었습니다.");
                return;
            }

            System.out.print("새 예약 시간 (HH:mm): ");
            String newTime = scanner.nextLine();
            try {
                timeFormat.parse(newTime);  // 시간 형식 유효성 검사
            } catch (ParseException e) {
                System.out.println("시간 형식이 잘못되었습니다.");
                return;
            }

            appointment.updateAppointment(newDate, newTime);
        } else {
            System.out.println("해당 이름의 진료 예약이 없습니다.");
        }
    }

    private static void cancelAppointment(Scanner scanner) {
        System.out.print("환자 이름: ");
        String patientName = scanner.nextLine();
        Appointment appointment = findAppointmentByPatientName(patientName);
        if (appointment != null) {
            appointment.cancelAppointment();
        } else {
            System.out.println("해당 이름의 진료 예약이 없습니다.");
        }
    }

    private static Appointment findAppointmentByPatientName(String name) {
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().getName().equalsIgnoreCase(name)) {
                return appointment;
            }
        }
        return null;
    }
}
