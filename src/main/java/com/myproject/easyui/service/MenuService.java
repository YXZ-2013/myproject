package com.myproject.easyui.service;

import java.util.List;

import com.myproject.model.EasyTreeNode;
import com.myproject.model.Menu;

public interface MenuService {
	/**
	 * 获取后台管理菜单
	 * 
	 * @author yinxunzhi
	 * @time 2015年5月7日下午4:41:37
	 * @param menu
	 * @param flag
	 * @return
	 */
	public List<EasyTreeNode> getMenuTree(Menu menu, boolean flag);

	/**
	 * 获取菜单列表
	 * @author yinxunzhi
	 * @time 2015年5月12日下午4:11:16
	 * @param menu
	 * @param b
	 * @return
	 */
	public List<Menu> getMenuList();
	
	
	/**
	 * 删除选中菜单
	 * @param id
	 */
	public void  delMenu(String id);

	public List<Menu> getMenuList(String id);
	
	public Menu getMenuById(String id);
	
	public void updateMenu(Menu menu);

	public void addMenu(Menu menu);
}

