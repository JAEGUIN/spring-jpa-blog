<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp" %>
	
	<div class="container">
		
		
		<button class="btn btn-secondary" onclick="history.back()"> <-back </button>
		
		<br/><br/>
		
		<div>
		 post No.<span id = "id"><i>${board.id}</i></span><br/>
		 writer : <span><i>${board.user.username}</i></span><br/>
		 </div>
		
		<div class="form-group">
			
			<h3>${board.title}</h3>
		</div>
		<hr />
		<div class="form-group">
		  
		  <div>${board.content}</div>
		</div>
		
		<c:if test="${board.user.id == principal.user.id}">
		<button id="btn-update" class="btn btn-warning"> edit </button>
		<button id="btn-delete" class="btn btn-danger"> del </button>
		</c:if>
	
	</div>
	
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>
