package com.myproject.easyui.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.model.UserRole;

@Repository(value = "userRoleDao")
public interface UserRoleDao {
	
	public void addRoleMenu(UserRole userRole);
	
	public List<UserRole> getMenuId(String userId);
	
	public void deleteRoleMenu(UserRole userRole);
}

