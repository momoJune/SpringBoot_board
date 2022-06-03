package com.admiin.man.vo;
/*
	create table sample_board(
	idx int auto_increment,
	title varchar(100),
	content varchar(2000),
	writer varchar(50) not null,
	regdate timestamp default now(),
	updatedate timestamp default now(),
	constraint comment primary key(idx)
);
 */

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int idx;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
}
