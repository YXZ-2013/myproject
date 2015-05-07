package com.myproject.easyui.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.easyui.service.MenuService;
import com.myproject.easyui.util.JsonUtil;
import com.myproject.model.Menu;
import com.myproject.model.SessionInfo;

/**
 * @author yinxunzhi
 * @creatTime 2015年5月6日下午5:11:49
 * @version 1.0
 * @description 
 */
@Controller
public class MenuController extends BaseController{
	private static final Logger logger = Logger.getLogger(MenuController.class);

	@Autowired
	MenuService menuService;
	@Autowired
	HttpSession session;
	/**
	 * 后台管理菜单
	 * @author yinxunzhi
	 * @time 2015年5月7日上午10:00:58
	 */
	@RequestMapping(value="/manager/getManagetMenus",method=RequestMethod.POST)
	public void ctrlTree(HttpServletResponse response) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
//		sessionInfo.setMenus(JsonUtil.writeJson(menuService.getMenuTree(new Menu(), true)));
	}
}
