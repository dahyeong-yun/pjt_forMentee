package com.ta9.basic.service;

import java.util.List;

import com.ta9.basic.vo.BoardVo;

public interface BoardService {
	public void write(BoardVo boardVo) throws Exception;
	public List<BoardVo> list() throws Exception;
	public BoardVo read(int brd_no) throws Exception;
	public void update(BoardVo boardVo) throws Exception;
	public void delete(int brd_no) throws Exception;
}
