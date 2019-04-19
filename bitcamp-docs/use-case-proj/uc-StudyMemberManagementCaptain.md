#UC - 멤버관리 시스템(uc-StudyMemberManagementCaptain)
- 멤버를 추방, 스터디장의 권한 위임을 할 수 있는 유스케이스이다.

## 주 액터(Primay Acto)
스터디 장

## 보조 액터(Secondary Actor)

## 사전 조건(Preconditions)
- 액터는 마이페이지를 클릭한다.
- 시스템은 마이페이지 폼을 출력한다.
- 액터는 해당 스터디를 클릭한다.
- 시스템은 해당 스터디 폼을 출력한다.

## 종료 조건(Postconditions)
- 멤버를 추방 하였다.
- 멤버에게 권한을 위임 하였다.

## 시나리오(Flow of Evnets)

### 멤버 추방
1. 액터는 멤버 상세 조회 폼에서 추방 버튼을 클릭 한다.
2. 시스템은 확인 문구를 출력한다.
3. 액터는 확인 버튼을 클릭 한다.
4. 시스템은 쪽지 보내기 폼을 출력한다.
5. 액터는 추방 당하는 멤버에게 쪽지를 보낸다.
6. 위의 작업을 완료 후 해당 스터디의 폼이 출력된다.

### 멤버 위임
1. 액터는 멤버 상세 조회 폼에서 위임 버튼을 클릭 한다.
2. 시스템은 확인 문구를 출력한다.
3. 액터는 확인 버튼을 클릭 한다.
4. 위의 작업을 완료 후 해당 스터디의 폼이 출력된다.