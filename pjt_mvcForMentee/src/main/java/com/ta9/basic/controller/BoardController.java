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
@RequestMapping("/board")
public class BoardController {

	private final BoardService boardService;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 게시물 작성 페이지
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
	}
	
	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVo boardVo) throws Exception{
		logger.info("write");
		boardService.write(boardVo);
		return "redirect:/board/list";
	}
		
	// 게시물 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list");
		model.addAttribute("list", boardService.list());
		return "board/list";
	}
	
	// 게시물 조회
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardVo boardVo, Model model) throws Exception{
		logger.info("read");
		model.addAttribute("read", boardService.read(boardVo.getBrd_no()));
		return "board/readView";
	}
	
	// 게시물 수정 페이지
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardVo boardVo, Model model) throws Exception{
		logger.info("updateView");
		model.addAttribute("update", boardService.read(boardVo.getBrd_no()));
		return "board/updateView";
	}
	
	// 게시물 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVo boardVo) throws Exception{
		logger.info("update");
		boardService.update(boardVo);
		return "redirect:/board/list";
	}

	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVo boardVo) throws Exception{
		logger.info("delete");
		boardService.delete(boardVo.getBrd_no());
		return "redirect:/board/list";
	}
}
