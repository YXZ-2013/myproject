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
		User user = userDao.getUser("admin");;
		System.out.println(user);
	}
}
