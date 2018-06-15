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
	<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
	<div class="container">
		<form action="/user/add" class="form-horizontal" 
		      method="post">
			<div class="form-group">
				<label for="id" class="col-sm-3 control-label">ID</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" 
					       id="id" name="id"/>
				</div>
				<div class="col-sm-2 text-center">
					<button type="button" onclick="dualCheck();" class="btn btn-success">중복확인</button>
				</div>
			</div>
			<div class="form-group">
				<label for="password" 
				       class="col-sm-3 control-label">PWD</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" 
					       id="password" name="password"/>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-3 control-label">Name</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" 
					       id="name" name="name"/>
				</div>
			</div>
			<div class="form-group">
				<label for="bjob" class="col-sm-3 control-label">BIG JOB</label>
				<div class="col-sm-3">
					<select name="bjob" id="bjob" class="form-control" onchange="getSjobList();">
						<option value="">선택</option>
						<c:forEach var="bjob" items="${bjobList }">
							<option value="${bjob.id }">${bjob.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="sjob" class="col-sm-3 control-label">SMALL JOB</label>
				<div class="col-sm-3">
					<select name="sjob" id="sjob" class="form-control">
						<option value="">선택</option>
					</select>
				</div>
			</div>
			<div class="text-center">
				<button class="btn btn-primary" type="submit">전송</button>
			</div>
		</form>
	</div>

<!-- script libary -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
	function dualCheck(){
		var id = $("#id").val();
		$.ajax({
			url : "/user/dualCheck",
			type : "post",
			data : {id : id},
			success : function(data){
				if(data == "dual"){
					alert("중복된 아이디입니다.");
				}else if(data == "notDual"){
					alert("사용 가능합니다.");
				}else{
					alert("서버 오류입니다.");
				}
			}
		})
	}
	
	function getSjobList(){
		var b_id = $("#bjob").val();
		$.ajax({
			url : "/sjob/list",
			method : "post",
			data : {b_id : b_id},
			success : function(sjobList){
				$("#sjob").empty();
				$("#sjob").append("<option value=''>선택</option>")
				for(var sjob of sjobList){
					var $option = $("<option>").val(sjob.id).text(sjob.name);
					$("#sjob").append($option);
				}
			}
		});
		
	}
</script>
</body>
</html>