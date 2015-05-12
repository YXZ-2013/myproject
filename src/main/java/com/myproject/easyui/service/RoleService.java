package com.myproject.easyui.service;

import java.util.List;

import com.myproject.model.Role;

public interface RoleService {
	
	/**
	 * 获取角色列表
	 * @author yinxunzhi
	 * @time 2015年5月12日下午12:05:05
	 * @return
	 */
	public List<Role> getAll();
}
