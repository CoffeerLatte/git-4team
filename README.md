<h1 align="center"> To_DO List 개인 및 팀 버전  </h1>


팀원
=======
```


전승민(팀장), 박대호, 김민성, 심규혁


```


미니 프로젝트: spring boot, rest api, maven
> 미완료 : MSA(JWT 구성)



### 프로젝트 목표 :

개인이 사용할 수 있는 todo list 구성과 팀원이 서로 공유하고 볼 수 있는 todolist를 만들어보자


# 역할 분담
```
전승민( 프로젝트 설계 , (개인/팀)간 데이터 연결, ToDo List 구조 설계, 발표자료 작성, 발표, 세션 로그인)
심규혁()
박대호()
김민성()

```



[Google Sheet(DB 및 ](https://docs.google.com/spreadsheets/d/1W5FWxfUWDjQPUbMkPeahi3Vn_Bxx6TmZ9QnIumbHlPE/edit?usp=sharing)
------------------------------------------------------------------------------------------------------------------------------------------------------------------
<details>
<summary>초기 구성에 대한 캡처 및 설명</summary>
  
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/76007f30-4c8a-4c18-9863-cff0406a49d2)

* 기본적인 데이터 입력 및 수정, 제거 기능 구현. todo의 기능 구현


초기 구성 flow

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/bcdbb329-6b68-4a3d-804e-aae663310f21)

* todo 사용자 -> 회원가입 유무를 본인이 확인 -> 아이디가 있다면 로그인 -> 개인 todo list 사용 -> 팀용 todolist 사용 -> 개인용 todolist로 자유롭게 이동가능
  
> 아이디가 없다면 회원가입
> 
> 팀용 todolist에서의 팀원들 마다 구별법 추후 구상.

![캡처](https://github.com/CoffeerLatte/git-4team/assets/125641153/9225727a-c756-491b-a76a-651649f2b6c6)

* 사용하게 될 기본적인 table 구상.
  
</details>

-----------------------------------------------------------------------------------------------------------------------------------------------------------
<details>

  <summary>구현완료된 동작에 대한 캡쳐 및 설명</summary>
  
  


session login 완성 및 todo_list와 연동 과정
-- 서로다른 테이블을 join하는 방법으로 원하는 데이터를 가져오려고 했다.
-- 실패 (이유는 새로운 객체를 생성하여 가져오고 있었기 때문)

-- 디버그 방법
-- joincolumn을 사용하지 않고, 로그인을 하자마자, 로그인하는 파트에서 바로 데이터를 넘겨주는 방식으로 해결.
![tempsnip](https://github.com/CoffeerLatte/git-4team/assets/125641153/40d58adc-6a8d-43a4-a431-5ff388d64dfc)
해결하는 구문

session login + TodoList + team_todolist  연동과정


안되었던 부분
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/3ab1ec85-0ba9-4d6b-bfec-046437a87e81)

디버깅

(설명부탁)

-- 리다이렉션 문제
데이터를 update, insert, delete, complete하고 나서 원하는 페이지로 redirection이 되지 않았음. 계속 메인페이지로 load.
resource / template/ teamtodo.html 파일을 수정하여 update, delete, complete는 데이터 이동 동작 후 page를 reload하게 만듬.
결과 : 데이터를 입력 후 입력한 데이터가 현재 html 페이지에 정상 반영됨.
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/7fc676f6-785a-4b92-9eac-7bbca1003b89) // 로그인
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/01c1386e-c12e-4299-b5bf-5308a3a4b886) // 회원가입
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/b33ce2cf-dc02-4892-bcf0-f2bab50550cd) //비밀번호가 틀렸을 경우

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/38326061-67e5-4322-afcb-da18677ad553) // 다른 회원이 사용중인 닉네임의 경우
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/2819a290-3cef-436a-892c-76c185d6d027) // 로그인 시 자신만의 개인 todo리스트로 이동
+ 팀 할일 버튼 및 로그아웃 버튼 상호 작용 가능.

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/190d443d-467a-4b4d-ad22-5a55053fdab1) // 팀 할일 페이지

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/579f35cf-e15b-4d30-a7cb-b316cd4e6f67) // 팀 할일 페이지에서의 팀별 todolist 작성

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/86f433c7-4e76-4ac5-9d0b-563d28afa9f7) // 팀 할일 페이지에서의 todo 삭제 메시지 띄우기

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/f05dcc9a-97bc-486e-b923-8064c6f35f22) // 팀 할일 페이지에서 수정 버튼을 눌러서 완수 날짜 및 할일을 수정하는 캡쳐

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/eabeb45e-a292-49cb-8139-170fd37c446c) // 팀 할일 페이지에서 방금 수정한 내용이 즉시 반영되는 모습
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/4170945b-c403-49a4-84c5-da4b57828d94) // 완료 버튼 정상 동작
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/58d76433-b87d-4362-b3e4-85be66105356) // 개인 페이지에서의 todo 작성

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/7964fe01-c4e5-4676-9345-8ac8b92eb3be) // 버튼 정상 동작

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/8feacc7c-0fd9-40bf-af12-2ad60f146038) // 개인 페이지에서의 수정 정상 기능
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/4cf9fa70-4ef8-457a-b335-2527bcfcee96) // 개인 페이지에서의 데이터 삭제 정상


![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/3777d2c1-dca3-4da4-9037-3c804a17fa43) // maria db 데이터 베이스에 쌓이는 todoentity 정보 (팀)


![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/4aaf1122-e8f7-4ef7-97fc-079cbbbe3635) // maria db 데이터 베이스에 쌓이는 todoentity 정보 (개인)

![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/36771c35-b123-4c29-abfb-0fe82e4b50ff) // maria db 데이터베이스에 쌓이는 회원가입한 계정 정보

</details>




# 최종 
