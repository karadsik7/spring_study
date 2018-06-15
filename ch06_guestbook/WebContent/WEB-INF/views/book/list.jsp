<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function del(id){
		var url = "${pageContext.request.contextPath}/book/password";
		$.ajax({
			//JSON이 js내부에서만 처리되고 다른언어로 전송되지 않는다면 키값에 ""는 제거가능
			url : url,
			data : "id="+id,
			type : "post",
			//익명함수의 파라미터로 데이터가 들어옴
			success : function(data){
				var userPassword = prompt("비밀번호를 입력해주세요");
				if(data == userPassword){
					//비밀번호 일치
					location.href = "delete?id="+id;
				}else{
					//비밀번호 불일치
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
			}
		});
	}
	
	function mod(id){
		var url = "${pageContext.request.contextPath}/book/password";
		
		$.ajax({
			url : url,
			type : "post",
			data : {id : id},//"id="+id,
			success : function(data){
				var password = data;
				var userPassword = prompt("비밀번호를 입력하세요");
				if(password != userPassword){
					alert("패스워드가 일치하지 않습니다.")
					return;
				}else{
					location.href = "modify?id="+id;
				}
			}
		})
	}
	
	function search(){
		var search_option = $("#search_option").val();
		var search_text = $("#search_text").val();
		if(search_option != "all" && search_text == ""){
			alert("검색어를 입력하세요.");
			$("#search_text").focus();
			return;
		}
		//똑같은 페이지로 요청하는 경우 url(서블릿 경로)을 생략할 수 있다.
		location.href = "?search_option="+search_option+"&search_text="+search_text;
	}
	
	$(function(){
		$("#search_text").val('${param.search_text}');
		var options = $("#search_option").children("option");
		for(var i of options){
			if($(i).val() == "${param.search_option}"){
				$(i).attr("selected", "selected")
				break;
			}
		}
	})
</script>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1 class="title">GUEST BOOK</h1>
			<div class="search">
				<select id="search_option">
					<option value="all">전체리스트 보기</option>
					<option value="name">작성자</option>
					<option value="msg">내용</option>
					<option value="name_msg">작성자+내용</option>
				</select>
				<input type="text" id="search_text"/>
				<input type="button" value="검색" onclick="search();"/>
			</div>
		</div>
		<hr />
		<div class="footer">
			<button class="big" type="button" onclick="location.href='${pageContext.request.contextPath}/book/add'">Write</button>
		</div>
		<hr />
		<div class="content">
		<c:if test="${empty bookList }">
			<p class="text_center">첫 게시물을 작성해 보세요~!</p>
		</c:if>
		<c:forEach var="bvo" items="${bookList }">
			<div class="comment">
				<div class="msg">${bvo.msg }</div>
				<div class="grid_3_7">
					<div class="text_center">Writer</div>
					<div>${bvo.writer }(${bvo.ip })</div>
				</div>
				<div class="grid_3_7">
					<div class="text_center">Date</div>
					<div>${bvo.writedate }</div>
				</div>
				<div class="text_center">
					<button type="button" class="smaLL" onclick="del('${bvo.id }');">Delete</button>
					<button type="button" class="smaLL" onclick="mod('${bvo.id }');">Modify</button>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
</body>
</html>