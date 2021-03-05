package com.jaeguinblog.I.test;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor  //전체 생성자
@NoArgsConstructor  //이거는 빈 생성자
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	//private final String email;
	//final로 할 경우 변결할 일이 없어야한다 예를 들면 비번 바꾸기 이런거

	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email=email;
	}
	
}
