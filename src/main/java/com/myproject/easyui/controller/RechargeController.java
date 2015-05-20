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
import com.myproject.easyui.service.RechargeService;
import com.myproject.easyui.service.WithdrawService;
import com.myproject.easyui.web.util.ResponseResult;
import com.myproject.model.Recharge;
import com.myproject.model.Withdraw;


/**
 * 充值管理
 * 	shaql
 * @author Administrator
 *
 */
@Controller
public class RechargeController extends BaseController{

	@Autowired
	RechargeService rechargeService;
	
	
	/**
	 * 充值管理显示页面     shaql
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/recharge/rechargeList", method = RequestMethod.GET)
	public String rechargeListView(Model model){
		return "/recharge/rechargeList";
	} 
	/**
	 * 充值管理显示数据   shaql
	 * @param model
	 * @return 
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/recharge/rechargeList", method = RequestMethod.POST)
	public String getRechargeList(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		if (rows == null) {
			rows = "20";
		}
		if (page == null) {
			page = "1";
		}
		
		PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
		List<Recharge> rechargeList = rechargeService.getAll();
		PageInfo<Recharge>  pageInfo = new PageInfo<Recharge>(rechargeList);
		ResponseResult result = new ResponseResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(rechargeList);
		ObjectMapper mapper = new ObjectMapper();
		
		return  mapper.writeValueAsString(result);
	}

	
}
