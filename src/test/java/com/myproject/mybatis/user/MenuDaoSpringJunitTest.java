package com.myproject.mybatis.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.easyui.dao.MenuDao;
import com.myproject.model.Menu;

/**
 * @author yinxunzhi
 * @creatTime 2015年5月4日下午4:39:51
 * @version 1.0
 * @description 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MenuDaoSpringJunitTest {
	@Autowired
	private MenuDao menuDao;
	
	@Test
	public void getManagerMenuList() {
		List<Menu> menus = menuDao.getMenuListByType("Management");
		for (Menu menu2 : menus) {
			List<Menu> children = menuDao.getMenuListByParentId(menu2.getId());
			System.out.println(children.size());
		}
	}
}
