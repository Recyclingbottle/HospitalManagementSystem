### 병원 관리 시스템 상세 설명

병원 관리 시스템(Hospital Management System)은 자바 과제를 위해 실제 사용을 생각하지 않고 만든 소프트웨어입니당.

이 시스템은 자바(Java)로 작성되었으며, 환자, 의사, 간호사, 병실, 약국, 진료 기록 등 다양한 병원 운영 기능을 포함하고 있습니다.

### 주요 계층

이 시스템은 크게 네 가지 주요 계층으로 나눌 수 있습니다:

1. **컨트롤러(Controller)**
2. **서비스(Service)**
3. **데이터 전송 객체(DTO)**
4. **유틸리티(Utility)**

### 각 계층의 역할

1. **컨트롤러(Controller)**
    - 사용자의 요청을 받아 서비스 계층으로 전달합니다.
    - 각각 요청을 처리하고 적절한 응답을 생성합니다.
2. **서비스(Service)**
    - 비즈니스 로직을 처리합니다.
    - 데이터 전송 객체(DTO)를 사용하여 데이터를 주고받습니다.
3. **데이터 전송 객체(DTO)**
    - 데이터 계층 간의 데이터 전송을 위해 사용됩니다.
    - 단순히 데이터를 저장하고 전달하는 역할을 합니다.
4. **유틸리티(Utility)**
    - 공통적으로 사용되는 헬퍼 메소드나 기능을 제공합니다.
    - 예를 들어, 날짜 형식 변환, 입력 검증 등을 처리합니다.

### 하나의 클래스로 설명해보겠습니다

환자와 관련된 클래스를 가져왔습니다

그전에 제일 먼저 메인 함수를 봅시다

`HospitalManagementSystem`.java

```java
package com.hospital;

import com.hospital.controller.*;
import com.hospital.service.*;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HospitalManagementSystem {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 단일 서비스 인스턴스를 생성
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        NurseService nurseService = new NurseService();
        AppointmentService appointmentService = new AppointmentService();
        BillingService billingService = new BillingService();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        RoomService roomService = new RoomService();
        PharmacyService pharmacyService = new PharmacyService();
        CrewService crewService = new CrewService();
        ChatService chatService = new ChatService();

        // 서비스 인스턴스를 각 컨트롤러에 전달
        AppointmentController appointmentController = new AppointmentController(appointmentService, patientService, doctorService);
        BillingController billingController = new BillingController(billingService, patientService);
        CrewController crewController = new CrewController(crewService);
        DoctorController doctorController = new DoctorController(doctorService, patientService);
        MedicalRecordController medicalRecordController = new MedicalRecordController(medicalRecordService, patientService, doctorService);
        NurseController nurseController = new NurseController(nurseService);
        PatientController patientController = new PatientController(patientService, doctorService);
        PharmacyController pharmacyController = new PharmacyController(pharmacyService);
        RoomController roomController = new RoomController(roomService);
        ChatController chatController = new ChatController(chatService);

        while (true) {
            System.out.println("병원 관리 시스템에 오신 것을 환영합니다.");
            System.out.println("1. 환자 관리");
            System.out.println("2. 의사 관리");
            System.out.println("3. 간호사 관리");
            System.out.println("4. 진료 예약 관리");
            System.out.println("5. 청구 및 결제 관리");
            System.out.println("6. 진료 기록 관리");
            System.out.println("7. 병실 관리");
            System.out.println("8. 약국 관리");
            System.out.println("9. 병원 직원 관리");
            System.out.println("10. 채팅 관리");
            System.out.println("11. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Enter key 처리

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executorService.submit(() -> {
                        try {
                            patientController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 2:
                    executorService.submit(() -> {
                        try {
                            doctorController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 3:
                    executorService.submit(() -> {
                        try {
                            nurseController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 4:
                    executorService.submit(() -> {
                        try {
                            appointmentController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 5:
                    executorService.submit(() -> {
                        try {
                            billingController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 6:
                    executorService.submit(() -> {
                        try {
                            medicalRecordController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 7:
                    executorService.submit(() -> {
                        try {
                            roomController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 8:
                    executorService.submit(() -> {
                        try {
                            pharmacyController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 9:
                    executorService.submit(() -> {
                        try {
                            crewController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 10:
                    executorService.submit(() -> {
                        try {
                            chatController.menu(scanner);
                        } finally {
                            latch.countDown();
                        }
                    });
                    break;
                case 11:
                    executorService.shutdown();
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    latch.countDown();
                    break;
            }

            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("메뉴 대기 중 인터럽트 발생.");
            }
        }
    }
}

```

### 1. PatientDTO.java (데이터 전송 객체)

```java
package com.hospital.dto;

import java.util.ArrayList;
import java.util.List;

public class PatientDTO extends UserDTO {
    private int id;
    private List<String> medicalHistory;
    private List<String> currentMedication;
    private DoctorDTO assignedDoctor;

    public PatientDTO(int id, String name, int age, String contactInfo) {
        super(name, age, contactInfo);
        this.id = id;
        this.medicalHistory = new ArrayList<>();
        this.currentMedication = new ArrayList<>();
    }

    // Getter와 Setter 메소드
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<String> getCurrentMedication() {
        return currentMedication;
    }

    public void setCurrentMedication(List<String> currentMedication) {
        this.currentMedication = currentMedication;
    }

    public DoctorDTO getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(DoctorDTO assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }
}

```

환자의 정보를 캡슐화하여 계층 간 전송합니다. 이 객체는 환자의 ID, 이름, 나이, 성별, 연락처 정보, 의료 기록을 포함합니다.

### 2. PatientService.java (서비스)

```java
package com.hospital.service;

import com.hospital.dto.PatientDTO;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private List<PatientDTO> patients = new ArrayList<>();

    public void addPatient(PatientDTO patient) {
        patients.add(patient);
        System.out.println("환자가 추가되었습니다: " + patient.getName());
    }

    public PatientDTO findPatientByName(String name) {
        for (PatientDTO patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    public PatientDTO findPatientById(int id) {
        for (PatientDTO patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    public List<PatientDTO> getAllPatients() {
        return patients;
    }

    public void updateMedicalHistory(String patientName, String newRecord) {
        PatientDTO patient = findPatientByName(patientName);
        if (patient != null) {
            patient.getMedicalHistory().add(newRecord);
            System.out.println(patientName + " 환자의 진료 기록이 업데이트되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }

    public void updateCurrentMedication(String patientName, String newMedication) {
        PatientDTO patient = findPatientByName(patientName);
        if (patient != null) {
            patient.getCurrentMedication().add(newMedication);
            System.out.println(patientName + " 환자의 현재 복용 약물이 업데이트되었습니다.");
        } else {
            System.out.println("해당 이름의 환자가 없습니다.");
        }
    }
}

```

환자와 관련된 비즈니스 로직을 처리합니다. 환자의 정보 추가, 조회, 수정, 삭제 등의 작업을 수행합니다.

### 3. PatientController.java (컨트롤러)

```java
package com.hospital.controller;

import com.hospital.dto.DoctorDTO;
import com.hospital.dto.PatientDTO;
import com.hospital.service.PatientService;
import com.hospital.service.DoctorService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PatientController {
    private PatientService patientService;
    private DoctorService doctorService;
    private ExecutorService executor;

    public PatientController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.executor = Executors.newFixedThreadPool(5);
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 환자 추가");
            System.out.println("2. 환자 정보 보기");
            System.out.println("3. 진료 기록 업데이트");
            System.out.println("4. 현재 복용 약물 업데이트");
            System.out.println("5. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executor.submit(new AddPatientTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewPatientInfoTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new UpdateMedicalHistoryTask(scanner, latch));
                    break;
                case 4:
                    executor.submit(new UpdateCurrentMedicationTask(scanner, latch));
                    break;
                case 5:
                    executor.shutdown();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    latch.countDown();
                    break;
            }

            try {
                latch.await();  // 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class AddPatientTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddPatientTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("환자 ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("환자 이름: ");
            String name = scanner.nextLine();
            System.out.print("환자 나이: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("연락처: ");
            String contactInfo = scanner.nextLine();
            System.out.print("배정된 의사 이름: ");
            String doctorName = scanner.nextLine();
            DoctorDTO assignedDoctor = doctorService.findDoctorByName(doctorName);
            if (assignedDoctor == null) {
                System.out.println("해당 이름의 의사가 없습니다.");
                latch.countDown();
                return;
            }
            PatientDTO patient = new PatientDTO(id, name, age, contactInfo);
            patient.setAssignedDoctor(assignedDoctor);
            patientService.addPatient(patient);
            latch.countDown();
        }
    }

    private class ViewPatientInfoTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewPatientInfoTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("환자 이름: ");
            String name = scanner.nextLine();
            PatientDTO patient = patientService.findPatientByName(name);
            if (patient != null) {
                System.out.println("이름: " + patient.getName());
                System.out.println("나이: " + patient.getAge());
                System.out.println("연락처: " + patient.getContactInfo());
                if (patient.getAssignedDoctor() != null) {
                    System.out.println("배정된 의사: " + patient.getAssignedDoctor().getName());
                }
                System.out.println("진료 기록: " + patient.getMedicalHistory());
                System.out.println("현재 복용 약물: " + patient.getCurrentMedication());
            } else {
                System.out.println("해당 이름의 환자가 없습니다.");
            }
            latch.countDown();
        }
    }

    private class UpdateMedicalHistoryTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        UpdateMedicalHistoryTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("환자 이름: ");
            String name = scanner.nextLine();
            System.out.print("추가할 진료 기록: ");
            String record = scanner.nextLine();
            patientService.updateMedicalHistory(name, record);
            latch.countDown();
        }
    }

    private class UpdateCurrentMedicationTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        UpdateCurrentMedicationTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("환자 이름: ");
            String name = scanner.nextLine();
            System.out.print("추가할 현재 복용 약물: ");
            String medication = scanner.nextLine();
            patientService.updateCurrentMedication(name, medication);
            latch.countDown();
        }
    }
}

```

환자와 관련된 요청을 처리합니다. 예를 들어, 새로운 환자 등록, 기존 환자 정보 조회, 수정, 삭제 등의 요청을 처리합니다.

### 4. DateUtils.java (유틸리티)

```java
package com.hospital.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.parse(dateStr);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }
}
```

날짜와 관련된 공통 기능을 제공합니다. 예를 들어, 날짜 형식 변환이나 현재 날짜 가져오기 등의 기능을 처리합니다. 환자 관리와 직접적인 연관은 없지만, 환자의 생년월일이나 예약 날짜 등의 처리를 돕습니다.

다른 클래스들도 동일한 구조를 가지고 단순히 CRUD 이외에 추가적인 작업을 하는 것은 없습니다.
