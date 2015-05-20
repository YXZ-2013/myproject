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
import com.myproject.easyui.service.UserBillService;
import com.myproject.easyui.web.util.ResponseResult;
import com.myproject.model.UserBill;


/**
 * 交易记录
 * 	shaql
 * @author Administrator
 *
 */
@Controller
public class UserBillController extends BaseController{

	@Autowired
	UserBillService userBillService;
	
	
	/**
	 * 交易记录显示页面     shaql
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/fund/userBillList", method = RequestMethod.GET)
	public String userBillListView(Model model){
		return "/fund/userBillList";
	} 
	/**
	 * 交易记录显示数据   shaql
	 * @param model
	 * @return 
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/fund/userBillList", method = RequestMethod.POST)
	public String getUserBillList(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		if (rows == null) {
			rows = "20";
		}
		if (page == null) {
			page = "1";
		}
		
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
		List<UserBill> userBillList = userBillService.getAll();
		PageInfo<UserBill>  pageInfo = new PageInfo<UserBill>(userBillList);
		ResponseResult result = new ResponseResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(userBillList);
		ObjectMapper mapper = new ObjectMapper();
		
		return  mapper.writeValueAsString(result);
	}
}
