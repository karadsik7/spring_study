<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f"
           uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" 
      content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="/views/include/nav.jsp"/>
	<div class="container">
		<form action="/user/modify" class="form-horizontal" 
		      method="post">
			<div class="form-group">
				<input type="hidden" name="id" value="${uvo.id }" />
				<label for="id" class="col-sm-3 control-label">ID</label>
				<div class="col-sm-9">
					<p><b>${uvo.id }</b></p>
				</div>
			</div>
			<div class="form-group">
				<label for="password" 
				       class="col-sm-3 control-label">PWD</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" 
					       id="password" name="password" placeholder="미입력시 기본 패스워드로 유지됩니다."/>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-3 control-label">Name</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" 
					       id="name" name="name" value="${uvo.name }"/>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" 
					       id="email" name="email"/>
				</div>
			</div>
			<div class="text-center">
				<button class="btn btn-primary" type="submit">수정</button>
			</div>
		</form>
		
	</div>

<!-- script libary -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>