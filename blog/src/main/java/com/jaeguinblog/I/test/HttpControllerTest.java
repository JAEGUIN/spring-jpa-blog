package com.jaeguinblog.I.test;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//(h t ml)이 응답하게 만들고 싶으면  @Controller
//컨트롤로 rest controller없이 쓰고 싶으면 각 메서드에 ResponseBody를 써주면 된다(굳이?)


//사용자가 요청 -> data를 응답하게 만들고 싶으면 @RestController

//get mapping대신에  @RequestMapping도 쓸 수 있음
//하지만 요즘은 더 직관적이게 get mapping으로 한다.

//https://pasudo123.tistory.com/79

@RestController
public class HttpControllerTest {
	
	private static final String TAG="HttpControllerTest";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("jaeguin").password("1234").email("ssar@gmail.com").build();
		System.out.println(TAG+"getter:"+m.getUsername());
		m.setUsername("jaeguin");
		System.out.println(TAG+"setter:"+m.getUsername());
		return "lombok test 완료";
	}

	//인터넷 브라우저 요청은 무조건 get요청만 할 수 있음!!!
	//get(select)
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get요청" +m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();		
	}

	
	//post(insert)
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post요청"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();		
	}
	
	
	//put(update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put요청"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();		
	}
	
	
	//delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete요청";		
		
	}
}
