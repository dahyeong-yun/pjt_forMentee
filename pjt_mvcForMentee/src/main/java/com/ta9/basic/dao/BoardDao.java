package com.ta9.basic.dao;

import java.util.List;

import com.ta9.basic.vo.BoardVo;

public interface BoardDao {
	public void write(BoardVo boardVo) throws Exception;
	public List<BoardVo> list() throws Exception;
	public BoardVo read(int brd_no) throws Exception;
}
