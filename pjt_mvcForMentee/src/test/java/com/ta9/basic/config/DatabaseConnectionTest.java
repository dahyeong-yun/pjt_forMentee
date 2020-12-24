package com.ta9.basic.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class DatabaseConnectionTest {

	@Autowired
	private DataSource ds;
	@Autowired
	private SqlSessionFactory sqlFactory;

	@Test
	public void ConnectionCompleteTest() {
		try (Connection con = ds.getConnection();) {
			System.err.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void sqlFactoryInitTest() {
		System.err.println(sqlFactory);
	}

	@Test
	public void sqlSessionOpenTest() {
		try (SqlSession session = sqlFactory.openSession()) {
			System.err.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
