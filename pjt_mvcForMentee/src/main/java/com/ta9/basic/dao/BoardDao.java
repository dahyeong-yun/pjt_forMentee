package com.ta9.basic.dao;

import java.util.List;

import com.ta9.basic.vo.BoardVo;

public interface BoardDao {
	public int write(BoardVo boardVo) throws Exception;
	public List<BoardVo> list() throws Exception;
	public BoardVo read(int brd_no) throws Exception;
	public void update(BoardVo boardVO) throws Exception;
	public void delete(int brd_no) throws Exception;
}
