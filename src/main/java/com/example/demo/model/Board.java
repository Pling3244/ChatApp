package com.example.demo.model;

import java.util.List;

import com.google.firebase.messaging.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Board {

	private String boardid;
	private String writter;
	private String title;
	private String content;
	private String user_count;
	private String bar_name;
	private String bar_addr;
	
	private String meetdate;
	private String regdate;

	
}
