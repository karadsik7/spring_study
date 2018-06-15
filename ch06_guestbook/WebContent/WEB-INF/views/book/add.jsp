<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<style>
button.smaLL{
	width: 30%;
}
table{
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
    border-left: 3px solid #369;
 	margin : 20px 0;
 	background : #eeeeee;
}
th {
    width: 147px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #153d73;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;

}
td {
    width: 349px;
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}

#comment{
    border-bottom: none;
}

#dualDiv{
	display: none;
}

.error{
	color: red;
	font-weight: bold;
	font-size: 9pt;
}

</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function send(){
		$("#add_form").submit();
	}
	
	function dualCheck(){
		//버튼 눌렀을 때 똑같은 작성자의 방명록이 존재하면 중복확인해서 중복된 이름이라고만 알려주기
		var writer = $("#name").val();
		
		var xhr = new XMLHttpRequest();
		var param = "writer="+writer;
		var method = "POST";
		var url = "${pageContext.request.contextPath}/book/writercheck"
		
		xhr.open(method, url, true);
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var check = xhr.responseText;
				if(check == 404404){
					alert("DB 오류입니다. 관리자에게 문의하세요.");
				}else if(check == 0){
					$("#dualDiv").css("display", "block");
					$("#dualDiv").html("<h5>첫 방명록이시군요!</h5>");
					$("#dualDiv").css("color", "blue");
				}else{
					$("#dualDiv").css("display", "block");
					$("#dualDiv").html("<h5>이미 방명록을 남기셨네요.</h5>");
					$("#dualDiv").css("color", "red");
				}
			}
		}
		xhr.send(param);
		
	}
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1 class="title">ADD POST</h1>
		</div>
		<hr />
		<div class="content">
			<form:form action="${pageContext.request.contextPath}/book/add" method="post" id="add_form" modelAttribute="userBookVo">
				<table>
					<tr>
						<th>Name</th>
						<td>
							<form:input id="name" type="text" path="writer" placeholder="이름을 입력하세요."/>
							<button type="button" onclick="dualCheck();">중복 확인</button>
							<form:errors path="writer" class="error"/>
							<div id="dualDiv"></div>
						</td>
					</tr>
					<tr>
						<th>Password</th>
						<td>
							<form:password id="password" path="password" placeholder="비밀번호를 입력하세요."/>
							<br />
							<form:errors path="password" class="error"/>
						</td>
					</tr>
					<tr>
						<th colspan="2" id="comment">Comment</th>
					</tr>
					<tr>
						<td colspan="2">
							<form:errors path="msg" class="error"/>
							<form:textarea path="msg" placeholder="내용을 입력해주세요."
							cols="50" rows="20"></form:textarea>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
		<hr />
		<div class="footer text_center">
			<button class="smaLL" type="button" onclick="send();">등록</button>
			<button class="smaLL" type="button" onclick="history.back();">취소</button>
		</div>
	</div>
</body>
</html>