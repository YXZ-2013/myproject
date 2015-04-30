package com.myproject.easyui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.UserDao;
import com.myproject.easyui.service.UserService;
import com.myproject.model.Permission;
import com.myproject.model.User;

/**
 * @author yinxunzhi
 * @creatTime 2015年4月29日上午11:18:20
 * @version 1.0
 * @description
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public List<Permission> getPermissions(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String id) {
		return userDao.getUser(id);
	}

}
