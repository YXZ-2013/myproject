package com.myproject.easyui.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.model.Recharge;


@Repository(value = "rechargeDao")
public interface RechargeDao {
	
	public List<Recharge> getAll();
	
}
