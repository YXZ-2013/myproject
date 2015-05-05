package com.myproject.mybatis.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.easyui.dao.UserDao;
import com.myproject.model.User;

/**
 * @author yinxunzhi
 * @creatTime 2015年5月4日下午4:39:51
 * @version 1.0
 * @description 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class UserDaoSpringJunitTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void findUserById() {
		User user = new User();
		user.setUsername("admin");
		user.setPassword("4be30d9814c6d4e9800e0d2ea9ec9fb00efa887b");
		user = userDao.getUser(user);;
		System.out.println(user.toString());
	}
}
