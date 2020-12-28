package com.ta9.basic.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ta9.basic.dao.BoardDao;
import com.ta9.basic.service.BoardService;
import com.ta9.basic.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardDao dao;
	
	@Override
	public void write(BoardVo boardVo) throws Exception {
		dao.write(boardVo);
	}

	@Override
	public List<BoardVo> list() throws Exception {
		return dao.list();
	}

	@Override
	public BoardVo read(int brd_no) throws Exception {
		return dao.read(brd_no);
	}

}
