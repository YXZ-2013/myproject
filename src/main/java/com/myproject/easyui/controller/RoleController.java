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
import com.myproject.model.Role;


/**
 * 角色处理
 * 	shaql
 * @author Administrator
 *
 */
@Controller
public class RoleController {

	
	/**
	 * 角色显示页面     shaql
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/role/roleList", method = RequestMethod.GET)
	public String roleListView(Model model){
		return "/role/roleList";
	} 
	
	
	@ResponseBody
	@RequestMapping(value = "/role/roleList", method = RequestMethod.POST)
	public String getRoleData(Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		if (rows == null) {
			rows = "20";
		}
		if (page == null) {
			page = "1";
		}
		String resource = "/mybatis-config-test.xml";
		InputStream is = RoleController.class.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		String statement = "com.myproject.mybatis.role.roleMapper.getAll";
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageNum", Integer.parseInt(page));
		map.put("pageSize", Integer.parseInt(rows));
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
		List<Role> roleList = session.selectList(statement);
		PageInfo<Role>  pageInfo = new PageInfo<Role>(roleList);
		session.commit();
		session.close();
		ResponseResult result = new ResponseResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(roleList);
		ObjectMapper mapper = new ObjectMapper();
		
		return  mapper.writeValueAsString(result);
	}
	
}
