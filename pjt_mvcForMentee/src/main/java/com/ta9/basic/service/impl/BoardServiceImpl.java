package com.ta9.basic.service.impl;

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

}
