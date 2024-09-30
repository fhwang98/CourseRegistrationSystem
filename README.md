# 문화센터 관리 프로그램

## 개요
Java 콘솔 기반의 문화센터 관리 프로그램으로, 강좌 선택의 진입 장벽을 허물고 편리한 강좌 관리 시스템을 구축하여 사용자들에게 편리함을 제공하는 것을 목표로 함
회원, 강사, 관리자 각각의 역할에 맞춘 기능을 제공하며, 문화센터 내 강좌 신청 및 관리 업무를 효율적으로 처리

## 주요 기능

### 회원용 기능
1. **회원 가입 및 로그인**
   - 새로운 회원 가입 및 기존 회원 로그인 가능.
   - 비밀번호 재설정 기능 제공.

2. **강좌 열람 및 신청**
   - 카테고리, 시간, 요일, 연령대별로 강좌를 필터링하여 열람 가능.
   - 맞춤형 강좌 추천 기능 제공.

3. **마이페이지**
   - 내 정보(이름, 전화번호 등) 조회 및 수정.
   - 수강 중인 강좌 목록 열람 및 수강 취소 가능.

### 강사용 기능
1. **강좌 관리**
   - 신규 강좌 등록 신청 및 조회 가능.
   - 기존 강좌 정보 수정 가능.

### 관리자용 기능
1. **회원 및 강사 관리**
   - 전체 회원 및 강사 목록 조회, 수정, 탈퇴 처리 가능.
   
2. **강좌 관리**
   - 강좌 등록 신청에 대한 승인 및 반려 처리 가능.
   - 강좌 검색 및 강의실 관리 기능 제공.

3. **공지사항 관리**
   - 공지사항 등록, 수정, 삭제 기능 제공.

## 순서도
![2조 순서도](https://github.com/user-attachments/assets/e5113e46-c14b-449c-b2fd-73e07eb40a80)

## 개발 환경
- **개발 언어**: Java 11
- **개발 도구**: Eclipse IDE
- **운영체제**: Windows 10, MacOS
- **기간**: 2023.08.16 ~ 2023.08.24

## 데이터

### 데이터 구조
- **회원 데이터**
  - 일반 회원, 강사, 관리자의 정보를 각각 관리 (회원 번호, 아이디, 비밀번호, 이름, 전화번호 등)
  
- **강좌 데이터**
  - 강좌 번호, 강좌명, 카테고리, 시간, 요일, 대상 연령, 수강료 등의 정보 포함.
  
- **강의실 데이터**
  - 강의실 번호, 사용 스케줄(요일, 시간) 등의 정보를 포함하여 강의실 관리.

### 데이터 관계도
![데이터관계도](https://github.com/user-attachments/assets/3ef6d27d-2458-4ef3-8569-0948f14dd39a)

## 화면 구현
### 관리자 기능
<img width="500" alt="image" src="https://github.com/user-attachments/assets/25e65568-bc11-4cbd-be82-a56406e9816d">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/62f8f12f-5375-4aa6-bd68-f298d2754e38">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/5597ae68-f877-426f-aad5-2facaaa3ee91">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/e4362578-74cd-4dd1-afb9-c55cafd7fa90">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/a4ebf5e0-675e-463c-9ae7-79ff76b306cc">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/8279c921-3b25-4fae-81d9-1676b42dc2df">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/295ea427-8fdb-43a9-b84b-20a50cc1f91d">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/0d62663e-bc20-4645-a883-00cb53ef1857">
<img width="500" alt="image" src="https://github.com/user-attachments/assets/9b5c8dc0-1012-4905-a479-a4ca8d0eba28">




## 담당 역할
- **이연섭**: 회원 마이페이지, 수강신청, 수강신청 안내, 관리자 내 정보 조회, 수강 내역 관리
- **김민정**: 공통 데이터 관리, 로그인, 회원가입, 아이디 찾기 및 비밀번호 재설정
- **신수정**: 안내 페이지, 강좌 목록 조회, 강좌 추천, 수강신청
- **황유진**: 관리자 메인, 강좌 승인 대기, 강의실 관리, 공지사항 기능
- **황은하**: 공지사항 조회, 셔틀 버스 기능, 관리자 일반 및 강사 관리 기능
- **황주원**: 초기 메인 화면, 강사 로그인, 강사 마이페이지, 강좌 관리

## 제작 후기
- **이슈**: 프로젝트 초반 기획이 불명확하여 일부 혼란이 있었음.
- **보완점**: 코드 가독성을 높이기 위해 주석을 추가하고, 기획 단계에서 더 명확한 방향성을 설정할 필요가 있었음.
