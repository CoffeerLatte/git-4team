<h1 align="center">개인 혹은 팀 To_DO List</h1>


팀원
=======
```


전승민(팀장), 박대호, 김민성, 심규혁


```


미니 프로젝트: spring boot, rest api, maven


프로젝트 이름 : 개인용 및 팀용 TodoList


![캡처](https://github.com/CoffeerLatte/git-4team/assets/125641153/9225727a-c756-491b-a76a-651649f2b6c6)




초기 구성
![image](https://github.com/CoffeerLatte/git-4team/assets/125641153/76007f30-4c8a-4c18-9863-cff0406a49d2)

* 기본적인 데이터 입력 및 수정, 제거 기능 구현. todo의 기능 구현


초기 구성 flow
![ToDo drawio](https://github.com/CoffeerLatte/git-4team/assets/125641153/4622d319-03b1-45a9-8d81-05c3bcb5e450)


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

