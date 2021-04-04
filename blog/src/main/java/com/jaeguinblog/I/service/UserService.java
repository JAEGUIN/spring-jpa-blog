package com.jaeguinblog.I.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaeguinblog.I.model.RoleType;
import com.jaeguinblog.I.model.User;
import com.jaeguinblog.I.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해줌. IoC를 해줌.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public void signup(User user) {
		String rawPassword = user.getPassword(); //1234 원문
		String encPassword = encoder.encode(rawPassword); //해쉬됨
		user.setPassword(encPassword);
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
			
	}
}
