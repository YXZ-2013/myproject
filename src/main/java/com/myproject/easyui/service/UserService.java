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

	/**
	 * 获取用户可以访问的资源列表
	 * @author yinxunzhi
	 * @time 2015年5月11日下午3:01:21
	 * @param id
	 * @return
	 */
	List<String> getResourceList(String id);

	/**
	 * 动态获取用户
	 * 
	 * @author zhangdong
	 * @time 
	 * 
	 */
	public List<User> getUserList();
	
	/**
	 * 添加用户
	 */
	public void addUser(User user);
	
	/**
	 * 修改用户
	 */
	public void updateUser(User user);
	/**
	 * 删除用户
	 * 
	 */
	public void deltetUser(String id);
}
