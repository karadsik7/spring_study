<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f"
           uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" 
           uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" 
      content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>
	.error{color:red}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
	<div class="container">
		<!-- 폼태그에서 method 생략 가능 (기본값 post) -->
		<form:form action="/user/add" class="form-horizontal" modelAttribute="userVo">
			<div class="form-group">
				<label for="id" class="col-sm-3 control-label">ID</label>
				
				<div class="col-sm-7">
					<!-- input태그에서 기본값 text라 type생략가능, modelAttribute로 등록한 이름과 path의 변수몀이 일치하면
					value도 생략가능 -->
					<form:input class="form-control" 
					            id="id" path="id"/>
					<form:errors path="id" class="error"/>            
				</div>
				<div class="col-sm-2 text-center">
					<button type="button" onclick="dualCheck()"
					        class="btn btn-success">중복확인</button>
				</div>
			</div>
			<div class="form-group">
				<label for="password" 
				       class="col-sm-3 control-label">PWD</label>
				<div class="col-sm-9">
					<form:password class="form-control" 
					       id="password" path="password"/>
					<form:errors path="password" class="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-3 control-label">Name</label>
				<div class="col-sm-9">
					<form:input class="form-control" 
					            id="name" path="name"/>
					<form:errors path="name" class="error"/>					            
				</div>
			</div>
			<div class="form-group">
				<label for="bjob" class="col-sm-3 control-label">Big Job</label>
				<div class="col-sm-2">
					<form:select id="bjob" path="bjob" class="form-control" onchange="getSjobList()">
						<form:option value="">선택</form:option>
						<c:forEach var="bjob" items="${bjobList }"> 
							<form:option value="${bjob.id }">${bjob.name }</form:option>
						</c:forEach>
					</form:select>
					
				</div>
				<div class="col-sm-7">
					<form:errors path="bjob" class="error"/>
				</div>
			</div>
			<div class="form-group">
				<label for="sjob" class="col-sm-3 control-label">Small Job</label>
				<div class="col-sm-2">
					<form:select id="sjob" path="sjob" class="form-control">
						<form:option value="">선택</form:option>
					</form:select>
				</div>
				<div class="col-sm-7">
					<form:errors path="sjob" class="error"/>
				</div>
			</div>
			<div class="text-center">
				<button class="btn btn-primary" type="submit">전송</button>
			</div>
		</form:form>
		
	</div>

<!-- script libary -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
	$(function(){
		getSjobList();
	})
	function dualCheck(){
		var id = $("#id").val();
		$.ajax({
			url:"/user/dualcheck",
			type:"post",
			data:{id:id},
			success:function(data){
				if(data == "yes"){
					alert("중복된 아이디 입니다.");
				}else{
					alert("사용 가능한 아이디 입니다.");
				}
			}
		});
	}
	
	function getSjobList(){
		var b_id = $("#bjob").val();
		//console.log(b_id);
		$.ajax({
			url:"/sjob/list",
			type:"post",
			data:{b_id:b_id},
			success:function(sjobList){
				$("#sjob").empty();
				$("#sjob").append("<option val=''>선택</option>");
				for(var sjob of sjobList){
					var $option = 
						$("<option>").val(sjob.id).text(sjob.name);
					$("#sjob").append($option);
				}
			}
		});
	}
</script>
</body>
</html>













