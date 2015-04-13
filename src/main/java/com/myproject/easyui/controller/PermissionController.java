package com.myproject.easyui.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproject.easyui.web.util.ResponseResult;
import com.myproject.model.Permission;
/**
 * Permission控制层
 * @author 尹逊志
 * @time 2015年4月13日下午10:38:30
 *
 */
@Controller
public class PermissionController {
	/**
	 * permission列表页
	 * @author 尹逊志
	 * @time 2015年4月13日下午10:29:05
	 *
	 */
	@RequestMapping(value="/user/permissionList",method=RequestMethod.GET)
	public String getPermissonListView(){
		return "/user/permisson";
	}
	/**
	 * 获取permission数据集合
	 * @author 尹逊志
	 * @throws JsonProcessingException 
	 * @time 2015年4月13日下午10:29:36
	 *
	 */
	@RequestMapping(value="/user/permissionList",method=RequestMethod.POST)
	public String getPermissonData(HttpServletRequest request,HttpServletResponse response) throws JsonProcessingException{
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		if (rows == null) {
			rows = "20";
		}
		if (page == null) {
			page = "1";
		}
		String resource = "/mybatis-config-test.xml";
		InputStream is = UserController.class.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		String statement = "com.myproject.mybatis.user.permissionMapper.getAll";
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("pageNum", Integer.parseInt(page));
		map.put("pageSize", Integer.parseInt(rows));
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
		List<Permission> permissList = session.selectList(statement);
		PageInfo<Permission> pageInfo = new PageInfo<Permission>(permissList);
		session.commit();
		session.close();ResponseResult result = new ResponseResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(permissList);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(result);
	}
	
	
}
