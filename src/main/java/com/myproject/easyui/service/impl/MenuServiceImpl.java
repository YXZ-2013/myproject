package com.myproject.easyui.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
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
		TreeSet<Menu> treeSet = new TreeSet<Menu>();
		List<Menu> menuList = menuDao.getMenuListByType("Management");
		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i).getParentId() == null) {
				treeSet.add(menuList.get(i));
				List<Menu> childList = new ArrayList<Menu>();
				for (int j = 0; j < menuList.size(); j++) {
					String parentId = menuList.get(i).getParentId();
					if (parentId.equals(menuList.get(j).getParentId())) {
						childList.add(menuList.get(j));
					}
				}
				menuList.get(i).setChildren(childList);
			}
		}
		// for (Menu m : parent) {
		// List<Menu> children = menuDao.getMenuListByParentId(m.getId());
		// m.setChildren(children);
		// tree.add(tree(m, flag));
		// }
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

		return menuDao.getMenuById(id);
	}

	public void updateMenu(Menu menu) {
		menuDao.updateMenu(menu.getId());
	}

	public void addMenu(Menu menu) {
		menuDao.addMenu(menu);
	}

	public List<EasyTreeNode> getAllMenus() {
		List<Menu> menuList = menuDao.getAllMenus();
		Map<String, EasyTreeNode> maps = new HashMap<String, EasyTreeNode>();
		List<EasyTreeNode> nodeList = new ArrayList<EasyTreeNode>();
		for (Menu menu : menuList) {
			EasyTreeNode node = new EasyTreeNode();
			node.setId(menu.getId());
			node.setText(menu.getName());
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("url", menu.getUrl());
			node.setAttributes(attributes);
			if(StringUtils.isEmpty(menu.getParentId())){
				maps.put(menu.getId(), node);
			}else{
				EasyTreeNode parentNode = maps.get(menu.getParentId());
				if(parentNode == null){
					maps.put(menu.getId(), node);
				}
				if(parentNode.getChildren() == null){
					List<EasyTreeNode> children = new ArrayList<EasyTreeNode>();
					parentNode.setChildren(children);
				}
				parentNode.getChildren().add(node);
			}
		}
		return nodeList;
	}
}
