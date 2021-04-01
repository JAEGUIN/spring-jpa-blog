package com.jaeguinblog.I.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는것


//3개가 시큐리티 세트임
@Configuration //빈 등록(IoC)
@EnableWebSecurity  //시큐리티 필터가 등록됨
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests() //요청들어오면 
			.antMatchers("/auth/**")  //이 범위에 들어오면
			.permitAll()  //허락
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/loginForm");
	}

}
