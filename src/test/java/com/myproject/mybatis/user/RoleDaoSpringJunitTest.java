package com.myproject.mybatis.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myproject.easyui.dao.RoleDao;
import com.myproject.model.Role;
import com.myproject.model.User;

/**
 * @author yinxunzhi
 * @creatTime 2015年5月4日下午4:39:51
 * @version 1.0
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RoleDaoSpringJunitTest {
	@Autowired
	private RoleDao roleDao;

	@Test
	public void getAll() {
		PageHelper.startPage(1,5,false);
		List<Role> roleList = roleDao.getAll();
		PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
		System.out.println(pageInfo.toString());
	}
	
	@Test
	public void getRolesByUserId() {
		List<Role> roleList = roleDao.getRolesByUserId("admin");
		System.out.println(roleList.size());
	}
}
