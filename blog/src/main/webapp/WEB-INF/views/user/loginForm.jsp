<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="#" method="post">
		<div class="form-group">
			<label for="email">Email address:</label> 
			<input type="email" name="email" class="form-control" placeholder="Enter email" id="email">
		</div>
		
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group form-check">
			<label class="form-check-label"> 
			<input name="remember" class="form-check-input" type="checkbox"> Remember me
			</label>
		</div>
		<button id="btn-login" class="btn btn-primary">Sign in</button>
		
	</form>
	


</div>

<!-- script src="/js/user.js"-->
<%@ include file="../layout/footer.jsp" %>
