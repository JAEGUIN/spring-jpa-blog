package com.jaeguinblog.I.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaeguinblog.I.model.Board;
import com.jaeguinblog.I.model.User;
import com.jaeguinblog.I.repository.BoardRepository;


//스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해줌. IoC를 해줌.
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void write(Board board, User user) { //title, content
		board.setCount(0); //board.java에서 조회수 , @ColumnDefault("0") 이거는 따로 값을 넣을거니 지운 부분
		board.setUser(user);
		boardRepository.save(board);			
	}
}
