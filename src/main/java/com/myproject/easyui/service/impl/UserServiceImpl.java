package com.myproject.easyui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.UserDao;
import com.myproject.easyui.dao.UserRoleDao;
import com.myproject.easyui.service.MenuService;
import com.myproject.easyui.service.UserService;
import com.myproject.model.Permission;
import com.myproject.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private MenuService menuService;

	public List<Permission> getPermissions(User user) {
		return null;
	}

	public User getUser(User user) {
		return userDao.getUser(user);
	}

	public List<String> getResourceList(String id) {
//		List<String> resourceList = new ArrayList<String>(0);
		// List<Menu> menuList = menuService.getMenuList();
		// for (Menu menu : menuList) {
		// resourceList.add(menu.getUrl());
		// }
		return null;
	}

	public List<User> getUserList() {
		return userDao.getUserList();
	}

	public void deltetUser(String id) {
		userDao.deleteUser(id);
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}
