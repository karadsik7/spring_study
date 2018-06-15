<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(function(){
		lock();
		for(var option of $("#search_option").children()){
			if($(option).val() == '${param.option}'){
				$(option).attr("selected", "selected");
			}
		}
	})
	function lock(){
		if($("#search_option").val() == "all"){
			$("#search_text").attr("disabled", "disabled");
			$("#search_text").val("");
			
			
		}else{
			$("#search_text").removeAttr("disabled");
		}
	}
	
	function search(){
		var option = $("#search_option").val();
		var text = $("#search_text").val();
		if(option != 'all' && text == ""){
			alert("검색어를 입력하세요.");
			$("#search_text").focus;
			return;
		}
		location.href = '?option='+option+"&text="+text;
	}
</script>
</head>
<body>
<div class="container">
	<div class="header">
		<h3 class="title text_center">자유게시판</h3>
		<div class="search">
			<select id="search_option" onchange="lock();">
				<option value="all">전체</option>
				<option value="title">제목</option>
				<option value="name">이름</option>
				<option value="content">내용</option>
				<option value="title_content">제목+내용</option>
			</select>
			<input type="text" id="search_text" value="${param.text }" />
			<button type="button" onclick="search();">검색</button>
		</div>
	</div>
	<div class="body">
		<table class="board">
			<tr>
				<th style="width:10%">번호</th>
				<th style="width:55%">제목</th>
				<th style="width:15%">이름</th>
				<th style="width:10%">날짜</th>
				<th style="width:10%">조회</th>
			</tr>
			<c:if test="${empty boardList }">
			<tr>
				<td colspan="5">게시물이 존재하지 않습니다.</td>
			</tr>
			</c:if>
			<c:forEach var="bvo" items="${boardList }">
			<tr>
				<td>${bvo.id }</td>
				<td style="text-align: left;">
					<c:forEach var="i" begin="1" end="${bvo.depth }">
						<c:if test="${i != bvo.depth}">
						&nbsp;&nbsp;&nbsp;
						</c:if>
						<c:if test="${i == bvo.depth }">
						└▶
						</c:if>
					</c:forEach>
					<a href="${pageContext.request.contextPath}/board/view?id=${bvo.id}&page=${param.page}">${bvo.title }</a></td>
				<td>${bvo.name }</td>
				<td>
					<f:parseDate var="date" value="${bvo.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
					<f:formatDate value="${date }" pattern="yyyy/MM/dd" />
				</td>
				<td>${bvo.hit }</td>
			</tr>
			</c:forEach>
		</table>
		<div class="buttons">
			<button type="button" onclick="location.href='${pageContext.request.contextPath}/board/add'">글쓰기</button>
		</div>
	</div>
	<div class="footer">
		<div class="paging text_center">
			${paging }
		</div>
	</div>
</div>
</body>
</html>