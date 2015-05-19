package com.myproject.easyui.service;

import java.util.List;

import com.myproject.model.Loan;

public interface LoanService {
	
	/**
	 * 获取项目列表
	 * @author yinxunzhi
	 * @time 2015年5月12日下午12:05:05
	 * @return
	 */
	public List<Loan> getAll();
}
