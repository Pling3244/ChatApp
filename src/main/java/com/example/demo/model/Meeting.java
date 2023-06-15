package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meeting {

	private String id;
	private String meeting_title;
	private String meeting_content;
	private String user;
	private String start_date;
	private String end_date;
	private String meeting_place_name;
	private String meeting_place_spot;
	private String meeting_place_imgurl;

}
