package com.jaeguinblog.I.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jaeguinblog.I.model.User;

//DataAccessObeject
//자동으로 bean 등록이 된다.

//덕분에 @Repository 가 생략 가능하다.
public interface UserRepository extends JpaRepository<User, Integer>{
	// SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
}


	//Jpa naming 전략
	//select * from user where username = ?1 AND pawwrod = ?2; 이런 쿼리가 동작함
	//User findByEmailAndPassword(String useremail, String password);

	//	@Query(value = "select * from user where username = ?1 AND pawwrod = ?2", nativeQuery = true )
	//	User login(String username, String password); 지금은 간단한 용도라 주석처리함.