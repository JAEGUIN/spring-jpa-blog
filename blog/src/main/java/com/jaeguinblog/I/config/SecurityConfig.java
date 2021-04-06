package com.jaeguinblog.I.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jaeguinblog.I.config.auth.PrincipalDetailService;


//빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는것


//3개가 시큐리티 세트임
@Configuration //빈 등록(IoC)
@EnableWebSecurity  //시큐리티 필터가 등록됨
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean //함수 값이 IoC가 됨
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	//시큐리티가 대신 로그인하면 pw가 가로채기를 하는데
	//해당 pw가 뭘로 해쉬가 되어 회원가입이 되어 있는지 알아야
	//같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());//pw비교를 위해 꼭 필요.
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable() //csrf 토큰 비활성화 (테스트할 때 걸어두면 좋다) csrf가 없는 상태로 요청하면 그냥 막음
		.authorizeRequests() //요청들어오면 
			.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**")  //이 범위에 들어오면
			.permitAll()  //허락
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/loginForm")
			.loginProcessingUrl("/auth/loginProc")//스프링 시큐가 해당 주소로 로그인을 가로채서 대신 로그인
			.defaultSuccessUrl("/"); 
	}

}
