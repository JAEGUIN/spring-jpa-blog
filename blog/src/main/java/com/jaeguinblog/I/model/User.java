package com.jaeguinblog.I.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  //빌더 패턴!
@Entity  //테이블화를 위해 붙여줌 user 클래스가 Mysql에 테이블이 자동으로 생성됨.
//@DynamicInsert //insert 할때 null인 필드 제외
public class User {
	
	//jpa는 orm이다 orm은 언어 내에 object를 테이블로 매핑해주는 기술
	
	@Id  //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 프로젝트에 연결된 db의 넘버링 전략을 따라감
	private int id; //시퀀스, auto_increment로 넘버링해줌  혹시 안되면 int로 바꿔
	
	@Column(nullable = false, length = 30)
	private String username; //id 대용
	
	@Column(nullable = false, length = 100) //해쉬로 넘겨서 비번 암호화 할거임 그래서 넉넉하면 좋아
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	
	//@ColumnDefault("'user'") // 큰따옴표 안에 작은 따옴표 넣어야함 
	//private String role; //Enum 을 써야함 왜냐면 어떤 데이터에 도메인을 만들어 줄 수 있음 //회원 권한 관리에 좋음
	@Enumerated(EnumType.STRING)
	private RoleType role; //user admin
	
	@CreationTimestamp //시간 자동 입력
	private Timestamp createDate; //원래는 회원정보 수정하는 update도 필요함
		

}
