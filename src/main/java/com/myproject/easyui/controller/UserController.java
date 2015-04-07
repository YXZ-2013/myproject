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
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.easyui.web.util.ResponseResult;
import com.myproject.model.User;

@Controller
public class UserController {
	@RequestMapping(value = "/manager/user/userList", method = RequestMethod.GET)
	public String userListView(Model model) {
		return "/user/userList";
	}

	@ResponseBody
	@RequestMapping(value = "/manager/user/userList", method = RequestMethod.POST)
	public String getUserData(Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		String resource = "/mybatis-config-test.xml";
		InputStream is = UserController.class.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		String statement = "com.myproject.mybatis.user.userMapper.getAll";
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageNum", Integer.parseInt(page));
		map.put("pageSize", Integer.parseInt(rows));
		List<User> userList = session.selectList(statement, map);
		session.commit();
		session.close();
		ResponseResult result = new ResponseResult();
		result.setTotal(100);
		result.setRows(userList);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(result);
	}
}
