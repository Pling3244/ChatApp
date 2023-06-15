package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Meeting;


public interface MeetingService {

	
	public List<Meeting> getMeetingList();

	public String insertMeeting(Meeting meeting);

	public Meeting getOneMeeting(String id);
	
	public String deleteMeeting(String id);
	
	public String updateMeeting(String id, Meeting meeting);
	
//	public void insertUserinmeeting(Userinmeeting userinmeeting);
//	
//	public Userinmeeting getOneUserinmeeting(String userinmeeting_val); 
//	
//	
//	public List<User> getChatMemberList(int meeting_id); 
	
	
	
	public void deleteUserinmeeting(String email, int meeting_id);
	
	
	
	
}
