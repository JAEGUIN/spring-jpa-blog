package com.jaeguinblog.I.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController //패키지 이하를 스캔해서 특정 어노테이션이 붙어 있는 클래스 파일을 
					//new해서(IoC) 스프링 컨테이터에 관리


public class BlogControllerTest {
	
	@GetMapping("/test/hell")
	public String hello() {
		return "<h1>hell winter boot</h1>";
	}

}
