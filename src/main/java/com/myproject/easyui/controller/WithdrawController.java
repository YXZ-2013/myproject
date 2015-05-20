package com.myproject.easyui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproject.easyui.service.WithdrawService;
import com.myproject.easyui.web.util.ResponseResult;
import com.myproject.model.Withdraw;


/**
 * 提现管理
 * 	shaql
 * @author Administrator
 *
 */
@Controller
public class WithdrawController extends BaseController{

	@Autowired
	WithdrawService withdrawService;
	
	
	/**
	 * 提现管理显示页面     shaql
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/withdraw/withdrawList", method = RequestMethod.GET)
	public String withdrawListView(Model model){
		return "/withdraw/withdrawList";
	} 
	/**
	 * 提现管理显示数据   shaql
	 * @param model
	 * @return 
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/withdraw/withdrawList", method = RequestMethod.POST)
	public String getWithdrawList(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		if (rows == null) {
			rows = "20";
		}
		if (page == null) {
			page = "1";
		}
		
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
		List<Withdraw> withdrawList = withdrawService.getAll();
		PageInfo<Withdraw>  pageInfo = new PageInfo<Withdraw>(withdrawList);
		ResponseResult result = new ResponseResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(withdrawList);
		ObjectMapper mapper = new ObjectMapper();
		
		return  mapper.writeValueAsString(result);
	}
	
//	@RequestMapping(value = "/user/roleSave", method = RequestMethod.POST)
//	public String userAddResponse(@ModelAttribute("role") Role role,
//			HttpServletRequest request, HttpServletResponse response) {
//		role.setId(role.getName());
//		role.setDescription(role.getDescription());
//		String resource = "/mybatis-config-test.xml";
//		InputStream is = LoanController.class.getResourceAsStream(resource);
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = factory.openSession();
//		String statement = "com.myproject.mybatis.role.roleMapper.saveUser";
//		session.insert(statement, role);
//		session.commit();
//		session.close();
//		return null;
//	} 
	
}
