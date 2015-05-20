package com.myproject.easyui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.WithdrawDao;
import com.myproject.easyui.service.WithdrawService;
import com.myproject.model.Withdraw;

@Service(value = "withdrawService")
public class WithdrawServiceImpl implements WithdrawService {
	@Autowired
	private WithdrawDao withdrawDao;
	
	public List<Withdraw> getAll() {
		
		List<Withdraw> withdrawList = withdrawDao.getAll();
		return withdrawList;
	}

}
