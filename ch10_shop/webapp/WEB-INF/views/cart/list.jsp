<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/shop.css" />
<style>
	a{
		text-decoration: underline;
		color: purple;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function del(id, u_id){
		location.href = "${pageContext.request.contextPath}/cart/del?id="+id+"&u_id="+u_id;
	}
</script>
</head>
<body>
	<div class="main">
	<div class="header">
		<h1 class="title text_center">장바구니</h1>
		<jsp:include page="../menu.jsp" />
	</div>
	<div class="content_view">
		<table class="view">
			<tr>
				<th>상품명</th>
				<th>수량</th>
				<th>단가</th>
				<th>금액</th>
				<th>비고</th>
			</tr>
			<c:forEach var="cvo" items="${cartList }">
				<tr>
					<td><a href="${pageContext.request.contextPath}/product/view?id=${cvo.pvo.id}">${cvo.pvo.model }</a></td>
					<td>
					<form action="${pageContext.request.contextPath }/cart/modify"
							      method="post">
							     <input name="u_id" type="hidden" value="${cvo.u_id }"/>
							    <input type="hidden" name="id" value="${cvo.id }" />
								<input type="text" name="count" value="${cvo.count }"
								       style="width:20px"/>
								<button type="submit">수정</button>
					</form>
					<td>
					<f:formatNumber pattern="###,###" value="${cvo.pvo.price*(1-cvo.pvo.retail_pct) }"/>
					</td>
					<td>
					<f:formatNumber pattern="###,###" value="${cvo.pvo.price*(1-cvo.pvo.retail_pct)*cvo.count }"/>
					</td>
					<td>
						<button type="button" onclick="del(${cvo.id}, '${cvo.u_id }');">삭제</button>
					</td>
				</tr>
			</form>
			</c:forEach>
			
			<tr>
				<th colspan="3" style="text-align: right;">예상 구매 금액</th>
				<td>
				<f:formatNumber pattern="###,###" value="${total }"/>원
				</td>
				<td><button type="button">구매하기</button></td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>