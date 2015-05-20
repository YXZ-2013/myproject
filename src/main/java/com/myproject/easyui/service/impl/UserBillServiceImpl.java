package com.myproject.easyui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.UserBillDao;
import com.myproject.easyui.service.UserBillService;
import com.myproject.model.UserBill;

@Service(value = "userBillService")
public class UserBillServiceImpl implements UserBillService {

	@Autowired
	UserBillDao userBillDao;
	public List<UserBill> getAll() {
		List<UserBill> userBillList= userBillDao.getAll();
		return userBillList;
	}


}
