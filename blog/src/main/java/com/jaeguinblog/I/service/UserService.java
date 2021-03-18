package com.jaeguinblog.I.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly = true) //select할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
	public User login(User user) {
		return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
			
	}
}
