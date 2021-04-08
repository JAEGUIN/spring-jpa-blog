<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp" %>
	
	<div class="container">
		
		
		<button class="btn btn-secondary" onclick="history.back()"> <-back </button>
		
		<br/><br/>
		
		<div class="form-group">
			
			<h3>${board.title}</h3>
		</div>
		<hr />
		<div class="form-group">
		  
		  <div>${board.content}</div>
		</div>
		
		
		<button class="btn btn-warning"> edit </button>
		<button class="btn btn-danger"> del </button>
		
	
	</div>
	
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>
