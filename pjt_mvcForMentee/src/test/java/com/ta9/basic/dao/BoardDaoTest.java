package com.ta9.basic.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ta9.basic.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDaoTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	//@Transactional
	public void BoradWriteTest() throws Exception {
		BoardVo boardVo = new BoardVo();
		boardVo.setBrd_title("제목 테스트 코드");
		boardVo.setBrd_content("내용 테스트 코드");
		boardVo.setBrd_writer("작성자 테스트 코드");
		
		int result = boardDao.write(boardVo);
		assertThat("게시물이 등록되면 등록 결과 값이 1", result, is(equalTo(1)));
	}
	
	@Test
	//@Transactional
	public void BoradUpdateTest() throws Exception {
		int readBoardNo = 131;
		String updatedContents = "테스트로 내용 수정";
		BoardVo readBoardVo = boardDao.read(readBoardNo);
		readBoardVo.setBrd_content(updatedContents);
		boardDao.update(readBoardVo);
		
		BoardVo updatedBoardVo = boardDao.read(readBoardNo);
		
		assertThat("게시물 업데이트 테스트",updatedBoardVo.getBrd_content(), is(equalTo(updatedContents)));
		
	}
}
