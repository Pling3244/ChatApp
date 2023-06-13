package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class Board {

	private String id;
	private String writter;
	private String title;
	private String content;
	private String user_count;
	private String bar_name;
	private String bar_addr;
	
//	private String meetdate;
//	private String regdate;
	
}
