package com.team4.saleslead.model.dao;

import com.team4.saleslead.model.dto.Member;

public interface MemberDao {

	void insertMember(Member member);
	Member selectMemberByIdAndPasswd(String memberId, String passWd);
	void updateMember(Member member);
	void deleteMember(String memberId);
	Member selectMemberByMemberId(String memberId);
	

}