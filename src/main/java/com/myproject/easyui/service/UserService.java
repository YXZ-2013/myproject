package com.myproject.easyui.service;

import java.util.List;

import com.myproject.model.Permission;
import com.myproject.model.User;

/**
 * @author yinxunzhi
 * @creatTime 2015年4月29日上午11:17:47
 * @version 1.0
 * @description 
 */
public interface UserService {

	/**
	 * 获取用户的权限列表
	 * @author yinxunzhi
	 * @time 2015年4月29日下午4:34:11
	 * @param user
	 * @return
	 */
	List<Permission> getPermissions(User user);
	
	/**
	 * 根据用户id获取用户
	 * @author yinxunzhi
	 * @time 2015年4月30日上午10:53:02
	 * @param id
	 * @return
	 */
	public User getUser(String id);
	
}
