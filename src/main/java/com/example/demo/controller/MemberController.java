package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LoginResponse;
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
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody Member member) throws Exception {
        LoginResponse response = new LoginResponse();

        System.out.println("Incoming id: " + member.getId());
        System.out.println("Incoming pw: " + member.getPw());

        boolean loginSuccessful = memberService.verifyLogin(member.getId(), member.getPw());

        if (loginSuccessful) {
            response.setStatus("success");
            response.setMessage("Login successful");
            response.setSessionId(member.getId());
            response.setSessionPw(member.getPw());

            // 추가: 닉네임 값 가져오기
            String nickname = memberService.getNickname(member.getId());
            response.setSessionNickname(nickname);
            System.out.println("Incoming nickname: " + nickname);
        } else {
            response.setStatus("fail");
            response.setMessage("Login failed");
            response.setSessionId("");
            response.setSessionPw("");
            response.setSessionNickname("");
        }

        return response;
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
