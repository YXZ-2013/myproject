package com.myproject.easyui.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.model.UserRole;

@Repository(value = "userRoleDao")
public interface UserRoleDao {
	
	public void addUserRole(UserRole userRole);
	
	public List<UserRole> getRoleId(String userId);
	
	public void deleteUserRole(UserRole userRole);
}

