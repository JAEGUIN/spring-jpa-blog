package com.jaeguinblog.I.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaeguinblog.I.dto.ResponseDto;
import com.jaeguinblog.I.model.User;
import com.jaeguinblog.I.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
			 
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {//username,email,pw
		System.out.println("UserApiController:save 호출됨.");
		//실제로 db에 insert하고 아래에서 return이 되야함.
		
 
		userService.signup(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);//1에는 나중에 db insert하고 리턴된값 넣을거임.
		
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user) { // key=value, x-www-form-urlencoded
		userService.edituser(user);
		// 여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됐음.
		// 하지만 세션값은 변경되지 않은 상태이기 때문에 우리가 직접 세션값을 변경해줄 것임.
		

		//세션등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
