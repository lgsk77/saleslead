package com.team4.saleslead.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team4.saleslead.model.dto.Member;
import com.team4.saleslead.model.dto.Target;
import com.team4.saleslead.model.service.TargetService;

@Controller
@RequestMapping(value = "/targeting/")
public class TargetController {

	@Autowired
	@Qualifier("targetService")
	private TargetService targetService;

	@RequestMapping(value = "view.action", method = RequestMethod.GET)
	public ModelAndView idList(HttpServletRequest req, HttpSession session) {
		System.out.println("1");
		ModelAndView mav = new ModelAndView();
		//로그인 상태가 아닌 경우 로그인 페이지로 이동
	
		String url = "view.action";
		Member member = (Member)session.getAttribute("loginuser");
		
		
		//데이터베이스에서 데이터 조회
		List<Target> targets = targetService.selectAllId();
		
		
		
		mav.setViewName("targeting/view");
		mav.addObject("targets", targets);
		
		
		return mav;
				
	
		
		/*int total = carService.selectTotalOutcomeByCarindex(carindex);
		
		List<Car> cars = null;
		
		if(carindex == 0){
			cars = carService.selectCarindexByMemberno(member.getMemberNo());
		}else{
			System.out.println(carindex);
			Car car = carService.selectCarByCarindex(carindex);
			cars = new ArrayList<>();
			cars.add(car);
		}
		mav.addObject("cars", cars);
		mav.addObject("total", total);
		return mav;*/

	}
	
}
