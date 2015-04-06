package com.myproject.easyui.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.model.User;

@Controller
public class UserController {
	@RequestMapping(value = "/manager/user/userList", method = RequestMethod.GET)
	public String userListView(Model model) {
		String resource = "/mybatis-config-test.xml";
		InputStream is = UserController.class.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		String statement = "com.myproject.mybatis.user.userMapper.getAll";
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageNum", 1);
		map.put("pageSize", 10);
		List<User> userList = session.selectList(statement, map);
		session.commit();
		session.close();
		model.addAttribute("userList", userList);
		return "/user/userList";
	}

	@RequestMapping(value = "/user/userList1", method = RequestMethod.POST)
	public void getUserData(Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println(111);
		System.out.println(1111);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("111");
	}

	@RequestMapping(value = "/user/userList", method = RequestMethod.GET)
	public String getUserData() {
		return "/user/userList";
	}
}
