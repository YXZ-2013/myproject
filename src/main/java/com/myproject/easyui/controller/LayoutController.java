package com.myproject.easyui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LayoutController {
	@RequestMapping(value = "layout", method = RequestMethod.GET)
	public ModelAndView getFullView() {
		System.out.println(1);
		ModelAndView mav = new ModelAndView();
		System.out.println(1);
		mav.setViewName("layout.jsp");
		return mav;
	}
}
