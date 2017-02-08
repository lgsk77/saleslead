package com.team4.saleslead.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team4.saleslead.common.Util;
import com.team4.saleslead.model.dto.Member;
import com.team4.saleslead.model.service.MemberService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;

	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String loginForm() {

		return "account/loginform";
	}

	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String memberId, String passWd, HttpSession session) {

		//passWd = Util.getHashedString(passWd, "SHA-256");
		
		

		Member member = memberService.selectMemberByIdAndPasswd(memberId, passWd);
		
		System.out.println("세션정보 : "+member.getMemberId());
		if (member != null) {
			// 세션에 로그인 정보 저장
			session.setAttribute("loginuser", member);
			
			return "redirect:../home.action";
		} else {
			return "account/loginform";
		}

	}

	@RequestMapping(value = "/logout.action", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.removeAttribute("loginuser");// 로그아웃
		return "redirect:../home.action";
	}

}
