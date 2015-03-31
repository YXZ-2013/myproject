package com.myproject.mybatis.user;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.myproject.model.User;

public class UserDaoTest {
	@Test
	public void findUserById() {
		String resource = "/mybatis-config-test.xml";
		InputStream is = UserDaoTest.class.getResourceAsStream(resource);

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();

		String statement = "com.myproject.mybatis.user.userMapper.getUser";
		User user = session.selectOne(statement, "admin");
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void findAll() {
		String resource = "/mybatis-config-test.xml";
		InputStream is = UserDaoTest.class.getResourceAsStream(resource);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		String statement = "com.myproject.mybatis.user.userMapper.getAll";
		List<User> userList = session.selectList(statement);
		for (User user : userList) {
			System.out.println(user);
		}
		session.commit();
		session.close();
	}
	
	@Test
	public void saveUser() {
		String resource = "/mybatis-config-test.xml";
		InputStream is = UserDaoTest.class.getResourceAsStream(resource);
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		User user = new User();
		user.setId(UUID.randomUUID().toString().substring(0, 32));
		user.setUsername("ddd");
		user.setEmail("1111");
		user.setPassword("111");
		String statement = "com.myproject.mybatis.user.userMapper.saveUser";
		session.insert(statement, user);
		session.close();
	}
}
