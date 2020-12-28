<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	header {
	  display: flex;
	  height: 150px;
	}
	
	header h1 {
	  color: steelblue;
	  font-size: 35px;
	  width: 400px;
	  height: 100px;
	  margin: 50px;
	  transform: rotate(-35deg);
	}
	
	header a {
	  font-weight: bold;
	  font-size: 15px;
	  margin: 50px;
	  margin-left: 790px;
	  width: 200px;
	  height: 50px;
	  line-height: 50px;
	  color: white;
	  background: #20ADEE;
	  text-align: center;
	  text-decoration: none;
	}
	
	header a:hover {
	  text-decoration: underline;
	  background: rgb(32, 173, 238, 0.7);
	}
	
	.container {
	  display: flex;
	  margin-left: 180px;
	}
	
	.main-title {
	  margin: 10px;
	  width: 400px;
	  height: 80px;
	  line-height: 80px;
	  font-size: 40px;
	  font-weight: bold;
	  color: white;
	  background: #2e657f;
	  padding-left: 20px;
	}
	
	.main-content {
	  margin: 10px;
	  height: 60px;
	  background: #cee5ef;
	  width: 400px;
	  padding: 10px 0px 10px 20px;
	}
	
	.main-content-title {
	  color: black;
	  font-weight: bold;
	  font-size: 20px;
	  width: 400px;
	  height: 30px;
	  line-height: 30px;
	}
	
	.main-content-content {
	  color: black;
	  float: left;
	  font-size: 15px;
	  height: 30px;
	  line-height: 30px;
	}
	
	.main-content-btn {
	  float: right;
	  margin: 5px 30px 0px 0px;
	}
</style>
<title>TODO LIST</title>
</head>
<body>
	<header>
		<h1>나의 해야할 일들</h1>
		<a href="./add">새로운 TODO 등록</a>
	</header>
	<div class="container">
		<div id="TODO" class="main">
			<div class="main-title">TODO</div>
			<c:forEach var="item" items="${todoList }">
				<div id="${item.id }" class="main-content">
					<div class="main-content-title">${item.title }</div>
					<div class="main-content-content">등록날짜: ${item.regDate }, ${item.name }, 우선순위 ${item.sequence }</div>
					<input class="main-content-btn" type="button" value="➡" onclick="btn_click(${item.id }, 'TODO');"/>
				</div>
			</c:forEach>
		</div>
		<div id="DOING" class="main">
			<div class="main-title">DOING</div>
			<c:forEach var="item" items="${doingList }">
				<div id="${item.id }" class="main-content">
					<div class="main-content-title">${item.title }</div>
					<div class="main-content-content">등록날짜: ${item.regDate }, ${item.name }, 우선순위 ${item.sequence }</div>
					<input class="main-content-btn" type="button" value="➡" onclick="btn_click(${item.id }, 'DOING');"/>
				</div>
			</c:forEach>
		</div>
		<div id="DONE" class="main">
			<div class="main-title">DONE</div>
			<c:forEach var="item" items="${doneList }">
				<div id="${item.id }" class="main-content">
					<div class="main-content-title">${item.title }</div>
					<div class="main-content-content">등록날짜: ${item.regDate }, ${item.name }, 우선순위 ${item.sequence }</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
<script>
function btn_click(id, type) {
	var xhr = new XMLHttpRequest();
	var typeDestination = (type === 'TODO') ? 'DOING' : 'DONE';
	xhr.addEventListener("load", function() {
		if (xhr.status === 200) {
			console.log("success");
			var parent = document.getElementById(typeDestination);
			var item = document.getElementById(id);
			item.removeChild(item.children[2]);
			if (typeDestination === 'DOING') {
				var button = "<input class=\"main-content-btn\" type=\"button\" onclick=\"btn_click(" + id + ", \'" + typeDestination + "\');\" value=\"➡\"/>";
				item.insertAdjacentHTML('beforeend', button);
			}
			parent.appendChild(item);
		}
	});
	xhr.open("POST", "./type");
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("id=" + id + "&type=" + typeDestination);
}
</script>
</html>