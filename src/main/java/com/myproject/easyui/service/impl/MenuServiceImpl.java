package com.myproject.easyui.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.MenuDao;
import com.myproject.easyui.service.MenuService;
import com.myproject.model.EasyTreeNode;
import com.myproject.model.Menu;

/**
 * @author yinxunzhi
 * @creatTime 2015年5月7日上午10:06:12
 * @version 1.0
 * @description
 */
@Service(value = "menuService")
public class MenuServiceImpl implements MenuService {

	private static final Logger logger = Logger.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuDao menuDao;

	/**
	 * 后台管理的菜单树
	 * 
	 * @author yinxunzhi
	 * @time 2015年5月7日下午3:12:36
	 * @param menu
	 * @param flag
	 * @return
	 */
	public List<EasyTreeNode> getMenuTree(Menu menu, boolean flag) {
		List<EasyTreeNode> tree = new ArrayList<EasyTreeNode>(0);
		List<Menu> menuList = menuDao.getMenuListByType("Management");
		 for (Menu m : menuList) {
		 List<Menu> children = menuDao.getMenuListByParentId(m.getId());
		 m.setChildren(children);
		 tree.add(tree(m, flag));
		 }
		return tree;
	}

	private EasyTreeNode tree(Menu menu, boolean flag) {
		EasyTreeNode node = new EasyTreeNode();
		node.setId(menu.getId());
		node.setText(menu.getName());
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("url", menu.getUrl());
		node.setAttributes(attributes);
		if (menu.getChildren() != null && menu.getChildren().size() > 0) {
			node.setState("closed");
			if (flag) {
				List<EasyTreeNode> children = new ArrayList<EasyTreeNode>();
				for (Menu m : menu.getChildren()) {
					tree(m, flag);
					children.add(tree(m, true));
				}
				node.setChildren(children);
			}
		}
		return node;
	}

	public List<Menu> getMenuList() {
		List<Menu> parents = menuDao.getMenuList();
		for (Menu menu2 : parents) {
			List<Menu> children = menuDao.getMenuListByParentId(menu2.getId());
			menu2.setChildren(children);
		}
		return parents;
	}

	public List<Menu> getMenuList(String menuId) {
		return menuDao.getMenuListByParentId(menuId);
	}

	public void delMenu(String id) {
		menuDao.delMenu(id);
	}

	public Menu getMenuById(String id) {
		Menu menu = menuDao.getMenuById(id);
		if (menu.getParentId()!=null) {
			menu.setParentName(menuDao.getMenuById(menu.getParentId()).getName());
		}
		return menu;
	}

	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu);
	}

	public void addMenu(Menu menu) {
		menuDao.addMenu(menu);
	}

	public List<Menu> getAllMenus() {
		long now = System.currentTimeMillis();
		List<Menu> menuList = menuDao.getAllMenus();
		Map<String, Menu> maps = new HashMap<String, Menu>();
		for (Menu menu : menuList) {
			if(StringUtils.isEmpty(menu.getParentId())){
				maps.put(menu.getId(), menu);
			}else{
				Menu parent = maps.get(menu.getParentId());
				if(parent == null){
					maps.put(menu.getId(), menu);
				}
				if (parent!=null) {
				if(parent.getChildren() == null){
					List<Menu> children = new ArrayList<Menu>();
					parent.setChildren(children);
				}
				parent.getChildren().add(menu);
				}
			}
		}
		menuList.removeAll(menuList);
		for(Menu menu:maps.values()){
			menuList.add(menu);
		}
		long end = System.currentTimeMillis();
		logger.debug("处理菜单用时"+(end-now));
		return menuList;
	}

	public List<Menu> getParentMenus() {
		return menuDao.getMenuList();
	}

	public List<Menu> getChildrenMenus(String id) {
		return menuDao.getMenuListByParentId(id);
	}
}
