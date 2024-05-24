## **종합 병원 관리 시스템, Comprehensive Hospital Management System**

1. **사용자 관리**
    - 사용자 정보 조회
2. **직원 관리 (Crew Management)**
    - 직원 정보 조회
    - 직원의 근무 상태 및 월급 관리
3. **의사 관리 (Doctor Management)**
    - 의사 정보 조회
    - 의사의 전문 분야 관리
    - 의사에게 환자 배정
    - 의사에게 배정된 환자 목록 조회
    - 배정된 환자 해제
4. **전문의사 관리 (Specialist Doctor Management)**
    - 전문의사 정보 조회
    - 전문의사 하위 전문 분야 관리
5. **간호사 관리 (Nurse Management)**
    - 간호사 정보 조회
    - 간호사에게 병동 배정
    - 간호사에게 배정된 병동 목록 조회
    - 배정된 병동 해제
6. **환자 관리 (Patient Management)**
    - 환자 정보 조회
    - 환자의 진료 기록 관리
    - 환자의 현재 복용 중인 약물 관리
    - 환자에게 배정된 의사 정보 관리
7. **진료 예약 관리 (Appointment Management)**
    - 진료 예약 생성
    - 진료 예약 정보 업데이트
    - 진료 예약 취소
    - 진료 예약 정보 조회
8. **병실 관리 (Room Management)**
    - 병실 정보 조회
    - 병실에 환자 배정
    - 배정된 환자 해제
    - 병실 상태 조회
9. **약국 관리 (Pharmacy Management)**
    - 약품 정보 조회
    - 약품 재고 추가
    - 약품 정보 업데이트
    - 약품 조제 및 재고 관리
10. **진료 기록 관리 (Medical Record Management)**
    - 진료 기록 추가
    - 진료 기록 업데이트
    - 진료 기록 조회
11. **청구 및 결제 관리 (Billing Management)**
    - 청구서 생성
    - 결제 상태 업데이트
    - 청구서 조회

## 클래스 설계

![image](https://github.com/Recyclingbottle/HospitalManagementSystem/assets/101244968/575c2c6f-e2b9-4b39-a2d4-5819d8ca1e11)
![이미지링크](https://www.plantuml.com/plantuml/png/lLVRRkCs47tNLn3xKWLDVg0eZ7LZepMmoGQsjukYA0fQuZe495Abg2oCHV-zueMUuIM9Yw3Tbr0pepc7HtFnlXyrLNhgkwhwZgpO5ouOqO-ChFOVITFHSMHZPV-IvJ18BdJFX3RERnMP_ztC5aB1iscT-O5gxWC7TtJsbMoqLCRSsfEtKirm5lFiF3kjk3XYtvxtiM_KL4zZzNVbUVx4ksws9nmFpleQlrPEXuuHBJNjbhsSh1sm1deo77O9vArYNmCU10lQCoJICQRTIA5fepVYYtJsWvGTeuBmyQDOJVeK4HffHzK94477_neprdfW3QTT2Fp0H_qZIBaWCpL-5AprDYJH7MjvGxijQwHgas-ZhF4DfVF4HvuNJSlfKSYHZv5LAqPj8G6t-qcDx7_H4bHpMK2nprIrI2uGuMsaGBG0v2m59htxGh_CDbcasanApPpSbzHS2bIEQZg-nlMlYGhD4rq6nHk6hlr8LK-R4yfrHmVFu3h0B4Wx7pRYQMOZSLTifUpJsffDeRACUtyQ657-47yu-aHvHm-yu_-glfcOUX9IU-YVr_VhxVA3FMzkFzc_3zlDhylzsfu_BxShysuqSdTCFV66FJzsGy0tn0xSdY4ykxh_dhOj2ghpzhecQMlDbi94lYR5QUpiC8cl7Emqj5GpZ9oj2WyZs5UStZoRj3vFGqN3kXVp-CWZqoXihA_83wIaKROgIhh25bc4tJ5wGcQ0CEylofalaKYJ1xn4wcWvOGsS7-xc4U5UcAEBCX-0D-HX-TlT-dx_vsw_t7_QhNTpl4lx-n_npYfTtDZjhPlvSCVw0rDGIBTdM-tZK1XGXJ34DYHEbrY9XFEuLhT7eE1STLgo0Euy21YIFREEIWoY04kannRW4mNMwMlnMq0oYWEkEMoofKfKhSDI5EO4rAoZ3cxd1GhM3j2G9jj205gSYg7m0TWx2yq1yDu7173AV2Ca7F2Y6Fpv36_MH1rMabaL2DN7MbIK9DuXfGlxtRAmomEkQimrB9fhaYqP03SkTD-GCLi4jr9e9RkEgUTt0SG4beL5GJEJup8RfdhNK26O8gFxUvMDnHmYcPU7wD65n2KJFljbw32OScWyhXeuNv0np9ayPpn_MdYwC6_Kh7dwuepfiV52C6Z_70HF1TVX5oU51i_IllapGkFckTEM3lrxMNReqZmpzAvhluioGkyfrjdVjUCZ7yOg-V_kpSq2_IelUSzxfeB5dBuMOZ97L2oN-W7Hba4mlyC_szzLa2LvoSWLh65iWJ76XrdfN7wyLbK-TgmVcP4YE094gbnpWyiyWrhOuooP83WaSformH51hA0C-8fNncwyCd2r1GbJIQ16OrMWb_9XYyHvEIYcRrLC8f2mNima858urZI9BEdjf4q2iTn1uPU9vwCYqZg49JqV90_kwZqJxTHt_m00)
PlantUML Web Server 를 이용하여 클래스 다이어그램을 만들어보았습니다. 

```
@startuml

' Define the DTO classes
class AppointmentDTO {
    -int appointmentId
    -PatientDTO patient
    -DoctorDTO doctor
    -Date appointmentDate
    -String appointmentTime
    -String status
}

class BillingDTO {
    -int billingId
    -PatientDTO patient
    -double totalAmount
    -String paymentStatus
}

class CrewDTO {
    -String name
    -int age
    -String contactInfo
    -boolean isOnDuty
    -double salary
}

class DoctorDTO {
    -String name
    -int age
    -String contactInfo
    -boolean isOnDuty
    -double salary
    -String specialty
    -List<PatientDTO> assignedPatients
}

class MedicalRecordDTO {
    -int recordId
    -PatientDTO patient
    -DoctorDTO doctor
    -Date visitDate
    -String diagnosis
    -String treatment
}

class NurseDTO {
    -String name
    -int age
    -String contactInfo
    -boolean isOnDuty
    -double salary
    -List<String> assignedWards
}

class PatientDTO {
    -String name
    -int age
    -String contactInfo
    -DoctorDTO assignedDoctor
    -List<String> medicalHistory
    -List<String> currentMedication
}

class DrugDTO {
    -String name
    -int quantity
    -double price
}

class PharmacyDTO {
    -Map<String, DrugDTO> drugInventory
}

class RoomDTO {
    -int roomId
    -RoomType roomType
    -boolean availability
    -List<PatientDTO> assignedPatients
}

enum RoomType {
    GENERAL
    ICU
    PRIVATE
    WARD
}

' Define the Service classes
class AppointmentService {
    -List<AppointmentDTO> appointments
    +addAppointment(PatientDTO patient, DoctorDTO doctor, Date appointmentDate, String appointmentTime, String status)
    +updateAppointment(int appointmentId, Date newDate, String newTime)
    +cancelAppointment(int appointmentId)
    +getAppointments() : List<AppointmentDTO>
}

class BillingService {
    -List<BillingDTO> billings
    +createBilling(PatientDTO patient, double totalAmount)
    +updatePaymentStatus(int billingId, String newStatus)
    +getBillings() : List<BillingDTO>
    +static PAYMENT_STATUSES : String[]
}

class CrewService {
    -List<CrewDTO> crewMembers
    +addCrewMember(CrewDTO crewMember)
    +getCrewMembers() : List<CrewDTO>
}

class DoctorService {
    -List<DoctorDTO> doctors
    +addDoctor(DoctorDTO doctor)
    +getDoctors() : List<DoctorDTO>
}

class MedicalRecordService {
    -List<MedicalRecordDTO> medicalRecords
    +addMedicalRecord(MedicalRecordDTO medicalRecord)
    +getMedicalRecords() : List<MedicalRecordDTO>
}

class NurseService {
    -List<NurseDTO> nurses
    +addNurse(NurseDTO nurse)
    +getNurses() : List<NurseDTO>
}

class PatientService {
    -List<PatientDTO> patients
    +addPatient(PatientDTO patient)
    +getPatients() : List<PatientDTO>
}

class PharmacyService {
    -PharmacyDTO pharmacy
    +addDrug(DrugDTO drug)
    +getPharmacy() : PharmacyDTO
}

class RoomService {
    -List<RoomDTO> rooms
    +addRoom(int roomId, RoomType roomType)
    +getRooms() : List<RoomDTO>
}

' Define the Controller classes
class AppointmentController {
    -AppointmentService appointmentService
    +menu(Scanner scanner)
}

class BillingController {
    -BillingService billingService
    -PatientService patientService
    +menu(Scanner scanner)
}

class CrewController {
    -CrewService crewService
    +menu(Scanner scanner)
}

class DoctorController {
    -DoctorService doctorService
    +menu(Scanner scanner)
}

class MedicalRecordController {
    -MedicalRecordService medicalRecordService
    +menu(Scanner scanner)
}

class NurseController {
    -NurseService nurseService
    +menu(Scanner scanner)
}

class PatientController {
    -PatientService patientService
    +menu(Scanner scanner)
}

class PharmacyController {
    -PharmacyService pharmacyService
    +menu(Scanner scanner)
}

class RoomController {
    -RoomService roomService
    +menu(Scanner scanner)
}

' Define relationships
AppointmentDTO --> PatientDTO
AppointmentDTO --> DoctorDTO
BillingDTO --> PatientDTO
DoctorDTO --> PatientDTO
MedicalRecordDTO --> PatientDTO
MedicalRecordDTO --> DoctorDTO
NurseDTO --> "List<String>"
PatientDTO --> DoctorDTO
RoomDTO --> RoomType
RoomDTO --> PatientDTO
PharmacyDTO --> DrugDTO

AppointmentService --> AppointmentDTO
BillingService --> BillingDTO
CrewService --> CrewDTO
DoctorService --> DoctorDTO
MedicalRecordService --> MedicalRecordDTO
NurseService --> NurseDTO
PatientService --> PatientDTO
PharmacyService --> PharmacyDTO
RoomService --> RoomDTO

AppointmentController --> AppointmentService
BillingController --> BillingService
BillingController --> PatientService
CrewController --> CrewService
DoctorController --> DoctorService
MedicalRecordController --> MedicalRecordService
NurseController --> NurseService
PatientController --> PatientService
PharmacyController --> PharmacyService
RoomController --> RoomService

@enduml
```

### **클래스 목록 및 설명**

### **DTO (Data Transfer Objects)**

1. **AppointmentDTO**
    - **속성:**
        - **`int appointmentId`**: 예약 ID.
        - **`PatientDTO patient`**: 예약된 환자.
        - **`DoctorDTO doctor`**: 예약된 의사.
        - **`Date appointmentDate`**: 예약 날짜.
        - **`String appointmentTime`**: 예약 시간.
        - **`String status`**: 예약 상태.
    - **메소드:**
        - **`int getAppointmentId()`**: 예약 ID 반환.
        - **`void setAppointmentId(int appointmentId)`**: 예약 ID 설정.
        - **`PatientDTO getPatient()`**: 예약된 환자 반환.
        - **`void setPatient(PatientDTO patient)`**: 예약된 환자 설정.
        - **`DoctorDTO getDoctor()`**: 예약된 의사 반환.
        - **`void setDoctor(DoctorDTO doctor)`**: 예약된 의사 설정.
        - **`Date getAppointmentDate()`**: 예약 날짜 반환.
        - **`void setAppointmentDate(Date appointmentDate)`**: 예약 날짜 설정.
        - **`String getAppointmentTime()`**: 예약 시간 반환.
        - **`void setAppointmentTime(String appointmentTime)`**: 예약 시간 설정.
        - **`String getStatus()`**: 예약 상태 반환.
        - **`void setStatus(String status)`**: 예약 상태 설정.
2. **BillingDTO**
    - **속성:**
        - **`int billingId`**: 청구서 ID.
        - **`PatientDTO patient`**: 청구서가 발급된 환자.
        - **`double totalAmount`**: 총 청구 금액.
        - **`String paymentStatus`**: 결제 상태.
    - **메소드:**
        - **`int getBillingId()`**: 청구서 ID 반환.
        - **`void setBillingId(int billingId)`**: 청구서 ID 설정.
        - **`PatientDTO getPatient()`**: 청구서가 발급된 환자 반환.
        - **`void setPatient(PatientDTO patient)`**: 청구서가 발급된 환자 설정.
        - **`double getTotalAmount()`**: 총 청구 금액 반환.
        - **`void setTotalAmount(double totalAmount)`**: 총 청구 금액 설정.
        - **`String getPaymentStatus()`**: 결제 상태 반환.
        - **`void setPaymentStatus(String paymentStatus)`**: 결제 상태 설정.
3. **CrewDTO**
    - **속성:**
        - **`String name`**: 이름.
        - **`int age`**: 나이.
        - **`String contactInfo`**: 연락처 정보.
        - **`boolean isOnDuty`**: 근무 상태.
        - **`double salary`**: 월급.
    - **메소드:**
        - **`String getName()`**: 이름 반환.
        - **`void setName(String name)`**: 이름 설정.
        - **`int getAge()`**: 나이 반환.
        - **`void setAge(int age)`**: 나이 설정.
        - **`String getContactInfo()`**: 연락처 정보 반환.
        - **`void setContactInfo(String contactInfo)`**: 연락처 정보 설정.
        - **`boolean isOnDuty()`**: 근무 상태 반환.
        - **`void setOnDuty(boolean onDuty)`**: 근무 상태 설정.
        - **`double getSalary()`**: 월급 반환.
        - **`void setSalary(double salary)`**: 월급 설정.
4. **DoctorDTO**
    - **속성:**
        - **`String name`**: 이름.
        - **`int age`**: 나이.
        - **`String contactInfo`**: 연락처 정보.
        - **`boolean isOnDuty`**: 근무 상태.
        - **`double salary`**: 월급.
        - **`String specialty`**: 전문 분야.
        - **`List<PatientDTO> assignedPatients`**: 배정된 환자 목록.
    - **메소드:**
        - **`String getName()`**: 이름 반환.
        - **`void setName(String name)`**: 이름 설정.
        - **`int getAge()`**: 나이 반환.
        - **`void setAge(int age)`**: 나이 설정.
        - **`String getContactInfo()`**: 연락처 정보 반환.
        - **`void setContactInfo(String contactInfo)`**: 연락처 정보 설정.
        - **`boolean isOnDuty()`**: 근무 상태 반환.
        - **`void setOnDuty(boolean onDuty)`**: 근무 상태 설정.
        - **`double getSalary()`**: 월급 반환.
        - **`void setSalary(double salary)`**: 월급 설정.
        - **`String getSpecialty()`**: 전문 분야 반환.
        - **`void setSpecialty(String specialty)`**: 전문 분야 설정.
        - **`List<PatientDTO> getAssignedPatients()`**: 배정된 환자 목록 반환.
        - **`void setAssignedPatients(List<PatientDTO> assignedPatients)`**: 배정된 환자 목록 설정.
5. **MedicalRecordDTO**
    - **속성:**
        - **`int recordId`**: 진료 기록 ID.
        - **`PatientDTO patient`**: 환자.
        - **`DoctorDTO doctor`**: 의사.
        - **`Date visitDate`**: 방문 날짜.
        - **`String diagnosis`**: 진단.
        - **`String treatment`**: 치료.
    - **메소드:**
        - **`int getRecordId()`**: 진료 기록 ID 반환.
        - **`void setRecordId(int recordId)`**: 진료 기록 ID 설정.
        - **`PatientDTO getPatient()`**: 환자 반환.
        - **`void setPatient(PatientDTO patient)`**: 환자 설정.
        - **`DoctorDTO getDoctor()`**: 의사 반환.
        - **`void setDoctor(DoctorDTO doctor)`**: 의사 설정.
        - **`Date getVisitDate()`**: 방문 날짜 반환.
        - **`void setVisitDate(Date visitDate)`**: 방문 날짜 설정.
        - **`String getDiagnosis()`**: 진단 반환.
        - **`void setDiagnosis(String diagnosis)`**: 진단 설정.
        - **`String getTreatment()`**: 치료 반환.
        - **`void setTreatment(String treatment)`**: 치료 설정.
6. **NurseDTO**
    - **속성:**
        - **`String name`**: 이름.
        - **`int age`**: 나이.
        - **`String contactInfo`**: 연락처 정보.
        - **`boolean isOnDuty`**: 근무 상태.
        - **`double salary`**: 월급.
        - **`List<String> assignedWards`**: 배정된 병동 목록.
    - **메소드:**
        - **`String getName()`**: 이름 반환.
        - **`void setName(String name)`**: 이름 설정.
        - **`int getAge()`**: 나이 반환.
        - **`void setAge(int age)`**: 나이 설정.
        - **`String getContactInfo()`**: 연락처 정보 반환.
        - **`void setContactInfo(String contactInfo)`**: 연락처 정보 설정.
        - **`boolean isOnDuty()`**: 근무 상태 반환.
        - **`void setOnDuty(boolean onDuty)`**: 근무 상태 설정.
        - **`double getSalary()`**: 월급 반환.
        - **`void setSalary(double salary)`**: 월급 설정.
        - **`List<String> getAssignedWards()`**: 배정된 병동 목록 반환.
        - **`void setAssignedWards(List<String> assignedWards)`**: 배정된 병동 목록 설정.
7. **PatientDTO**
    - **속성:**
        - **`String name`**: 이름.
        - **`int age`**: 나이.
        - **`String contactInfo`**: 연락처 정보.
        - **`List<String> medicalHistory`**: 진료 기록.
        - **`List<String> currentMedication`**: 현재 복용 중인 약물.
        - **`DoctorDTO assignedDoctor`**: 배정된 의사.
    - **메소드:**
        - **`String getName()`**: 이름 반환.
        - **`void setName(String name)`**: 이름 설정.
        - **`int getAge()`**: 나이 반환.
        - **`void setAge(int age)`**: 나이 설정.
        - **`String getContactInfo()`**: 연락처 정보 반환.
        - **`void setContactInfo(String contactInfo)`**: 연락처 정보 설정.
        - **`List<String> getMedicalHistory()`**: 진료 기록 반환.
        - **`void setMedicalHistory(List<String> medicalHistory)`**: 진료 기록 설정.
        - **`List<String> getCurrentMedication()`**: 현재 복용 중인 약물 반환.
        - **`void setCurrentMedication(List<String> currentMedication)`**: 현재 복용 중인 약물 설정.
        - **`DoctorDTO getAssignedDoctor()`**: 배정된 의사 반환.
        - **`void setAssignedDoctor(DoctorDTO assignedDoctor)`**: 배정된 의사 설정.
8. **RoomDTO**
    - **속성:**
        - **`int roomId`**: 병실 ID.
        - **`RoomType roomType`**: 병실 유형 (Enum).
        - **`boolean availability`**: 이용 가능 여부.
        - **`List<PatientDTO> assignedPatients`**: 배정된 환자 목록.
    - **메소드:**
        - **`int getRoomId()`**: 병실 ID 반환.
        - **`void setRoomId(int roomId)`**: 병실 ID 설정.
        - **`RoomType getRoomType()`**: 병실 유형 반환.
        - **`void setRoomType(RoomType roomType)`**: 병실 유형 설정.
        - **`boolean isAvailability()`**: 이용 가능 여부 반환.
        - **`void setAvailability(boolean availability)`**: 이용 가능 여부 설정.
        - **`List<PatientDTO> getAssignedPatients()`**: 배정된 환자 목록 반환.
        - **`void setAssignedPatients(List<PatientDTO> assignedPatients)`**: 배정된 환자 목록 설정.
9. **DrugDTO**
    - **속성:**
        - **`String name`**: 약품 이름.
        - **`int quantity`**: 재고 수량.
        - **`double price`**: 가격.
    - **메소드:**
        - **`String getName()`**: 약품 이름 반환.
        - **`void setName(String name)`**: 약품 이름 설정.
        - **`int getQuantity()`**: 재고 수량 반환.
        - **`void setQuantity(int quantity)`**: 재고 수량 설정.
        - **`double getPrice()`**: 가격 반환.
        - **`void setPrice(double price)`**: 가격 설정.
10. **PharmacyDTO**
    - **속성:**
        - **`Map<String, DrugDTO> drugInventory`**: 약품 재고 목록.
    - **메소드:**
        - **`Map<String, DrugDTO> getDrugInventory()`**: 약품 재고 목록 반환.
        - **`void setDrugInventory(Map<String, DrugDTO> drugInventory)`**: 약품 재고 목록 설정.

### **Service 클래스 설명**

1. **AppointmentService**
    - **속성:**
        - **`List<AppointmentDTO> appointments`**: 진료 예약 목록.
    - **메소드:**
        - **`void addAppointment(PatientDTO patient, DoctorDTO doctor, Date appointmentDate, String appointmentTime, String status)`**: 진료 예약 추가.
        - **`List<AppointmentDTO> getAppointments()`**: 모든 진료 예약 반환.
        - **`void updateAppointment(int appointmentId, Date newDate, String newTime)`**: 진료 예약 업데이트.
        - **`void cancelAppointment(int appointmentId)`**: 진료 예약 취소.
2. **BillingService**
    - **속성:**
        - **`List<BillingDTO> billings`**: 청구서 목록.
    - **메소드:**
        - **`void createBilling(PatientDTO patient, double totalAmount)`**: 청구서 생성.
        - **`List<BillingDTO> getBillings()`**: 모든 청구서 반환.
        - **`void updatePaymentStatus(int billingId, String newStatus)`**: 결제 상태 업데이트.
3. **CrewService**
    - **속성:**
        - **`List<CrewDTO> crewMembers`**: 병원 직원 목록.
    - **메소드:**
        - **`void addCrewMember(String name, int age, String contactInfo, boolean isOnDuty, double salary)`**: 병원 직원 추가.
        - **`CrewDTO findCrewByName(String name)`**: 이름으로 병원 직원 검색.
        - **`List<CrewDTO> getAllCrewMembers()`**: 모든 병원 직원 반환.
4. **DoctorService**
    - **속성:**
        - **`List<DoctorDTO> doctors`**: 의사 목록.
    - **메소드:**
        - **`void addDoctor(String name, int age, String contactInfo, boolean isOnDuty, double salary, String specialty)`**: 의사 추가.
        - **`DoctorDTO findDoctorByName(String name)`**: 이름으로 의사 검색.
        - **`List<DoctorDTO> getAllDoctors()`**: 모든 의사 반환.
5. **MedicalRecordService**
    - **속성:**
        - **`List<MedicalRecordDTO> medicalRecords`**: 진료 기록 목록.
    - **메소드:**
        - **`void addMedicalRecord(PatientDTO patient, DoctorDTO doctor, Date visitDate, String diagnosis, String treatment)`**: 진료 기록 추가.
        - **`List<MedicalRecordDTO> getMedicalRecords()`**: 모든 진료 기록 반환.
        - **`void updateMedicalRecord(int recordId, String newDiagnosis, String newTreatment)`**: 진료 기록 업데이트.
6. **NurseService**
    - **속성:**
        - **`List<NurseDTO> nurses`**: 간호사 목록.
    - **메소드:**
        - **`void addNurse(String name, int age, String contactInfo, boolean isOnDuty, double salary)`**: 간호사 추가.
        - **`NurseDTO findNurseByName(String name)`**: 이름으로 간호사 검색.
        - **`List<NurseDTO> getAllNurses()`**: 모든 간호사 반환.
7. **PatientService**
    - **속성:**
        - **`List<PatientDTO> patients`**: 환자 목록.
    - **메소드:**
        - **`void addPatient(String name, int age, String contactInfo, String doctorName)`**: 환자 추가.
        - **`PatientDTO findPatientByName(String name)`**: 이름으로 환자 검색.
        - **`List<PatientDTO> getAllPatients()`**: 모든 환자 반환.
        - **`void updateMedicalHistory(PatientDTO patient, String record)`**: 진료 기록 업데이트.
        - **`void updateCurrentMedication(PatientDTO patient, String medication)`**: 현재 복용 약물 업데이트.
8. **PharmacyService**
    - **속성:**
        - **`PharmacyDTO pharmacy`**: 약국.
    - **메소드:**
        - **`void addDrug(String drugName, int quantity, double price)`**: 약품 추가.
        - **`void viewDrugInfo(String drugName)`**: 약품 정보 보기.
        - **`void dispenseDrug(String drugName, int quantity)`**: 약품 조제.
        - **`Map<String, DrugDTO> getAllDrugs()`**: 모든 약품 반환.
9. **RoomService**
    - **속성:**
        - **`List<RoomDTO> rooms`**: 병실 목록.
    - **메소드:**
        - **`void addRoom(int roomId, RoomType roomType)`**: 병실 추가.
        - **`void viewRoomInfo(int roomId)`**: 병실 정보 보기.
        - **`void assignRoom(int roomId, PatientDTO patient)`**: 병실 배정.
        - **`void releaseRoom(int roomId, PatientDTO patient)`**: 병실 배정 해제.
        - **`List<RoomDTO> getAllRooms()`**: 모든 병실 반환.

### **Controller 클래스 설명**

1. **AppointmentController**
    - **메소드:**
        - **`void menu(Scanner scanner)`**: 메뉴 표시 및 입력 처리.
        - **`void addAppointment(Scanner scanner)`**: 진료 예약 추가.
        - **`void viewAppointments()`**: 모든 진료 예약 보기.
        - **`void updateAppointment(Scanner scanner)`**: 진료 예약 업데이트.
        - **`void cancelAppointment(Scanner scanner)`**: 진료 예약 취소.
2. **BillingController**
    - **메소드:**
        - **`void menu(Scanner scanner)`**: 메뉴 표시 및 입력 처리.
        - **`void createBilling(Scanner scanner)`**: 청구서 생성.
        - **`void viewBillingInfo(Scanner scanner)`**: 모든 청구서 보기.
        - **`void updatePaymentStatus(Scanner scanner)`**: 결제 상태 업데이트.
3. **CrewController**
    - **메소드:**
        - **`void menu(Scanner scanner)`**: 메뉴 표시 및 입력 처리.
        - **`void addCrewMember(Scanner scanner)`**: 병원 직원 추가.
        - **`void viewCrewInfo(Scanner scanner)`**: 병원 직원 정보 보기.
        - **`void viewAllCrewMembers()`**: 모든 병원 직원 보기.
4. **DoctorController**
    - **메소드:**
        - **`void menu(Scanner scanner)`**: 메뉴 표시 및 입력 처리.
        - **`void addDoctor(Scanner scanner)`**: 의사 추가.
        - **`void viewDoctorInfo(Scanner scanner)`**: 의사 정보 보기.
        - **`void viewAssignedPatients(Scanner scanner)`**: 의사 배정 환자 보기.
        - **`void addPatientToDoctor(Scanner scanner)`**: 의사에게 환자 추가.
        - **`void removePatientFromDoctor(Scanner scanner)`**: 의사에게서 환자 제거.
5. **MedicalRecordController**
    - **메소드:**
        - **`void menu(Scanner scanner)`**: 메뉴 표시 및 입력 처리.
        - **`void addMedicalRecord(Scanner scanner)`**: 진료 기록 추가.
        - **`void viewMedicalRecords()`**: 모든 진료 기록 보기.
        - **`void updateMedicalRecord(Scanner scanner)`**: 진료 기록 업데이트.
6. **NurseController**
    - **메소드:**
        - **`void menu(Scanner scanner)`**: 메뉴 표시 및 입력 처리.
        - **`void addNurse(Scanner scanner)`**: 간호사 추가.
        - **`void viewNurseInfo(Scanner scanner)`**: 간호사 정보 보기.
        - **`void viewAllNurses()`**: 모든 간호사 보기.
7. **PatientController**
    - **메소드:**
        - **`void menu(Scanner scanner)`**: 메뉴 표시 및 입력 처리.
        - **`void addPatient(Scanner scanner)`**: 환자 추가.
        - **`void viewPatientInfo(Scanner scanner)`**: 환자 정보 보기.
        - **`void updateMedicalHistory(Scanner scanner)`**: 진료 기록 업데이트.
        - **`void updateCurrentMedication(Scanner scanner)`**: 현재 복용 약물 업데이트.
8. **PharmacyController**
    - **메소드:**
        - **`void menu(Scanner scanner)`**: 메뉴 표시 및 입력 처리.
        - **`void addDrug(Scanner scanner)`**: 약품 추가.
        - **`void viewDrugInfo(Scanner scanner)`**: 약품 정보 보기.
        - **`void dispenseDrug(Scanner scanner)`**: 약품 조제.
        - **`void viewAllDrugs(Scanner scanner)`**: 모든 약품 보기.
9. **RoomController**
    - **메소드:**
        - **`void menu(Scanner scanner)`**: 메뉴 표시 및 입력 처리.
        - **`void addRoom(Scanner scanner)`**: 병실 추가.
        - **`void viewRoomInfo(Scanner scanner)`**: 병실 정보 보기.
        - **`void assignRoom(Scanner scanner)`**: 병실 배정.
        - **`void releaseRoom(Scanner scanner)`**: 병실 배정 해제.
        - **`void viewRoomStatus(Scanner scanner)`**: 병실 상태 보기.

### **HospitalManagementSystem 클래스 설명**

1. HospitalManagementSystem
    - `public static void main(String[] args)` 이 존재하는 클래스
    - 무한 while 문을 사용하여 **초기 메뉴 출력** 과 **반복**의 역할을 하는 메인 클래스

## 종합 병원 관리 시스템 예상 시나리오

### **1. 새로운 환자 등록 및 진료 예약**

1. **환자 등록**
    - 접수 담당자는 새로 온 환자의 정보를 입력하여 환자를 등록한다
    - 환자 정보는 이름, 나이, 연락처 등이다
2. **진료 예약**
    - 환자는 진료를 예약하고자 한다.
    - 접수 담당자는 환자에게 적합한 의사를 배정하고, 예약 날짜와 시간을 입력한다.
    - 시스템은 환자의 예약 정보를 저장하고, 예약 확인서를 출력한다.
3. **예약 확인**
    - 환자는 예약 날짜에 병원을 방문하여 접수 데스크에서 예약을 확인한다.

### **2. 의사의 환자 진료 및 진료 기록 작성**

1. **환자 진료**
    - 환자가 예약된 시간에 진료실에 들어간다.
    - 의사는 환자의 진료 기록을 조회하고, 환자의 현재 상태를 진단한다.
2. **진료 기록 작성**
    - 의사는 진료 후 진단 내용과 치료 계획을 진료 기록에 입력한다.
    - 진료 기록에는 진단, 처방된 약물, 치료 계획 등이 포함된다.
3. **진료 기록 업데이트**
    - 의사는 진료 후 환자의 진료 기록을 업데이트하여 최신 정보를 반영한다.

### **3.  약국에서 약물 처방 및 재고 관리**

1. **처방전 확인**
    - 환자는 진료 후 약국에서 처방전을 제출한다.
    - 약사는 처방전을 확인하고, 시스템에서 환자의 처방 정보를 조회한다.
2. **약물 조제**
    - 약사는 처방된 약물을 조제하고, 환자에게 전달한다.
    - 조제된 약물의 수량이 재고에서 차감된다.
3. **재고 관리**
    - 약사가 약물의 재고를 확인하고, 재고가 부족한 경우 시스템을 통해 재고를 추가한다.
    - 약물 정보와 재고 수량이 시스템에 업데이트된다.

### **4. 병실 배정 및 관리**

1. **병실 배정 요청**
    - 환자가 입원이 필요한 상태로 진단되면,
    - 의사는 시스템을 통해 병실 배정을 요청한다.
2. **병실 배정**
    - 병실 관리자 또는 간호사가 시스템에서 이용 가능한 병실을 확인하고, 환자에게 병실을 배정한다.
    - 배정된 병실의 상태가 '사용 중'으로 변경된다.
3. **병실 상태 관리**
    - 환자가 퇴원하는 경우, 병실 관리자는 환자를 병실에서 해제하고 병실 상태를 '사용 가능'으로 업데이트한다.

### **5. 청구서 생성 및 결제 상태 업데이트**

1. **진료 후 청구서 생성**
    - 환자가 진료 및 처방을 받은 후, 시스템은 환자에 대한 청구서를 생성한다.
    - 청구서에는 진료비, 약제비, 입원비 등이 포함된다.
2. **결제 상태 업데이트**
    - 환자가 청구서를 받고, 결제를 완료한다.
    - 결제 후 시스템에서 환자의 결제 상태를 '결제 완료'로 업데이트한다.
3. **청구서 조회**
    - 환자는 언제든지 시스템을 통해 자신의 청구서를 조회하고, 결제 상태를 확인할 수 있다.
