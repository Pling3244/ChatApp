package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class MemberController {

	@Autowired
    private final MemberService memberService;
    
    @PostMapping("/insertMember")
    public String insertMember(@RequestParam String id, String pw, String nickname) throws Exception {
    	Member member = new Member();
    	member.setId(id);
    	member.setPw(pw);
    	member.setNickname(nickname);
           return memberService.insertMember(member);
    }

    @GetMapping("/getMemberDetail")
    public Member getMemberDetail(@RequestParam String id) throws Exception {
           return memberService.getMemberDetail(id);
    }

    @PostMapping("/updateMember")
    public String updateMember(@RequestParam String id, String pw, String nickname) throws Exception {
    	Member member = new Member();
    	member.setId(id);
    	member.setPw(pw);
    	member.setNickname(nickname);
           return memberService.updateMember(member);
    }

    @GetMapping("/deleteMember")
    public String deleteMember(@RequestParam String id) throws Exception {
           return memberService.deleteMember(id);
    }
}
