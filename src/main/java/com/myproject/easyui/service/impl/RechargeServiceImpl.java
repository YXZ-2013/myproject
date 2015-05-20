package com.myproject.easyui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.RechargeDao;
import com.myproject.easyui.service.RechargeService;
import com.myproject.model.Recharge;

@Service(value = "rechargeService")
public class RechargeServiceImpl implements RechargeService {
	@Autowired
	private RechargeDao rechargeDao;
	
	public List<Recharge> getAll() {
		
		List<Recharge> rechargeList = rechargeDao.getAll();
		return rechargeList;
	}

}
