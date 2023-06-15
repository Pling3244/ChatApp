package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Meeting;
import com.example.demo.service.MeetingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class MeetingController {
	
	@Autowired
    private final MeetingService meetingService;
	
	@GetMapping("/getMeetingList")
    public List<Meeting> doGetMeetingList() {
		List<Meeting> meeting = meetingService.getMeetingList();
         return meeting;
   }
	
	@PostMapping("/insertMeeting")
	public String doInsertMeeting(@RequestParam String meeting_title, String meeting_content, String user, String start_date, String end_date, String meeting_place_name, String meeting_place_spot, String meeting_place_imgurl) {
		Meeting meeting = new Meeting();
		meeting.setMeeting_title(meeting_title);
		meeting.setMeeting_content(meeting_content);
		meeting.setUser(user);
		meeting.setStart_date(start_date);
		meeting.setEnd_date(end_date);
		meeting.setMeeting_place_name(meeting_place_name);
		meeting.setMeeting_place_spot(meeting_place_spot);
		meeting.setMeeting_place_imgurl(meeting_place_imgurl);
           return meetingService.insertMeeting(meeting);	
	}
	
	@GetMapping("/getOneMeeting")
	public Meeting getOneMeeting(@RequestParam String id) {
	       return meetingService.getOneMeeting(id);
	}
	 
	@GetMapping("/deleteMeeting")
    public String deleteMeeting(@RequestParam String id)  {
           return meetingService.deleteMeeting(id);
    }
	
	@PostMapping("/updateMeeting")
    public String updateBoard(@RequestParam String id, String meeting_title, String meeting_content, String user, String start_date, String end_date, String meeting_place_name, String meeting_place_spot, String meeting_place_imgurl) {
		Meeting meeting = new Meeting();
		meeting.setMeeting_title(meeting_title);
		meeting.setMeeting_content(meeting_content);
		meeting.setUser(user);
		meeting.setStart_date(start_date);
		meeting.setEnd_date(end_date);
		meeting.setMeeting_place_name(meeting_place_name);
		meeting.setMeeting_place_spot(meeting_place_spot);
		meeting.setMeeting_place_imgurl(meeting_place_imgurl);
           return meetingService.updateMeeting(id, meeting);
    }
}
