package com.jaeguinblog.I.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  //빌더 패턴!
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto_increment 사용
	private Long id;  //혹시 안되면 int로 바꿔
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob//대용량 데이터
	private String content; //섬머노트 라이브러리 <html> 태그가 섞여서 디자인됨.
	
	@ColumnDefault("0")
	private int count; //조회수
	
	@ManyToOne  //userId라고만 하면 연관관계가 없어서 맺어줄러면 manytoone을 호출한다. Many = many, User=one
	@JoinColumn(name="userId")
	private User user; //JPA에서 DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
							   //원래는 java에서 int로 키값으로 저장함.
	@CreationTimestamp
	private Timestamp createDate;
	

}
