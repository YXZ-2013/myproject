package com.myproject.mybatis.user;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.myproject.model.User;

public class UserDaoTest {
	@Test
	public void findUserById(){
		String resource = "/mybatis-config.xml";
		InputStream is = UserDaoTest.class.getResourceAsStream(resource);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
//		String statement = "com.myproject.easyui.user.dao.userMapper.getUser";
//		User user = session.selectOne(statement,2);
//		System.out.println(user);
	}
}
