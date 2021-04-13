package com.jaeguinblog.I.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jaeguinblog.I.config.auth.PrincipalDetail;

//인증이 안된 사용자들이 출입할 수 있는경로를 /auth/** 허용
//그냥 주소가 / 이면 index.jsp 허용해줄것
//static 이하에 있는 /js/**, /css/**, /image/**도 허용해줄것

@Controller
public class Usercontroller {

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {	
	  return "user/updateForm";
	}
}
