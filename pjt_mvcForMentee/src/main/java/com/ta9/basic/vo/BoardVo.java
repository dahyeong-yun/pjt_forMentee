package com.ta9.basic.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVo {
	private int brd_no;
	private String brd_title;
	private String brd_content;
	private String brd_writer;
	private Timestamp brd_created;
}
