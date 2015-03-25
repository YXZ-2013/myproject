package com.myproject.easyui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.model.SystemInfo;

@Controller
public class IndexController {
	@RequestMapping(value = "/")
	public ModelAndView indexView(Model model) {
		return new ModelAndView("index");
	}
	@RequestMapping(value = "/index_center")
	public String indexCenterView(Model model){
		model.addAttribute("systemInfo", new SystemInfo());
		return "index_center"; 
	}
}
