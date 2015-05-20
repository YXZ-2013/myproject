package com.myproject.easyui.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.myproject.model.UserBill;


@Repository(value = "userBillDao")
public interface UserBillDao {
	
	public List<UserBill> getAll();
	
}
