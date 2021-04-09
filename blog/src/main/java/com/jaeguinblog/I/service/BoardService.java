package com.jaeguinblog.I.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaeguinblog.I.config.auth.PrincipalDetail;
import com.jaeguinblog.I.model.Board;
import com.jaeguinblog.I.model.User;
import com.jaeguinblog.I.repository.BoardRepository;


//스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해줌. IoC를 해줌.
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void postwrite(Board board, User user) { //title, content
		board.setCount(0); //board.java에서 조회수 , @ColumnDefault("0") 이거는 따로 값을 넣을거니 지운 부분
		board.setUser(user);
		boardRepository.save(board);			
	}
	
	@Transactional(readOnly = true)
	public Page<Board> postlist(Pageable pageable){
		return boardRepository.findAll(pageable); //findall로 리스트 가져온다
	}
	
	@Transactional(readOnly = true)
	public Board postdetail(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패!");					
				});
		
	}
	
	@Transactional
    public void postdelete(int id, PrincipalDetail principal) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글 찾기 실패 : 해당 글이 존재하지 않습니다.");
        });

        if (board.getUser().getId() != principal.getUser().getId()) {
            throw new IllegalStateException("글 삭제 실패 : 해당 글을 삭제할 권한이 없습니다.");
        }
        boardRepository.delete(board);
	}
}
