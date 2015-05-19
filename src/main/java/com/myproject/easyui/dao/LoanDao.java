package com.myproject.easyui.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.model.Loan;

@Repository(value = "loanDao")
public interface LoanDao {
	public List<Loan> getAll();
	
}
