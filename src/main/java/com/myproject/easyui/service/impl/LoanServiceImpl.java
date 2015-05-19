package com.myproject.easyui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.LoanDao;
import com.myproject.easyui.service.LoanService;
import com.myproject.model.Loan;

@Service(value = "loanService")
public class LoanServiceImpl implements LoanService {
	@Autowired
	private LoanDao loanDao;
	
	public List<Loan> getAll() {
		List<Loan> loanList = loanDao.getAll();
		return loanList;
	}

}
