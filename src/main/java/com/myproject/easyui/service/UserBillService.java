package com.myproject.easyui.service;

import java.util.List;

import com.myproject.model.UserBill;

public interface UserBillService {
	
	/**
	 * 交易记录
	 * @author Zhangdong
	 * @time 2015年5月19日下午12:05:05
	 * @return
	 */
	public List<UserBill> getAll();
}
