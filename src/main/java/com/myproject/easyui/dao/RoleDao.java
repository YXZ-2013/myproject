package com.myproject.easyui.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myproject.model.Role;

@Repository(value = "roleDao")
public interface RoleDao {
	public List<Role> getAll();
	
	public List<Role> getRolesByUserId(String userId);
	
	public Role getRole(Role role);
	
	public void addRole(Role role);
	
	public void updateRole(Role role);
	
	public void deleteRole(String id);
}

