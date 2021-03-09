package com.jaeguinblog.I.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결괸 DB의 넘버링 전략을 따라감
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 200)
	private String content;

	
	@ManyToOne
	@JoinColumn(name="boardId")
	private Board board; 
	//하나의 게시글에는 여러개의 답변이 있을 수 있다
	//그래서 many to one 달아준다.
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	//foreign key 필요
	//여러개의 답변을 하나의 유저가 쓸수 있다.
	
	@CreationTimestamp
	private Timestamp createDate;
	//답변을 적은 시간
}









