package com.jaeguinblog.I.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaeguinblog.I.dto.ResponseDto;
import com.jaeguinblog.I.model.RoleType;
import com.jaeguinblog.I.model.User;
import com.jaeguinblog.I.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {//username,email,pw
		System.out.println("UserApiController:save 호출됨.");
		//실제로 db에 insert하고 아래에서 return이 되야함.
		user.setRole(RoleType.USER);
		userService.signup(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);//1에는 나중에 db insert하고 리턴된값 넣을거임.
		
	}

}
