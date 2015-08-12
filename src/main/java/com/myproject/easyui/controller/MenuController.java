package com.myproject.easyui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.easyui.service.MenuService;
import com.myproject.model.EasyTreeNode;
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
	@ResponseBody
	public List<EasyTreeNode> ctrlTree(@RequestParam(required = false) String id) {
		List<Menu> menuList = new ArrayList<Menu>(0);
		List<EasyTreeNode> nodeList = new ArrayList<EasyTreeNode>(0);
		if(id == null){
			menuList = menuService.getParentMenus();
		}else{
			menuList = menuService.getChildrenMenus(id);
		}
		for(Menu menu :menuList){
			EasyTreeNode node = new EasyTreeNode();
			convertMenuToTreeNode(menu,node);
			nodeList.add(node);
		}
		return nodeList;
	}
	/**
	 * 把菜单实体类转换为树节点格式
	 * @param menu
	 * @param node
	 */
	private void convertMenuToTreeNode(Menu menu, EasyTreeNode node) {
		node.setId(menu.getId());
		node.setText(menu.getName());
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("url", menu.getUrl());
		node.setAttributes(attributes);
		if(menu.getUrl() ==null){
			node.setState("closed");
		}
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
		writeJson(menuService.getAllMenus(), response);
	}

	/**
	 * 删除选中菜单
	 * 
	 * @author zhangdong
	 */
	@RequestMapping(value = "/menu/delMenu", method = RequestMethod.POST)
	public void delMenu(HttpServletRequest request, HttpServletResponse response) {
		ResponseJson rj = new ResponseJson();
		String id = request.getParameter("id");
		List<Menu> menus = menuService.getMenuList(id);
		if (menus.size() == 0) {
			menuService.delMenu(id);
			rj.setSuccess(true);
			rj.setMsg("删除成功");
			writeJson(rj, response);
		} else {
			rj.setMsg("该菜单下还有子菜单，不能删除，请先删除子菜单！");
			writeJson(rj, response);
		}
	}

	/**
	 * 修改菜单页面
	 */
	@RequestMapping(value = "/menu/editMenu", method = RequestMethod.GET)
	public String editMenu(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		Menu menu = menuService.getMenuById(id);
		model.addAttribute("menu", menu);
		return "/menu/menuEdit";
	}
	/**
	 * 修改菜单数据
	 * @param menu
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/menu/updateMenu", method = RequestMethod.POST)
	public void updateMenu(@ModelAttribute("menu") Menu menu,
			HttpServletRequest request, HttpServletResponse response) {
		menuService.updateMenu(menu);
		ResponseJson responseJson = new ResponseJson();
		responseJson.setSuccess(true);
		responseJson.setMsg("添加成功");
		writeJson(responseJson, response);
	}

	/**
	 * 添加页面
	 * @return
	 */
	@RequestMapping(value = "/menu/addMenu", method = RequestMethod.GET)
	public String addMenuView() {
		return "/menu/menuAdd";
	}

	/**
	 * 添加数据
	 * @param menu
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/menu/addMenu", method = RequestMethod.POST)
	public void addMenu(@ModelAttribute("menu") Menu menu,
			HttpServletRequest request, HttpServletResponse response) {
		ResponseJson responseJson = new ResponseJson();
		if (StringUtils.isEmpty(menu.getId())
				&& StringUtils.isEmpty(menu.getUrl())
				&& StringUtils.isEmpty(menu.getName())) {
			responseJson.setSuccess(false);
			responseJson.setMsg("资源ID,资源路径,资源名称不能为空");
			writeJson(responseJson, response);
			return;
		}
		if (StringUtils.isEmpty(menu.getSeqNum())) {
			menu.setSeqNum(1);
		}
		menuService.addMenu(menu);
		responseJson.setSuccess(true);
		writeJson(responseJson, response);
	}

	/**
	 * 请求获取菜单(资源)节点
	 * @author 尹逊志
	 * @time 2015年5月27日下午10:53:35
	 */
	@ResponseBody
	@RequestMapping(value = "menu/tree", method = RequestMethod.POST)
	public List<EasyTreeNode> getMenuTree() {
		List<EasyTreeNode> tree = menuService.getMenuTree(new Menu(), true);
		return tree;
	}

}
