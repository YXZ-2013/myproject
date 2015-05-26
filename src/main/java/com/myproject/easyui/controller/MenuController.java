package com.myproject.easyui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.easyui.service.MenuService;
import com.myproject.model.Menu;
import com.myproject.model.ResponseJson;

/**
 * @author yinxunzhi
 * @creatTime 2015年5月6日下午5:11:49
 * @version 1.0
 * @description
 */
@Controller
public class MenuController extends BaseController {

	@Autowired
	MenuService menuService;

	@Autowired
	HttpSession session;

	/**
	 * 后台管理菜单
	 * 
	 * @author yinxunzhi
	 * @time 2015年5月7日上午10:00:58
	 */
	@RequestMapping(value = "/manager/getManagetMenus", method = RequestMethod.POST)
	public void ctrlTree(HttpServletResponse response) {
		writeJson(menuService.getMenuTree(new Menu(), true), response);
	}

	/**
	 * 请求菜单列表
	 * 
	 * @author yinxunzhi
	 * @time 2015年5月12日下午5:10:28
	 * @return
	 */
	@RequestMapping(value = "/admin/menu/menuList", method = RequestMethod.GET)
	public String getMenuList() {
		return "menu/menuList";
	}

	/**
	 * 获取菜单列表数据
	 * 
	 * @author yinxunzhi
	 * @time 2015年5月12日下午5:10:40
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/admin/menu/menuList", method = RequestMethod.POST)
	public void getMenuList(HttpServletRequest request,HttpServletResponse response) {
		writeJson(menuService.getMenuList(), response);
	}
	
	/**
	 * 删除选中菜单
	 * @author zhangdong
	 */
	@RequestMapping(value="/menu/delMenu",method=RequestMethod.POST)
	public void delMenu(HttpServletRequest request,HttpServletResponse response){
		ResponseJson rj = new ResponseJson();
		String id = request.getParameter("id");
			List<Menu> menus= menuService.getMenuList(id);
			if(menus.size() == 0){
				menuService.delMenu(id);
				rj.setSuccess(true);
				rj.setMsg("删除成功");
				writeJson(rj, response);
			}else {
				rj.setMsg("该菜单下还有子菜单，不能删除，请先删除子菜单！");
				writeJson(rj, response);
			}
	}
	
	/**
	 * 修改菜单
	 */
	@RequestMapping(value="/menu/editMenu",method=RequestMethod.GET)
	public String editMenu(Model model,HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		if(StringUtils.isEmpty(id)){
			return null;
		}
		Menu menu = menuService.getMenuById(id);
		model.addAttribute("menu", menu);
		return "/menu/menuEdit";
	}
	
	@RequestMapping(value="/menu/updateMenu",method=RequestMethod.POST)
	public void updateMenu(@ModelAttribute("menu")Menu menu,HttpServletRequest request, HttpServletResponse response){
		menuService.updateMenu(menu);
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		writeJson(responseJson, response);
	}
	
//	@RequestMapping(value="/menu/addMenu",method=RequestMethod.GET)
	public String addMenu(){
		return "/menu/menuEdit";
	}
	
}
