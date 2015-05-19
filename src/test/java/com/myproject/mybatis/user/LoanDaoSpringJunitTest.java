package com.myproject.mybatis.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.easyui.dao.LoanDao;
import com.myproject.model.Loan;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class LoanDaoSpringJunitTest {
	@Autowired
	private LoanDao loanDao;

	@Test
	public void getAll() {
		try {
			List<Loan> loanList = loanDao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
