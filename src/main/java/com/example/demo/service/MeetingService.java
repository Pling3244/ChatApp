package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Meeting;
import com.example.demo.model.Member;
import com.example.demo.model.Message;



public interface MeetingService {

	
	public List<Meeting> getMeetingByNickname(String nickname);

	public String insertMeeting(Meeting meeting);

	public Meeting getOneMeeting(String meeting_id);
	
	public String deleteMeeting(String meeting_id);
	
	public String updateMeeting(String meeting_id, Meeting meeting);
	
	public String addMember(String meeting_id, Member member);
	
	public String removeMember(String meeting_id, Member member);
	
	public String addMessage(String meeting_id, Message message);

	
}
