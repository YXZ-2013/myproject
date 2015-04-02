package com.myproject.easyui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value = "/user/userList", method = RequestMethod.GET)
	public String userListView() {
		return "user/userList";
	}
}
