package com.myproject.easyui.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuDao menuDao;
	
	/**
	 * 后台管理的菜单树
	 * @author yinxunzhi
	 * @time 2015年5月7日下午3:12:36
	 * @param menu
	 * @param flag
	 * @return
	 */
	public List<EasyTreeNode> getMenuTree(Menu menu ,boolean flag){
		List<EasyTreeNode> tree = new ArrayList<EasyTreeNode>(0);
		List<Menu> parent = menuDao.getMenuListByType("Management");
		for (Menu m : parent) {
			List<Menu> children = menuDao.getMenuListByParentId(m.getId());
			m.setChildren(children);
			tree.add(tree(m, flag));
		}
		return tree;
	}
	
	private EasyTreeNode tree(Menu menu,boolean flag){
		EasyTreeNode node = new EasyTreeNode();
		node.setId(menu.getId());
		node.setText(menu.getName());
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("url", menu.getUrl());
		node.setAttributes(attributes);
		if(menu.getChildren() != null && menu.getChildren().size() > 0){
			node.setState("closed");
			if(flag){
				List<EasyTreeNode> children = new ArrayList<EasyTreeNode>();
				for(Menu m:menu.getChildren()){
					tree(m, flag);
					children.add(tree(m, true));
				}
				node.setChildren(children);
			}
		}
		return node;
	}
}
