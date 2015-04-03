package com.myproject.easyui.controller;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		List<User> userList = session.selectList(statement);
		session.commit();
		session.close();
		model.addAttribute("userList", userList);
		return "/user/userList";
	}
}
