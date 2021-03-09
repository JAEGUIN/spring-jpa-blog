package com.jaeguinblog.I.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaeguinblog.I.model.User;

//DataAccessObeject
//자동으로 bean 등록이 된다.

//덕분에 @Repository 가 생략 가능하다.
public interface UserRepository extends JpaRepository<User, Integer>{

}
