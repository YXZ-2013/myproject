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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproject.easyui.web.util.ResponseResult;
import com.myproject.model.User;

/**
 * 用户处理层
 * 
 * @author yinxunzhi
 * @creatTime 2015年4月7日下午4:40:06
 * @version 1.0
 * @description
 */
@Controller
public class UserController {
	/**
	 * 用户列表显示
	 * 
	 * @author yinxunzhi
	 * @time 2015年4月7日下午4:41:38
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/manager/user/userList", method = RequestMethod.GET)
	public String userListView(Model model) {
		return "/user/userList";
	}

	/**
	 * 返回用户列表所需数据
	 * 
	 * @author yinxunzhi
	 * @time 2015年4月7日下午4:41:58
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
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
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
		List<User> userList = session.selectList(statement);
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		session.commit();
		session.close();
		ResponseResult result = new ResponseResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(userList);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(result);
	}
}
