package com.myproject.easyui.service;

import java.util.List;

import com.myproject.model.Recharge;

public interface RechargeService {
	
	/**
	 * 获取充值列表
	 * @author Zhangdong
	 * @time 2015年5月19日下午12:05:05
	 * @return
	 */
	public List<Recharge> getAll();
}
