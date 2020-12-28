package com.ta9.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ta9.basic.service.BoardService;
import com.ta9.basic.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 게시판 글 작성 화면
		@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
		public void writeView() throws Exception{
			logger.info("writeView");
			
		}
		
		// 게시판 글 작성
		@RequestMapping(value = "/board/write", method = RequestMethod.POST)
		public String write(BoardVo boardVo) throws Exception{
			logger.info("write");
			boardService.write(boardVo);
			return "redirect:/";
		}
		
		// 게시판 목록 조회
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public String list(Model model) throws Exception{
			logger.info("list");
			model.addAttribute("list", boardService.list());
			return "board/list";
			
		}
}
