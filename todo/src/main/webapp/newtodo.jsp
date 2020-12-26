<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header><h1>할일 등록</h1></header>
	<div class="container">
		<form action="/todo/add" method="post">
			<div class="container-title">
				<p>어떤 일인가요?</p>
				<input type="text" name="title" placeholder="할 일">
			</div>
			<div class="container-name">
				<p>누가 할일인가요?</p>
				<input type="text" name="name" placeholder="이름">
			</div>
			<div class="container-sequence">
				<p>우선순위를 선택하세요</p>
				<input type="radio" name="sequence" value="1" checked>1순위
				<input type="radio" name="sequence" value="2">2순위
				<input type="radio" name="sequence" value="3">3순위
			</div>
			<div class="container-btn">
				<a href="/todo">&lt; 이전</a>
				<input type="submit">
				<input type="reset" value="내용지우기">
			</div>
		</form>
	</div>
</body>
</html>