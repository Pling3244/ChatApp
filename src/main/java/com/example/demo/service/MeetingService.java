package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Meeting;
import com.example.demo.model.Member;
import com.example.demo.model.Message;



public interface MeetingService {

	
	public List<Meeting> getMeetingByNickname(String nickname);

	public String insertMeeting(String boardid, Meeting meeting);

	public Meeting getOneMeeting(String boardid);
	
	public String deleteMeeting(String boardid);
	
	public String updateMeeting(String boardid, Meeting meeting);
	
	public String addMember(String boardid, Member member);
	
	public String removeMember(String boardid, Member member);
	
	public String addMessage(String boardid, Message message);

	
}
