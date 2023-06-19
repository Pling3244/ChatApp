package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Meeting;
import com.example.demo.model.Member;
import com.example.demo.model.Message;
import com.example.demo.service.MeetingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class MeetingController {
	
	@Autowired
    private final MeetingService meetingService;
	
	@GetMapping("/getMeetingByNickname")
	public List<Meeting> getMeetingByNickname(@RequestParam String nickname) {
		return meetingService.getMeetingByNickname(nickname);
	}
	
	@PostMapping("/insertMeeting")
	public String insertMeeting(@RequestBody Meeting meeting) {
       return meetingService.insertMeeting(meeting);	
	}
	
	@GetMapping("/getOneMeeting")
	public Meeting getOneMeeting(@RequestParam String meeting_id) {
	       return meetingService.getOneMeeting(meeting_id);
	}
	 
	@GetMapping("/deleteMeeting")
    public String deleteMeeting(@RequestParam String meeting_id)  {
           return meetingService.deleteMeeting(meeting_id);
    }
	
	@PostMapping("/updateMeeting")
	public String updateMeeting(@RequestParam String meeting_id, @RequestBody Meeting meeting) {
		return meetingService.updateMeeting(meeting_id, meeting);
	}
	
	@PostMapping("/addMember")
    public String addMember(@RequestParam String meeting_id, @RequestBody Member member) {
        return meetingService.addMember(meeting_id, member);
    }

    @PostMapping("/removeMember")
    public String removeMember(@RequestParam String meeting_id, @RequestBody Member member) {
        return meetingService.removeMember(meeting_id, member);
    }

    @PostMapping("/addMessage")
    public String addMessage(@RequestParam String meeting_id, @RequestBody Message message) {
        return meetingService.addMessage(meeting_id, message);
    }
}
