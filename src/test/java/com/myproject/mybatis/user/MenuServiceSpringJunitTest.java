package com.myproject.mybatis.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.easyui.service.MenuService;
import com.myproject.easyui.util.JsonUtil;
import com.myproject.model.EasyTreeNode;
import com.myproject.model.Menu;



/**
 * @author yinxunzhi
 * @creatTime 2015年5月4日下午4:39:51
 * @version 1.0
 * @description 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MenuServiceSpringJunitTest{
	@Autowired
	private MenuService menuService;
	
	@Test
	public void getMenuTree() {
		List<EasyTreeNode> nodes = menuService.getMenuTree(new Menu(), true);
		System.out.println(JsonUtil.writeJson(nodes));
	}
}
