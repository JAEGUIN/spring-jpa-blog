package com.jaeguinblog.I.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.jaeguinblog.I.model.Board;


public interface BoardRepository extends JpaRepository<Board, Integer>{

	
}

