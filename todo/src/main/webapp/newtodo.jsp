<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
  background: lightgray;
}

.container {
  background: white;
  margin-left: 30%;
  margin-right: 30%;
  width: 40%;
}

.header {
  text-align: center;
}

.container-form {
  margin-left: 20%;
  margin-right: 20%;
}

.container-input-description {
  margin-top: 20px;
  font-size: 20px;
}

input[type="text"] {
  font-size: 20px;
}

input[name="title"] {
  width: 100%;
}

input[name="name"] {
  width: 50%;
}

input[type="radio"] {
  margin-bottom: 20px;
}

.footer {
  display: flex;
  margin-top: 20px;
}

a {
  border: 1px solid gray;
  font-weight: bold;
  font-size: 16px;
  color: black;
  text-align: center;
  padding: 10px;
  margin-bottom: 20px;
}

a:hover {
  color: gray;
}

.footer-btn {
  display: flex;
}

.footer-btn input {
  padding: 10px;
  width: 130px;
  background: #20ADEE;
  font-size: 16px;
  color: white;
  border: none;
  margin-bottom: 20px;
}

.footer-btn input:hover {
  text-decoration: underline;
  background: rgb(32, 173, 238, 0.7);
  cursor: pointer;
}

input[type="submit"] {
  margin-left: 100px;
  margin-right: 20px;
}

</style>
<title>TODO LIST</title>
</head>
<body>
	<div class="container">
		<div class="header"><h1>할일 등록</h1></div>
		<div class="container-form">
			<form action="/todo/add" method="post">
				<div class="container-title">
					<div class="container-input-description">어떤 일인가요?</div>
					<input type="text" name="title" required="true" placeholder="할 일">
				</div>
				<div class="container-name">
					<div class="container-input-description">누가 할일인가요?</div>
					<input type="text" name="name" required="true" placeholder="이름">
				</div>
				<div class="container-sequence">
					<div class="container-input-description">우선순위를 선택하세요</div>
					<input type="radio" name="sequence" value="1" checked>1순위
					<input type="radio" name="sequence" value="2">2순위
					<input type="radio" name="sequence" value="3">3순위
				</div>
				<div class="footer">
					<a href="/todo">&lt; 이전</a>
					<div class="footer-btn">
						<input type="submit">
						<input type="reset" value="내용지우기">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>