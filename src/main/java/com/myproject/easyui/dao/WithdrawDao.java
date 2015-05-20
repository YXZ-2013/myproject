package com.myproject.easyui.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.model.Withdraw;


@Repository(value = "withdrawDao")
public interface WithdrawDao {
	
	public List<Withdraw> getAll();
	
}
