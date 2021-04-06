<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp" %>
	
	<div class="container">
	
		<form>
	
		<!--div class="form-group">
			<label for="email">Email address:</label> 
			<input type="text" name="email" class="form-control" placeholder="Enter email" id="email">
		</div-->
		
		<div class="form-group">
			<label for="title">Title</label> 
			<input type="text"  class="form-control"  id="title">
		</div>
		
		<div class="form-group">
		  <label for="content">Content</label> 
		  <textarea class="form-control summernote" rows="5" id="content"></textarea>
		</div>
		
		
		<!--   div class="form-group form-check">
			<label class="form-check-label"> 
			<input name="remember" class="form-check-input" type="checkbox"> Remember me
			</label>
		</div-->
		
		
		
		</form>
	<button id="btn-save" class="btn btn-primary">Submit</button>		  
	</div>
	
	<script>
      $('.summernote').summernote({
        placeholder: '',
        tabsize: 2,
        height: 300
      });
    </script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>
