# 종합 병원 관리 프로그램

## 개요
이 프로젝트는 종합 병원 관리 시스템을 구현한 프로그램입니다. 이 프로그램은 환자, 의사, 간호사, 병실, 약국, 진료 기록 등의 다양한 병원 운영 기능을 포함합니다. 프로그램은 자바로 작성되었으며, 동기 프로그램을 비동기 프로그램으로 변환하여 스레드를 활용한 비동기 작업 처리를 구현했습니다.

## 기능
- 환자 관리
- 의사 관리
- 간호사 관리
- 진료 예약 관리
- 청구 및 결제 관리
- 진료 기록 관리
- 병실 관리
- 약국 관리
- 병원 직원 관리
- 채팅 관리

## 클래스 설명
### DTO (Data Transfer Object)
- **AppointmentDTO**: 진료 예약 정보를 저장하는 클래스.
- **BillingDTO**: 청구 및 결제 정보를 저장하는 클래스.
- **CrewDTO**: 병원 직원 정보를 저장하는 클래스.
- **DoctorDTO**: 의사 정보를 저장하는 클래스.
- **MedicalRecordDTO**: 진료 기록 정보를 저장하는 클래스.
- **NurseDTO**: 간호사 정보를 저장하는 클래스.
- **PatientDTO**: 환자 정보를 저장하는 클래스.
- **PharmacyDTO**: 약국 정보를 저장하는 클래스.
- **RoomDTO**: 병실 정보를 저장하는 클래스.
- **ChatDTO**: 채팅 메시지 정보를 저장하는 클래스.
- **UserDTO**: 사용자 정보를 저장하는 클래스.

### Service (서비스)
- **AppointmentService**: 진료 예약 관련 비즈니스 로직을 처리하는 클래스.
- **BillingService**: 청구 및 결제 관련 비즈니스 로직을 처리하는 클래스.
- **CrewService**: 병원 직원 관련 비즈니스 로직을 처리하는 클래스.
- **DoctorService**: 의사 관련 비즈니스 로직을 처리하는 클래스.
- **MedicalRecordService**: 진료 기록 관련 비즈니스 로직을 처리하는 클래스.
- **NurseService**: 간호사 관련 비즈니스 로직을 처리하는 클래스.
- **PatientService**: 환자 관련 비즈니스 로직을 처리하는 클래스.
- **PharmacyService**: 약국 관련 비즈니스 로직을 처리하는 클래스.
- **RoomService**: 병실 관련 비즈니스 로직을 처리하는 클래스.
- **ChatService**: 채팅 메시지 관련 비즈니스 로직을 처리하는 클래스.
- **UserService**: 사용자 관련 비즈니스 로직을 처리하는 클래스.

### Controller (컨트롤러)
- **AppointmentController**: 진료 예약 관련 사용자 입력을 처리하는 클래스.
- **BillingController**: 청구 및 결제 관련 사용자 입력을 처리하는 클래스.
- **CrewController**: 병원 직원 관련 사용자 입력을 처리하는 클래스.
- **DoctorController**: 의사 관련 사용자 입력을 처리하는 클래스.
- **MedicalRecordController**: 진료 기록 관련 사용자 입력을 처리하는 클래스.
- **NurseController**: 간호사 관련 사용자 입력을 처리하는 클래스.
- **PatientController**: 환자 관련 사용자 입력을 처리하는 클래스.
- **PharmacyController**: 약국 관련 사용자 입력을 처리하는 클래스.
- **RoomController**: 병실 관련 사용자 입력을 처리하는 클래스.
- **ChatController**: 채팅 메시지 관련 사용자 입력을 처리하는 클래스.
- **UserController**: 사용자 관련 사용자 입력을 처리하는 클래스.

## 프로그램 구조
```
src/
├── main/
│ ├── java/
│ │ ├── com/
│ │ │ ├── hospital/
│ │ │ │ ├── dto/
│ │ │ │ │ ├── AppointmentDTO.java
│ │ │ │ │ ├── BillingDTO.java
│ │ │ │ │ ├── CrewDTO.java
│ │ │ │ │ ├── DoctorDTO.java
│ │ │ │ │ ├── MedicalRecordDTO.java
│ │ │ │ │ ├── NurseDTO.java
│ │ │ │ │ ├── PatientDTO.java
│ │ │ │ │ ├── PharmacyDTO.java
│ │ │ │ │ ├── RoomDTO.java
│ │ │ │ │ ├── ChatDTO.java
│ │ │ │ │ ├── UserDTO.java
│ │ │ │ ├── service/
│ │ │ │ │ ├── AppointmentService.java
│ │ │ │ │ ├── BillingService.java
│ │ │ │ │ ├── CrewService.java
│ │ │ │ │ ├── DoctorService.java
│ │ │ │ │ ├── MedicalRecordService.java
│ │ │ │ │ ├── NurseService.java
│ │ │ │ │ ├── PatientService.java
│ │ │ │ │ ├── PharmacyService.java
│ │ │ │ │ ├── RoomService.java
│ │ │ │ │ ├── ChatService.java
│ │ │ │ │ ├── UserService.java
│ │ │ │ ├── controller/
│ │ │ │ │ ├── AppointmentController.java
│ │ │ │ │ ├── BillingController.java
│ │ │ │ │ ├── CrewController.java
│ │ │ │ │ ├── DoctorController.java
│ │ │ │ │ ├── MedicalRecordController.java
│ │ │ │ │ ├── NurseController.java
│ │ │ │ │ ├── PatientController.java
│ │ │ │ │ ├── PharmacyController.java
│ │ │ │ │ ├── RoomController.java
│ │ │ │ │ ├── ChatController.java
│ │ │ │ │ ├── UserController.java
│ │ │ │ ├── HospitalManagementSystem.java
│ │ │ │ ├── util/
│ │ │ │ │ ├── DateUtils.java
│ │ │ │ │ ├── InputValidator.java
```
## 실행 영상

링크1[https://youtu.be/UjnasW8LSVE] <br/>
링크2[https://youtu.be/dku_h0C2-48]
