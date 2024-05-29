# 종합 병원 관리 프로그램

자바 클래스 설계 및 계층 분리, 스레드, 스레드 간 통신 등을 프로젝트를 만들면서 학습하고자 생성한 프로그램입니다.

병원 운영을 효율적으로 관리하기 위한 종합 병원 관리 시스템입니다. 이 프로그램은 환자, 의사, 간호사, 병실, 약국, 진료 기록 등 다양한 병원 운영 기능을 포함하며, 자바로 작성되었습니다.

## Table of Contents

- [About](#about)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## About

종합 병원 관리 프로그램은 병원의 일상 운영을 돕기 위해 설계된 시스템입니다. 프로그램은 비동기 작업 처리를 통해 효율성을 높였으며, 다양한 병원 관리 기능을 제공합니다.

## Getting Started

### Prerequisites

이 프로젝트를 사용하기 위해 필요한 소프트웨어 및 도구 목록입니다.

- Java 8 이상
- Maven
- Git

### Installation

개발 환경을 설정하는 단계별 가이드입니다.

1. 리포지토리를 클론합니다.
   ```
   git clone <your-repository-url>
   cd hospital-management-system
   ```
2. Maven을 사용하여 종속성을 설치합니다.
 ```bash
  mvn install
```
3. 프로젝트를 빌드하고 실행합니다.
```
mvn compile
mvn exec:java -Dexec.mainClass="com.hospital.HospitalManagementSystem"
```

## Usage
프로그램을 사용하는 예제와 설명입니다.

1. 프로그램을 실행합니다.
2. 메인 메뉴에서 원하는 기능을 선택합니다.
3. 환자, 의사, 간호사 등의 데이터를 입력하고 관리합니다.
4. 채팅 기능을 사용하여 스레드 간 통신을 테스트할 수 있습니다.

## Contributing
프로젝트에 기여하기 위한 가이드라인입니다.
1. 이 리포지토리를 포크합니다.
2. 새로운 브랜치를 생성합니다.
```
git checkout -b feature/new-feature
```
3. 변경 사항을 커밋합니다.
```
git commit -m "Add new feature"
```
4. 브랜치에 푸시합니다.
```
git push origin feature/new-feature
```
5. 풀 리퀘스트를 생성합니다.

## Acknowledgments

[Java Documentation](https://docs.oracle.com/javase/8/docs/)
[Maven Documentation](https://maven.apache.org/)
[Git Documentation
](https://git-scm.com/doc)
