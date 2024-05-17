# 자바 기본 과제 
CLI 프로그램 제작 (동기 프로그램)
* 콘솔 형태의 프로그램은 어떠한 종류라도 상관 없습니다. 

1. 프로그램 클래스 설계도(다이어그램) 작성하기

1.1 속성, 메서드, 상속의 관계를 먼저 정의 
1.1.1 2차 상속은 최소 하나

2. 설계도 기반 콘솔 프로그램 제작
2.1 사용자에게 입력을 받고 진행이 되는 형태


## 종합 병원 관리 시스템, **Comprehensive Hospital Management System**

1. 환자 관리 (Patient Management)
    - 환자 등록
    - 환자 정보 업데이트
    - 환자 조회
    - 진료 기록 조회
    - 진료 기록 업데이트
    - 현재 복용 중인 약물 조회
    - 현재 복용 중인 약물 업데이트
2. 의사 관리 (Doctor Management)
    - 의사 등록
    - 의사 정보 업데이트
    - 의사 조회
    - 배정된 환자 조회
    - 환자 배정
    - 환자 해제
3. 전문의사 관리 (Specialist Doctor Management)
    - 전문의사 등록
    - 전문의사 정보 업데이트
    - 전문의사 조회
    - 전문 분야 조회
4. 간호사 관리 (Nurse Management)
    - 간호사 등록
    - 간호사 정보 업데이트
    - 간호사 조회
    - 배정된 병동 조회
    - 병동 배정
    - 병동 해제
5. 진료 예약 관리 (Appointment Management)
    - 진료 예약 생성
    - 진료 예약 업데이트
    - 진료 예약 취소
    - 진료 예약 조회
6. 병실 관리 (Room Management)
    - 병실 배정
    - 병실 해제
    - 병실 상태 조회
7. 약국 관리 (Pharmacy Management)
    - 약품 추가
    - 약품 정보 업데이트
    - 약품 조회
    - 약품 조제
8. 진료 기록 관리 (Medical Record Management)
    - 진료 기록 추가
    - 진료 기록 업데이트
    - 진료 기록 조회
9. 청구 및 결제 관리 (Billing and Payment Management)
    - 청구서 생성
    - 결제 상태 업데이트
    - 청구서 조회

## 클래스 설계

www.plantuml.com/plantuml/png/ZLN1RXiX4BtxApWcKl87KPIqFZHI4wLngfx7CDsWih25mP7LzjyBB0iijQoUx7d3l7dpTfQzSmIM_AWsN85pxAj3otvj69EQc0_1WmZ1ZgpK0zCmOax1W1NdHXDmUj3VJG0FHWfsaFWUuulBpPzDvdu6agWfqN-MZcxcybisef0SrAU06NliiznR6yeUqo6IHjV6WLKE6iNMy53PzdvSKGOLEUSd0OHTTXaFtr-G6oikMwQFVVkUxDy3bQ-2b-UScVKdOtAjcv1BK5JSoERTbfapu5hU-ovNfO9Om8lbCKppRpbYSJG7F7-gbS-g_jsiDkWyCOdVx-embQI0YUqy_vEt3lkzgLPy0ojw7sgYDI4Xo_Dv3_-xwVlqULdtqsIafd5PwlHYL2ozEh9uM6EHJ4hX5WZRcXWNxzh4gnoRX2CWNqPs_0s5LzZewPUqJQMUOJdZxnMhonfRb38EcgFg6Ql3RQ8wycBCMAom8MYkZnI_7gSunjuOXQ0P740gs4ibwPYhkltEJJCS-IzQIzi761WTfXChgH7P9RzMbz4Rs17uiQWLrW-DsXG_rGlFaU4_ldZGD4iLnkyLiibAZir-RKDL4lWp7-sUGyodFQgsnoPNcI_6pv5oDK4fAgYGRaBjy4IxCc6-vEOhhJwK5FxtQXwaazrI2Wc3Daww2f55IBlGE37txVSmetNwxSAssiI5RsL3OImZVf1AXP8ot7wEJqwN3IP3eEv7upLL_HCSOxVTwgqQKAC5mjYa7-EvBMYccO6LwbIUDATlwytlw-lbIzWW-GjMWNJbRHASaVwItToX5l7B_HS0

PlantUML Web Server 를 이용하여 클래스 다이어그램을 만들어보았습니다. 

```jsx
@startuml
class User {
  int userId
  String name
  int age
  String contactInfo
  void viewInfo()
}

class Patient {
  List<String> medicalHistory
  List<String> currentMedication
  String assignedDoctor
  void viewMedicalHistory()
  void updateMedicalHistory(String newRecord)
  void viewCurrentMedication()
  void updateCurrentMedication(String newMedication)
  void viewInfo()
}

class Doctor {
  String specialty
  List<Patient> assignedPatients
  void viewAssignedPatients()
  void addPatient(Patient patient)
  void removePatient(Patient patient)
  void viewInfo() 
}

class SpecialistDoctor {
  String subSpecialty
  void viewSpecialtyInfo()
  void viewInfo() 
}

class Nurse {
  List<String> assignedWards
  void viewAssignedWards()
  void addWard(String ward)
  void removeWard(String ward)
  void viewInfo() 
}

class Appointment {
  int appointmentId
  int patientId
  int doctorId
  Date appointmentDate
  String appointmentTime
  String status
  void scheduleAppointment()
  void updateAppointment(Date newDate, String newTime)
  void cancelAppointment()
  void viewAppointment()
}

class Room {
  int roomId
  String roomType
  boolean availability
  int assignedPatient
  void assignRoom(int patientId)
  void releaseRoom()
  void viewRoomStatus()
}

class Pharmacy {
  int drugId
  String drugName
  int stockQuantity
  double price
  void addDrug(int quantity)
  void updateDrugInfo(String newName, double newPrice)
  void viewDrugInfo()
  void dispenseDrug(int quantity)
}

class MedicalRecord {
  int recordId
  int patientId
  int doctorId
  Date visitDate
  String diagnosis
  String treatment
  void addRecord()
  void updateRecord(String newDiagnosis, String newTreatment)
  void viewRecord()
}

class Billing {
  int billingId
  int patientId
  double totalAmount
  String paymentStatus
  void generateBill()
  void updatePaymentStatus(String newStatus)
  void viewBill()
}

User <|-- Patient
User <|-- Doctor
User <|-- Nurse
Doctor <|-- SpecialistDoctor
@enduml

```

### 각 클래스 속성 및 메소드 설명

### **User 클래스**

- **속성**
    - **`int userId`**: 사용자 고유 ID
    - **`String name`**: 사용자의 이름
    - **`int age`**: 사용자의 나이
    - **`String contactInfo`**: 사용자의 연락처 정보
- **메소드**
    - **`void viewInfo()`**: 사용자 정보를 출력

### **Patient 클래스 (User 상속)**

- **속성**
    - **`List<String> medicalHistory`**: 환자의 진료 기록 목록
    - **`List<String> currentMedication`**: 환자가 현재 복용 중인 약물 목록
    - **`String assignedDoctor`**: 환자에게 배정된 의사의 이름 또는 ID
- **메소드**
    - **`void viewMedicalHistory()`**: 환자의 진료 기록을 출력
    - **`void updateMedicalHistory(String newRecord)`**: 환자의 진료 기록에 새로운 기록을 추가
    - **`void viewCurrentMedication()`**: 환자가 현재 복용 중인 약물 목록을 출력
    - **`void updateCurrentMedication(String newMedication)`**: 환자가 현재 복용 중인 약물 목록에 새로운 약물을 추가
    - **`void viewInfo()`**: 사용자 정보를 출력하는 메소드를 오버라이딩하여 환자 정보를 추가로 출력

### **Doctor 클래스 (User 상속)**

- **속성**
    - **`String specialty`**: 의사의 과? 전문 분야?
    - **`List<Patient> assignedPatients`**: 의사에게 배정된 환자 목록
- **메소드**
    - **`void viewAssignedPatients()`**: 의사에게 배정된 환자 목록을 출력
    - **`void addPatient(Patient patient)`**: 환자를 의사에게 배정
    - **`void removePatient(Patient patient)`**: 환자를 의사로부터 해제
    - **`void viewInfo()`**: 사용자 정보를 출력하는 메소드를 오버라이딩하여 의사 정보를 추가로 출력

### **SpecialistDoctor 클래스 (Doctor 상속)**

- **속성**
    - **`String subSpecialty`**: 의사의 하위 과? 전문 분야?
- **메소드**
    - **`void viewSpecialtyInfo()`**: 의사의 전문 분야와 하위 전문 분야를 출력
    - **`void viewInfo()`**: 의사 정보를 출력하는 메소드를 오버라이딩하여 전문의사 정보를 추가로 출력

### **Nurse 클래스 (User를 상속)**

- **속성**
    - **`List<String> assignedWards`**: 간호사에게 배정된 병동 목록
- **메소드**
    - **`void viewAssignedWards()`**: 간호사에게 배정된 병동 목록을 출력
    - **`void addWard(String ward)`**: 간호사에게 새로운 병동을 배정
    - **`void removeWard(String ward)`**: 간호사에게서 병동을 해제
    - **`void viewInfo()`**: 사용자 정보를 출력하는 메소드를 오버라이딩하여 간호사 정보를 추가로 출력

### **Appointment 클래스**

- **속성**
    - **`int appointmentId`**: 진료 예약의 고유 ID
    - **`int patientId`**: 진료 예약에 해당하는 환자의 ID
    - **`int doctorId`**: 진료 예약에 해당하는 의사의 ID
    - **`Date appointmentDate`**: 진료 예약 날짜
    - **`String appointmentTime`**: 진료 예약 시간
    - **`String status`**: 진료 예약 상태 (예: 예약됨, 취소됨 등).
- **메소드**
    - **`void scheduleAppointment()`**: 진료 예약을 등록?스케줄링? 함
    - **`void updateAppointment(Date newDate, String newTime)`**: 진료 예약 일자와 시간을 업데이트
    - **`void cancelAppointment()`**: 진료 예약을 취소
    - **`void viewAppointment()`**: 진료 예약의 상세 정보를 출력

### **Room 클래스**

- **속성**
    - **`int roomId`**: 병실의 고유 ID
    - **`String roomType`**: 병실의 유형 (일반 병실 or 중환자실 등)
    - **`boolean availability`**: 병실의 이용 가능 여부
    - **`int assignedPatient`**: 병실에 배정된 환자의 ID
- **메소드**
    - **`void assignRoom(int patientId)`**: 병실을 환자에게 배정
    - **`void releaseRoom()`**: 병실 배정을 해제
    - **`void viewRoomStatus()`**: 병실의 상태를 출력

### **Pharmacy 클래스**

- **속성**
    - **`int drugId`**: 약품의 고유 ID
    - **`String drugName`**: 약품 이름
    - **`int stockQuantity`**: 약품 재고 수량
    - **`double price`**: 약품 가격
- **메소드**
    - **`void addDrug(int quantity)`**: 약품의 재고를 추가
    - **`void updateDrugInfo(String newName, double newPrice)`**: 약품 정보를 업데이트
    - **`void viewDrugInfo()`**: 약품의 상세 정보를 출력
    - **`void dispenseDrug(int quantity)`**: 약품을 조제하여 재고를 감소

### **MedicalRecord 클래스**

- **속성**
    - **`int recordId`**: 진료 기록의 고유 ID
    - **`int patientId`**: 진료 기록에 해당하는 환자의 ID
    - **`int doctorId`**: 진료 기록에 해당하는 의사의 ID
    - **`Date visitDate`**: 진료 방문 날짜
    - **`String diagnosis`**: 진단 내용
    - **`String treatment`**: 치료 내용
- **메소드**
    - **`void addRecord()`**: 진료 기록을 추가
    - **`void updateRecord(String newDiagnosis, String newTreatment)`**: 진료 기록을 업데이트
    - **`void viewRecord()`**: 진료 기록의 상세 정보를 출력

### **Billing 클래스**

- **속성**
    - **`int billingId`**: 청구서의 고유 ID
    - **`int patientId`**: 청구서에 해당하는 환자의 ID
    - **`double totalAmount`**: 총 청구 금액
    - **`String paymentStatus`**: 결제 상태 (결제됨 or 보류 중 or 취소됨)
- **메소드**
    - **`void generateBill()`**: 청구서를 생성
    - **`void updatePaymentStatus(String newStatus)`**: 결제 상태를 업데이트
    - **`void viewBill()`**: 청구서의 상세 정보를 출력

## 종합 병원 관리 시스템 예상 시나리오

### **시나리오 예시 1: 새로운 환자 등록 및 정보 업데이트**

병원에 새 환자가 등록되었으며, 등록 후 진료 기록과 현재 복용 중인 약물을 설정해야한다. 

1. **환자 등록**:
    - 관리자: "환자 이름을 입력하세요: 김철수"
    - 관리자: "환자 나이를 입력하세요: 45"
    - 관리자: "환자 연락처를 입력하세요: 010-1234-5678"
    - 관리자: "배정된 의사 이름을 입력하세요: 이의사"
    - 시스템: "환자가 성공적으로 등록되었습니다."
2. **환자 정보 업데이트**:
    - 관리자: "업데이트할 환자 ID를 입력하세요: 1"
    - 관리자: "새로운 환자 이름을 입력하세요: 김철수"
    - 관리자: "새로운 환자 나이를 입력하세요: 46"
    - 관리자: "새로운 환자 연락처를 입력하세요: 010-9876-5432"
    - 시스템: "환자 정보가 성공적으로 업데이트되었습니다."
3. **진료 기록 업데이트**:
    - 관리자: "환자 ID를 입력하세요: 1"
    - 관리자: "추가할 진료 기록을 입력하세요: 고혈압 진단"
    - 시스템: "진료 기록이 성공적으로 업데이트되었습니다."
4. **현재 복용 중인 약물 업데이트**:
    - 관리자: "환자 ID를 입력하세요: 1"
    - 관리자: "추가할 약물 이름을 입력하세요: 고혈압 약"
    - 시스템: "현재 복용 중인 약물이 성공적으로 업데이트되었습니다."

### **시나리오 예시 2: 의사에게 환자 배정 및 조회**

새 환자가 병원에 등록되었고, 특정 의사에게 배정되어 진료를 받아야하는 경우 

1. **환자 등록** (시나리오 1과 동일)
2. **의사에게 환자 배정**:
    - 관리자: "의사 ID를 입력하세요: 1"
    - 관리자: "배정할 환자 ID를 입력하세요: 1"
    - 시스템: "환자가 의사에게 성공적으로 배정되었습니다."
3. **의사에게 배정된 환자 조회**:
    - 관리자: "조회할 의사 ID를 입력하세요: 1"
    - 시스템: "의사 ID: 1, 이름: 이의사"
    - 시스템: "배정된 환자 목록:"
    - 시스템: "- 환자 ID: 1, 이름: 김철수"

### **시나리오 예시 3: 진료 예약 생성 및 조회**

환자가 진료 예약을 하려고 하며, 예약 후 예약 정보를 확인해야 하는 경우

1. **진료 예약 생성**:
    - 관리자: "환자 ID를 입력하세요: 1"
    - 관리자: "의사 ID를 입력하세요: 1"
    - 관리자: "예약 날짜를 입력하세요 (yyyy-MM-dd): 2024-06-01"
    - 관리자: "예약 시간을 입력하세요 (HH:mm): 10:00"
    - 시스템: "진료 예약이 성공적으로 추가되었습니다."
2. **진료 예약 조회**:
    - 관리자: "조회할 예약 ID를 입력하세요: 1"
    - 시스템: "예약 ID: 1"
    - 시스템: "환자 ID: 1"
    - 시스템: "의사 ID: 1"
    - 시스템: "예약 날짜: 2024-06-01"
    - 시스템: "예약 시간: 10:00"
    - 시스템: "상태: 예약됨"

### **시나리오 예시 4: 병실 배정 및 해제**

특정 환자에게 병실을 배정하고, 일정 기간 후 병실 배정을 해제해야할 경우 

1. **병실 배정**:
    - 관리자: "환자 ID를 입력하세요: 1"
    - 관리자: "병실 ID를 입력하세요: 101"
    - 시스템: "병실이 환자에게 성공적으로 배정되었습니다."
2. **병실 배정 해제**:
    - 관리자: "해제할 병실 ID를 입력하세요: 101"
    - 시스템: "병실 배정이 성공적으로 해제되었습니다."

### **시나리오 예시 5: 청구서 생성 및 결제 상태 변경**

환자의 진료가 끝난 후 진료비 청구서를 생성하고, 결제 상태를 변경해야할 경우 

1. **청구서 생성**:
    - 관리자: "환자 ID를 입력하세요: 1"
    - 관리자: "총 금액을 입력하세요: 50000"
    - 시스템: "진료비 청구서가 성공적으로 생성되었습니다."
2. **결제 상태 업데이트**:
    - 관리자: "업데이트할 청구 ID를 입력하세요: 1"
    - 관리자: "새로운 결제 상태를 입력하세요 (Paid, Pending, Cancelled): Paid"
    - 시스템: "결제 상태가 성공적으로 업데이트되었습니다."
