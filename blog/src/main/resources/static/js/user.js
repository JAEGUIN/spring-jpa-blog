let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{ //function(){}, ()=>{}this를 바인딩하기 위해!
			this.save();
		});
		
	},
	
	save:function(){
		//alert('user의 save함수 호출됨'); 팝업창
		let data = {
			username: $("#username").val(),
			email: $("#email").val(),
			password: $("#password").val(),
		}
		
		//console.log(data); 콘솔창으로 확인
		
		
		//ajax호출 시 defaul가 비동기 호출
		
		$.ajax({
			//통신해서 회원가입 수행 요청
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data), // http body 데이터
			contentType:"application/json; charset=utf-8", //body데이터가 어떤 타입인지
			dataType:"json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(새긴게 json이라면)=>js오브젝트로 변경해줌
			//datatype 주석처리하면 : ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌.
		}).done(function(resp){
			alert("회원가입 완료!");
			//console.log(resp);
			location.href="/";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
			
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 inser요청
	},	
} 

index.init();
