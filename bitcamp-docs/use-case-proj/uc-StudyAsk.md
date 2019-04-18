#UC - 스터디 문의(Study Ask)
개설된 스터디에 대해 스터디 장에게 가입문의 하는 유스케이스

## 주 액터(Primay Acto)
스터디 원

## 보조 액터(Secondary Actor)

## 사전 조건(Preconditions)
- 로그인을 한 상태이다.
- 해당 스터디 페이지를 클릭한 상태이다.

## 종료 조건(Postconditions)
- 다른 페이지로 이동하였다.
- 스터디 가입 문의를 완료 하였다.

## 시나리오(Flow of Evnets)

### 기본 흐름(Basic Flows)
- 1. 액터는 스터디 조회 후 원하는 스터디를 클릭한다.
- 2. 시스템은 스터디 상세 폼을 출력한다.
- 3. 액터는 해당 스터디를 확인 후 문의하기 버튼을 클릭한다.
- 4. 시스템은 스터디 장에게 보내는 쪽지 폼을 출력한다.

### 대안 흐름(Alternative Flows)
- 4.1 쪽지 폼에서 취소 버튼을 클릭하면 문의하기가 취소된다.

### 예외 흐름(Exception Flows)

### 스터디 문의
![스터디 문의](./images/uc-studyJoin&Ask.png)