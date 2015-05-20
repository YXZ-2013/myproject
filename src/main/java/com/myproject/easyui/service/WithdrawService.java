package com.myproject.easyui.service;

import java.util.List;

import com.myproject.model.Withdraw;

public interface WithdrawService {
	
	/**
	 * 获取提现列表
	 * @author Zhangdong
	 * @time 2015年5月12日下午12:05:05
	 * @return
	 */
	public List<Withdraw> getAll();
}
