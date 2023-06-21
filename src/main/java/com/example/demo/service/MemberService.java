package com.example.demo.service;

import com.example.demo.model.Member;

public interface MemberService {

	public String insertMember(Member member) throws Exception;
	
	boolean verifyLogin(String id, String pw);

    public Member getMemberDetail(String id) throws Exception;

    public String updateMember(Member member) throws Exception;

    public String deleteMember(String id) throws Exception;
    
    public String getNickname(String id) throws Exception;
    
}
