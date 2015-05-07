package com.myproject.easyui.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
