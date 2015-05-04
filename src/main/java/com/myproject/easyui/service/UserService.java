package com.myproject.easyui.service;

import java.util.List;

import com.myproject.model.Permission;
import com.myproject.model.User;

public interface UserService {

	/**
	 * 获取用户权限
	 * 
	 * @author yinxunzhi
	 * @time 2015年4月30日下午2:50:45
	 * @param user
	 * @return
	 */
	List<Permission> getPermissions(User user);

	/**
	 * 动态获取用户
	 * 
	 * @author yinxunzhi
	 * @time 2015年4月30日下午2:46:56
	 * @param user
	 */
	public User getUser(User user);

}
