package com.myproject.easyui.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.model.RoleMenu;

@Repository(value = "roleMenuDao")
public interface RoleMenuDao {
	
	public void addRoleMenu(RoleMenu roleMenu);
	
	public List<RoleMenu> getMenuId(String roleId);
	
	public void deleteRoleMenu(RoleMenu roleMenu);
}

