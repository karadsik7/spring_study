<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="/views/include/nav.jsp" />
	<div class="container">
		<h3 class="text-center">User List</h3>
		<div class="row">
			<table class="table table-sripped col-sm-6">
				<tr>
					<th>아이디</th>
					<th>이름</th>
				</tr>
				<c:forEach var="uvo" items="${userList }">
				<tr>
					<td>${uvo.id }</td>
					<td>${uvo.name }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>


<!-- script library -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>