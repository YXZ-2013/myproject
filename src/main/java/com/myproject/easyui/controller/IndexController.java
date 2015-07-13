package com.myproject.easyui.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.model.SystemInfo;

@Controller
public class IndexController {

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/")
	public ModelAndView indexView(Model model) {
//		SessionInfo sessionInfo = (SessionInfo) session
//				.getAttribute("sessionInfo");
//		if (sessionInfo != null && sessionInfo.getUserId() != null) {
			return new ModelAndView("index");
		// } else {
		// return new ModelAndView("login");
		// }
	}

	@RequestMapping(value = "/index_center")
	public String indexCenterView(Model model) {
		model.addAttribute("systemInfo", new SystemInfo());
		return "index_center";
	}
}
