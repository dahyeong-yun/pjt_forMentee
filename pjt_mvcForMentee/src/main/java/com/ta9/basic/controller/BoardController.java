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
	
	// �Խ��� �� �ۼ� ȭ��
		@RequestMapping(value = "/writeView", method = RequestMethod.GET)
		public void writeView() throws Exception{
			logger.info("writeView");
		}
		
		// �Խ��� �� �ۼ�
		@RequestMapping(value = "/write", method = RequestMethod.POST)
		public String write(BoardVo boardVo) throws Exception{
			logger.info("write");
			boardService.write(boardVo);
			return "redirect:/list";
		}
		
		// �Խ��� ��� ��ȸ
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public String list(Model model) throws Exception{
			logger.info("list");
			model.addAttribute("list", boardService.list());
			return "board/list";
		}
		
		// �Խ��� ��ȸ
		@RequestMapping(value = "/readView", method = RequestMethod.GET)
		public String read(BoardVo boardVo, Model model) throws Exception{
			logger.info("read");
			model.addAttribute("read", boardService.read(boardVo.getBrd_no()));
			return "board/readView";
		}
		
		// �Խ��� ������
		@RequestMapping(value = "/updateView", method = RequestMethod.GET)
		public String updateView(BoardVo boardVo, Model model) throws Exception{
			logger.info("updateView");
			model.addAttribute("update", boardService.read(boardVo.getBrd_no()));
			return "board/updateView";
		}
		
		// �Խ��� ����
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		public String update(BoardVo boardVo) throws Exception{
			logger.info("update");
			boardService.update(boardVo);
			return "redirect:/board/list";
		}

		// �Խ��� ����
		@RequestMapping(value = "/delete", method = RequestMethod.POST)
		public String delete(BoardVo boardVo) throws Exception{
			logger.info("delete");
			boardService.delete(boardVo.getBrd_no());
			return "redirect:/board/list";
		}
}
