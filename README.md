# boostcourse-web-todo-list
> [부스트코스 웹 프로그래밍 프로젝트B TO-DO LIST]((https://www.boostcourse.org/web316/project/7/content/6)) 프로젝트입니다.

 부스트코스의 웹 프로그래밍(풀스택) 강좌의 `2. DB 연결 웹 앱` 프로젝트입니다.

 eclipse의 maven 프로젝트를 이용하였고, mysql과 jdbc를 이용하여 구현하였습니다.

![main](https://user-images.githubusercontent.com/38418028/103196820-3ca68e80-4928-11eb-8aff-d6a1d7f5538a.png "할 일 목록 화면")
![add](https://user-images.githubusercontent.com/38418028/103196873-55af3f80-4928-11eb-8879-069fd451bf42.png "할 일 등록 화면")

## ⌨ 웹프론트엔드 
* [x] 총 2개의 화면이 존재합니다.
    * 할 일 목록 화면 (리스트)
    * 할 일 등록 화면 (쓰기)
* [x] CSS는 기획서와 동일한 수준으로 만들어야 합니다.
* [x] 따라서 HTML 엘리먼트간의 배치와 간격은 일정하고 반듯해야 합니다.
* [x] 글자의 크기는 일정한 수준을 유지합니다.
* [x] CSS는 외부 라이브러리(부트스트랩)을 사용하지 않습니다.
* [x] jQuery를 사용하지 않고, querySelector, addEventListener, innerHTML을 사용해서 DOM, EVENT 처리를 합니다.
* [x] Ajax는 XMLHTTPRequest를 사용합니다.

## 🖥 웹백엔드 기술요구사항
* [x] 프로젝트는 maven프로젝트로 생성합니다.
* [x] 제공된 테이블 생성 SQL을 이용해서 테이블을 생성합니다.
* [x] TodoDto 클래스와 TodoDao클래스를 주어진 스펙에 맞게 작성합니다.
* [x] 메인화면을 보여주기 위한 MainServlet과 main.jsp를 작성합니다.
* [x] MainServlet은 TodoDao를 이용해 결과를 조회해서 main.jsp 에 전달합니다.
* [x] 새로운todo등록 버튼을 클릭하면 해당 요청을 서블릿이 받아서 jsp로 포워딩하여 할 일 등록 화면을 보여줍니다.
* [x] 할일등록폼에서 값을 입력하고 제출 버튼을 누르면 post 방식으로 요청하게 합니다.
* [x] 해당 요청을 서블릿이 받아서 처리하게하고, 요청에 대한 모든 일이 끝나면 메인화면으로 리다이렉트 합니다.
* [x] 메인화면에서 todo 상태변경 버튼(->)을 클릭하여 요청을 보낼 때, Todo 의 Id와 상태값을 전달하여 다음 상태로 (현재 상태가 Todo라면 doing으로 doing 이라면 done) 상태를 나타내는 컬럼값을 변경하고 응답결과로 "success"를 보냅니다.


## 🛠 설치 방법
 1. `mysql`에 접속한 후 다음의 테이블을 생성하는 쿼리를 실행합니다.
 ```sql
 CREATE TABLE todo (
     id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
     title VARCHAR(255) NOT NULL,
     name VARCHAR(100) NOT NULL,
     sequence INT(1) NOT NULL, type VARCHAR(20) DEFAULT 'TODO',
     regdate DATETIME DEFAULT NOW(),
     PRIMARY KEY (id)
 );
 ```
 2. eclipse에서 `File > Import > Git > Projects from Git(with smart import) > Clone URI`를 통해 이 프로젝트의 git주소를 입력하여 Clone합니다.
 3. `src/main/java`의 `todo.dao` 패키지에 있는 `TodoDao.java` 파일을 엽니다.
 4. `dbUrl`, `dbUser`, `dbpasswd` 변수들을 본인의 mysql 정보로 변경 후 저장합니다.
 5. 본인의 server를 통해 프로젝트를 실행합니다.

## 💡 추가 구현 예정
* [ ] 상태값이 DONE인 컬럼을 삭제하는 기능
* [ ] 카테고리 기능
