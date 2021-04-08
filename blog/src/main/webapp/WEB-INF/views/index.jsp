<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ include file="layout/header.jsp" %>

	
	<div class="container">
	
	<c:forEach var="board" items="${boards.content}">
		<div class="card m-2">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>
	
	<ul class="pagination justify-content-center">
	  <c:choose>
	  	<c:when test="${board.first}">
	  		<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Prev</a></li>
	  	</c:when>
	  	<c:otherwise>
	  		<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Prev</a></li>
	  	</c:otherwise>
	  </c:choose>
	  
	  <li class="page-item"><a class="page-link" href="#">1</a></li>
	  <li class="page-item"><a class="page-link" href="#">2</a></li>
	  <li class="page-item"><a class="page-link" href="#">3</a></li>
	  <li class="page-item"><a class="page-link" href="#">4</a></li>
	  <li class="page-item"><a class="page-link" href="#">5</a></li>
	  
	  <c:choose>
	  	<c:when test="${board.last}">
	  		<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
	  	</c:when>
	  	<c:otherwise>
	  		<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
	  	</c:otherwise>
	  </c:choose>
	
	  
	  
	  
	</ul>
	
	</div>

<%@ include file="layout/footer.jsp" %>
