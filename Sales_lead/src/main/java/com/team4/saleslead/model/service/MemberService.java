package com.team4.saleslead.model.service;


import com.team4.saleslead.model.dto.Member;

public interface MemberService {

	void insertMember(Member member);
	Member selectMemberByIdAndPasswd(String memberId, String passWd);
	void updateMember(Member member);
	void deleteMember(String memberId);
	Member selectMemberByMemberId(String memberId);
}



