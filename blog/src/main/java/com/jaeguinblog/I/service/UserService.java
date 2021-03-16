package com.jaeguinblog.I.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaeguinblog.I.model.User;
import com.jaeguinblog.I.repository.UserRepository;

//스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해줌. IoC를 해줌.
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void signup(User user) {
		userRepository.save(user);
			
	}
}
