package com.jaeguinblog.I.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jaeguinblog.I.service.BoardService;



@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping({"", "/"})
	public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) { //데이터를 가져오기 위해 model 사용

		model.addAttribute("boards", boardService.postlist(pageable));
		return "index"; //viewResolver 작동하고 해당 index패이지로 정보를 들고 있음
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.postdetail(id)	);
		return "board/detail";
	}
	
	
	//USER 권한이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
