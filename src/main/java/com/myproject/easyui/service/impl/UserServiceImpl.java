package com.myproject.easyui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.UserDao;
import com.myproject.easyui.service.UserService;
import com.myproject.model.Permission;
import com.myproject.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	

	public List<Permission> getPermissions(User user) {
		return null;
	}

	public User getUser(User user) {
		return userDao.getUser(user);
	}

	public List<String> getResourceList(String id) {
		
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
