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
.error{
	color: red;
	font-weight: bold;
	font-size: 9pt;
}

</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function send(){
		$("#mod_form").submit();
	}
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1 class="title">UPDATE POST</h1>
		</div>
		<hr />
		<div class="content">
			<form:form action="${pageContext.request.contextPath}/book/modify" method="post" id="mod_form" modelAttribute="modifyBookVo">
			<input type="hidden" name="id" value = "${modifyBookVo.id }"/>
				<table>
					<tr>
						<th>Name</th>
						<td>
							<form:input id="name" type="text" path="writer" placeholder="이름을 입력하세요."
							value = "${modifyBookVo.writer }"/>
							<br />
							<form:errors path="writer" class="error"/>
						</td>
					</tr>
					<tr>
						<th>Password</th>
						<td>
							<form:password id="password" path="password" placeholder="비밀번호를 입력하세요."/>
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
							cols="50" rows="20" value="${modifyBookVo.msg }"></form:textarea>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
		<hr />
		<div class="footer text_center">
			<button class="smaLL" type="button" onclick="send();">수정</button>
			<button class="smaLL" type="button" onclick="history.back();">취소</button>
		</div>
	</div>
</body>
</html>