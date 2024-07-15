# InterCalendar 

## 2024 소프트웨어공모전
* 작품 대표 사진
  
  ![image](https://github.com/user-attachments/assets/4b45e833-be6c-4826-80d2-d27fcd0655a3)

출품 분야: 반응형 웹 사이트 

## 1. 작품명
### InterCalendar

## 2. 팀 구성
### 팀장 

컴퓨터학부 20211610 정다은

### 팀원 

컴퓨터학부 20231241 이해원

컴퓨터학부 20233000 천준민

## 3. 기획의도
 많은 사람이 모임을 준비할 때 참여자들의 일정을 조율하는 데 시간과 에너지를 소모하여 어려움을 겪습니다. 또한 모임 참여자들이 많을 경우 모임 참여자들 각각의 시간과 장소를 한눈에 알기 어렵습니다. 따라서 각자의 스케줄러에 일정을 입력하고 가능한 시간을 자동으로 도출하여 사용자들이 보다 효율적으로 일정을 조율할 수 있도록 지원하고자 이 웹 SW를 만들게 되었습니다.

## 4. 작품 설명
### 가. 작품 개요
#### 개발 목표
 1. 약속 시간 설정 자동화
 2. 만나고 싶은 시간 및 장소 시각화


#### 개발 개요: 
참여자들의 가능한 모임 시간대를 자동으로 도출하는 것을 목표로 한 장소 및 시간 시각화 스케줄러 웹 SW


#### 사용 기술 스택:
프론트엔드 – React(MUI), KAKAO Map API

백엔드 – Spring, MYSQL


### 나. 시스템 구성도
 <ERD (Entity Relationship Diagram)>
 
 ![image](https://github.com/user-attachments/assets/9850c8f6-eb01-4fc5-aa58-b452331a67a4)

### 다. 구현기능
![image](https://github.com/user-attachments/assets/11b56a51-dc12-4e42-b0cb-025da89e5b28)

* Main Page: 사용자가 사이트에 들어오면 가장 먼저 보이는 메인 화면
1. 사이드 바에는 사용자가 만들었거나 소속된 그룹 요소들이 표시되어 있습니다. (+ new Inter 버튼을 누르면 Create Group Page로 넘어갑니다.)
2. 가운데에는 사용자의 일정이 있는 캘린더가 있으며 구체적인 날짜를 누르면 CRUD New Item Page로 넘어갑니다.
3. Header의 오른쪽 부분에 사용자의 로그인 여부에 따라 My Page로 가거나 Sign Up 페이지로 가도록 하는 옵션이 있습니다.
---
![image](https://github.com/user-attachments/assets/c222b1d0-488c-4d00-985d-4a26028b339e)

* CRUD New Item Page: 사용자가 새로운 일정을 추가할 수 있는 페이지
1. 사용자가 제목을 정할 수 있습니다.
2. 시작과 종료 시간을 설정할 수 있습니다.
3. 이미 저장된 아이템을 사용자가 수정하고자 한다면 아래의 Update와 Delete 버튼을 통해 수정 및 삭제할 수 있습니다.
---
![image](https://github.com/user-attachments/assets/445a1428-cbf0-49f8-8792-f760a84f2a66)

* User Profile Page: 사용자의 정보를 볼 수 있는 페이지
1. 사용자가 자신의 username을 확인할 수 있습니다. 수정은 불가능합니다.
2. 사용자가 소속된 그룹의 개수를 확인할 수 있습니다.
---
![image](https://github.com/user-attachments/assets/88174b46-42cc-48c4-ae26-f9164cf1a62c)

* Group Page: 그룹의 구체적인 정보를 볼 수 있는 페이지
1. 그룹의 이름과 멤버 수를 볼 수 있습니다.
2. 그룹원의 캘린더를 분석해서 가장 많이 겹치는 시간대 3개를 보여줍니다.
3. 그룹 생성자는 필요에 따라 모임 시간과 기간을 바꿀 수 있습니다.
4. 그룹원들이 가고자 하는 장소를 맵을 통해 확인할 수 있고, 맵을 누르면 구체적인 장소를 추가하는 Add New Location Page로 이동합니다. 
5. 지도 아래의 파란색 화살표를 누르면 다른 사용자가 추가한 장소를 맵에서 확인할 수 있습니다.
---
![image](https://github.com/user-attachments/assets/c6ffcb8e-7a2b-4866-bce8-f2fdc81902fa)
![image](https://github.com/user-attachments/assets/5dcc43b5-166b-487d-9779-96c040602587)

* Log In & Sign Up Page: 로그인하거나 회원가입 할 수 있는 페이지
1. 로그인 페이지에서는 사용자의 이름과 비밀번호를 입력하여 로그인 할 수 있습니다.
2. Sign Up 페이지에서는 사용자가 이메일, username, password를 입력하여 회원가입 할 수 있습니다.
---
![image](https://github.com/user-attachments/assets/da54e224-ab6a-4291-943a-91c01eac0377)

* Create Group Page: 새로운 그룹을 만드는 페이지
1. 생성할 그룹의 이름을 입력할 수 있습니다.
2. 모임이 이뤄질 기간과 지속 시간을 입력할 수 있습니다.
3. 모일 인원을 사용자가 정할 수 있습니다.
4. “Create ->“ 버튼을 누르면 Waiting Room Page로 이동합니다.
---
![image](https://github.com/user-attachments/assets/75c92f21-e2b9-45bf-aba7-7846f2940275)

* Waiting Room Page: 그룹에 포함될 사용자를 기다리는 페이지
1. 그룹 생성 후 초대할 사람에게 링크를 공유하여 그룹에 포함시킬 수 있습니다.
2. 사용자가 정한 그룹 인원만큼의 사람이 들어와서 가운데의 버튼을 눌러 해당 인원만큼의 버튼이 클릭 되면 (서로 다른 사용자인지 판단합니다.) Group Page로 넘어갑니다.
3. 부연 설명: 이 페이지는 사용자가 초대하고자 하는 서로 다른 사람이 그룹의 인원 수만큼 소속이 되도록 확인하고자 하는 목적으로 만들었습니다. 
---
![image](https://github.com/user-attachments/assets/42eaa1b0-2ec1-4059-8955-b8d58fb7c392)

* Add New Location Page: 그룹 맵에 표시하고 싶은 장소를 추가하는 페이지
1. KAKAO API를 이용해 사용자가 원하는 장소를 추가할 수 있습니다.
2. 추가된 장소는 Group Page의 맵을 통해 확인 가능합니다.

## 5. 개발환경
* Front End
  
  React

* Back End
  
  JavaSpring + JPA + MySql 
