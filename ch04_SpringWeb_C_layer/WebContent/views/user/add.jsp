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
		<form action="/user/add" class="form-horizontal" method="post">
			<div class="form-group">
				<label for="id" class="col-sm-4 control-label">ID</label>
				<div class="col-sm-4">
					<input type="text" name="id" id="id" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-4 control-label">Password</label>
				<div class="col-sm-4">
					<input type="password" name="password" id="password" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-4 control-label">NAME</label>
				<div class="col-sm-4">
					<input type="text" name="name" id="name" class="form-control"/>
				</div>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary">전송</button>
			</div>
		</form>
	</div>


<!-- script library -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>