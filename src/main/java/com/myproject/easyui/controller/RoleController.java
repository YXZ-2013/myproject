package com.myproject.easyui.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproject.easyui.service.RoleService;
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

	@Autowired
	RoleService roleService;
	/**
	 * 角色显示页面     shaql
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/user/roleList", method = RequestMethod.GET)
	public String roleListView(Model model){
		return "/user/roleList";
	} 
	
	
	@ResponseBody
	@RequestMapping(value = "/user/roleList", method = RequestMethod.POST)
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
		
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
		List<Role> roleList = roleService.getAll();
		PageInfo<Role>  pageInfo = new PageInfo<Role>(roleList);
		ResponseResult result = new ResponseResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(roleList);
		ObjectMapper mapper = new ObjectMapper();
		
		return  mapper.writeValueAsString(result);
	}
	
	
	@RequestMapping(value = "/user/roleSave", method = RequestMethod.POST)
	public String userAddResponse(@ModelAttribute("role") Role role,
			HttpServletRequest request, HttpServletResponse response) {
		role.setId(role.getName());
		role.setDescription(role.getDescription());
		String resource = "/mybatis-config-test.xml";
		InputStream is = RoleController.class.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		String statement = "com.myproject.mybatis.role.roleMapper.saveUser";
		session.insert(statement, role);
		session.commit();
		session.close();
		return null;
	} 
	
}
