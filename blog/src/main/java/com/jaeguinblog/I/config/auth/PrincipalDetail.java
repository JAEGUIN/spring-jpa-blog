package com.jaeguinblog.I.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jaeguinblog.I.model.User;

import lombok.Data;
import lombok.Getter;

//스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면
//UserDetails 타입의 오브젝트를 스프링 시큐리티의 고유한 세션저장소(PrincipalDetail)에 저장함.
@Getter  //principal이 들고 있는 user 오브젝트가 필요해서 getter 사용
public class PrincipalDetail implements UserDetails{

	//UserDetails가 추상 메서드들을 가지고 있으니 override 해주자 (alt+shift+s)
	//extends 클래스를 확장하기 위한 것이고( 클래스는 선언과 내용이 들어가 있는 것 )
	//implements 인터페이스를 구현하기 위해 생긴 것이다. ( 인터페이스는 선언만 되어 있는 것 )
	
	private User user; //객체를 품고 있는 콤포지션이라고 한다. (extends User를 들고 오는건 상속)

	//PDService에서 리턴해주면 User user가 null 되니까 추가해준다.
	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}// 혹시 안되면 이메일 해봐
	
	
	//계정이 만료되지 않았는지 리턴한다. (true:만료 안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정이 잠겨있는지 확인(true:안 잠겨있음)
	@Override
	public boolean isAccountNonLocked() { 
		return true;
	}

	//비밀번호가 만료되지 않았는지 리턴 (true:만료 안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정이 활성화(사용가능)인지 리턴(true : 활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}

	//
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_" + user.getRole();});
		
		return collectors;
	}
	
	
}
