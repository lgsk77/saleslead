package com.team4.saleslead.model.mapper;


import java.util.HashMap;

import com.team4.saleslead.model.dto.Member;

public interface MemberMapper {

	void insertMember(Member member);
	
	Member selectMemberByIdAndPasswd(HashMap<String, Object> params);
	
	void updateMember(Member member);
	
	void deleteMember(String memberId);
	
	Member selectMemberByMemberId(String memberId);
	
}



