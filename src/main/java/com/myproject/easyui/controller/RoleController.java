package com.myproject.easyui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproject.easyui.service.RoleService;
import com.myproject.easyui.web.util.ResponseResult;
import com.myproject.model.ResponseJson;
import com.myproject.model.Role;


/**
 * 角色处理
 * 	shaql
 * @author Administrator
 *
 */
@Controller
public class RoleController extends BaseController{

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
	public void userAddResponse(@ModelAttribute("role") Role role,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseJson responseJson = new ResponseJson();
//		String id = request.getParameter("id");
//		if(id != null && id != ""){//修改
//			role.setId(id);
//			roleService.updateRole(role);
//		}else {//新增
//			//role.setId(role.getName());
//		}
		roleService.addRole(role);
		responseJson.setSuccess(true);
	} 
	
	/**
	 * 角色编辑页面
	 */
//	@ResponseBody
	@RequestMapping(value = "/role/roleEdit", method = RequestMethod.GET)
	public String roleAddView(Model model,HttpServletRequest request) throws JsonProcessingException {	
		String id = request.getParameter("id");
		if(id!=null){
			Role role = new Role();
			role.setId(id);
			role=roleService.getRole(role);
			model.addAttribute("role", role);
			return "/user/roleEdit";
//			ObjectMapper mapper = new ObjectMapper();
//			return mapper.writeValueAsString(role);
		}else {
			return "failer";
		}
	}
	
	@RequestMapping(value = "/role/updateRole", method = RequestMethod.POST)
	public void updateRole(@ModelAttribute("role") Role role,
			HttpServletRequest request, HttpServletResponse response){
		roleService.updateRole(role);
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		writeJson(responseJson, response);
	}
	
	
	/**
	 * 角色删除
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/role/roleRemove", method=RequestMethod.POST)
	public void delRole(HttpServletRequest request, HttpServletResponse response){
		ResponseJson rj = new ResponseJson();
		String roleId = request.getParameter("id");
		roleService.deleteRole(roleId);
		rj.setMsg("删除角色成功");
		rj.setSuccess(true);
		writeJson(rj,response);
	}
	
	/**
	 * 角色添加页面     shaql
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/roleAdd", method = RequestMethod.GET)
	public String roleAddView(Model model){
		return "/user/roleAdd";
	} 

	
}	