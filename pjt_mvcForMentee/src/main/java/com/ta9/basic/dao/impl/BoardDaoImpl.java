package com.ta9.basic.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ta9.basic.dao.BoardDao;
import com.ta9.basic.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDaoImpl implements BoardDao {

	private final SqlSession sqlSession;
	
	@Override
	public int write(BoardVo boardVo) throws Exception {
		return sqlSession.insert("boardMapper.insert", boardVo);
	}

	@Override
	public List<BoardVo> list() throws Exception {
		return sqlSession.selectList("boardMapper.list");
	}

	@Override
	public BoardVo read(int brd_no) throws Exception {
		return sqlSession.selectOne("boardMapper.read", brd_no);
	}

	@Override
	public void update(BoardVo boardVo) throws Exception {
		sqlSession.update("boardMapper.update", boardVo);
	}

	@Override
	public void delete(int brd_no) throws Exception {
		sqlSession.delete("boardMapper.delete", brd_no);
	}
}
