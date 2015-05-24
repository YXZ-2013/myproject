package com.myproject.easyui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.RoleDao;
import com.myproject.easyui.service.RoleService;
import com.myproject.model.Role;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	
	public List<Role> getAll() {
		List<Role> roleList = roleDao.getAll();
		return roleList;
	}

	public Role getRole(Role role) {
		return roleDao.getRole(role);
	}

	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	public void deleteRole(String id) {
		roleDao.deleteRole(id);
	}

}
