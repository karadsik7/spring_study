<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class="jumbotron">
		<h2 class="text-center">상품관리 시스템</h2>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xs-4">
				<table class="table table-striped table-hover">
					<caption class="text-center"><h4>:::입고 현황:::</h4></caption>
					<tr>
						<th>번호</th>
						<th>제품명</th>
						<th>수량</th>
						<th>변동일</th>
					</tr>
					<c:forEach var="pro" items="${productMap.inList }">
					<tr>
						<td>${pro.id }</td>
						<td>${pro.name }</td>
						<td>${pro.count }</td>
						<td>
							<f:parseDate var="date" value="${pro.regdate}" pattern="yyyy-MM-dd HH:mm:ss.SSS"/>
							<f:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss "/>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-xs-4">
				<table class="table table-striped table-hover">
					<caption class="text-center"><h4>:::재고 현황:::</h4></caption>
					<tr>
						<th>번호</th>
						<th>제품명</th>
						<th>수량</th>
						<th>변동일</th>
					</tr>
					<c:forEach var="pro" items="${productMap.remainList }">
					<tr>
						<td>${pro.id }</td>
						<td>${pro.name }</td>
						<td>${pro.count }</td>
						<td>
							<f:parseDate var="date" value="${pro.regdate}" pattern="yyyy-MM-dd HH:mm:ss.SSS"/>
							<f:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss "/>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-xs-4">
				<table class="table table-striped table-hover">
					<caption class="text-center"><h4>:::출고 현황:::</h4></caption>
					<tr>
						<th>번호</th>
						<th>제품명</th>
						<th>수량</th>
						<th>변동일</th>
					</tr>
					<c:forEach var="pro" items="${productMap.outList }">
					<tr>
						<td>${pro.id }</td>
						<td>${pro.name }</td>
						<td>${pro.count }</td>
						<td>
							<f:parseDate var="date" value="${pro.regdate}" pattern="yyyy-MM-dd HH:mm:ss.SSS"/>
							<f:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss "/>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<h4 class="text-center">제품 입고</h4>
				<form:form class="form-horizontal" action="/product/add/in" modelAttribute="productInVo">
					<div class="form-group">
						<form:label path="name" for="name" class="control-label col-sm-3">상품명</form:label>
						<div class="col-sm-9">
							<form:input path="name" class="form-control"/>
							<form:errors path="name" class="error" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="count" for="count" class="control-label col-sm-3">수량</form:label>
						<div class="col-sm-9">
							<form:input path="count" class="form-control"/>
							<form:errors path="count" class="error" />
						</div>
					</div>
					<div class="text-center">
						<button class="btn btn-primary">입고</button>
					</div>
				</form:form>
			</div>
			
			<div class="col-xs-4 col-xs-offset-4">
				<h4 class="text-center">제품 출고</h4>
				<form:form class="form-horizontal" action="/product/add/out" modelAttribute="productOutVo">
					<div class="form-group">
						<form:label path="name" for="name" class="control-label col-sm-3">상품명</form:label>
						<div class="col-sm-9">
							<form:input path="name" class="form-control"/>
							<form:errors path="name" class="error" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="count" for="count" class="control-label col-sm-3">수량</form:label>
						<div class="col-sm-9">
							<form:input path="count" class="form-control"/>
							<form:errors path="count" class="error" />
						</div>
					</div>
					<div class="text-center">
						<button class="btn btn-warning">출고</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	



<!-- script library -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>