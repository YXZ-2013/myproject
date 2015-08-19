package com.myproject.easyui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.easyui.dao.RoleDao;
import com.myproject.easyui.dao.RoleMenuDao;
import com.myproject.easyui.service.RoleService;
import com.myproject.model.EasyTreeNode;
import com.myproject.model.Role;
import com.myproject.model.RoleMenu;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	public List<Role> getAll() {
		List<Role> roleList = roleDao.getAll();
		return roleList;
	}

	public Role getRole(Role role) {
		role= roleDao.getRole(role);
		RoleMenu roleMenu = new RoleMenu();
		roleMenu.setRoleId(role.getId().toString());
		List<RoleMenu> menus = roleMenuDao.getMenuId(roleMenu.getRoleId());
		StringBuffer menuIds= new StringBuffer();
		if (menus!=null&&menus.size()>0) {
			for(int i=0;i<menus.size();i++){
				if (i!=menus.size()-1) {
					menuIds.append(menus.get(i).getMenuId()).append(",");
				}else {
					menuIds.append(menus.get(i).getMenuId());
				}
			}
		}
		role.setMenuIds(menuIds.toString());
		return role;
	}

	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	public void updateRole(Role role) {
		roleDao.updateRole(role);
		List<RoleMenu> roleMenus = roleMenuDao.getMenuId(role.getId().toString());
		RoleMenu roleMenu2 = new RoleMenu();
		roleMenu2.setRoleId(role.getId().toString());
		String menuIds = role.getMenuIds();
		if (roleMenus.size()>0) {
			roleMenuDao.deleteRoleMenu(roleMenu2);
			if (menuIds!=null&&""!=menuIds) {
				for (RoleMenu roleMenu : roleMenus) {
					roleMenu.setRoleId(role.getId().toString());
						String[] menuids = menuIds.split(",");
						for (String menuId : menuids) {
							roleMenu.setMenuId(menuId);
							roleMenuDao.addRoleMenu(roleMenu);
						}
				}
			}
		}else {
			if (menuIds!=null&&""!=menuIds) {
				String[] menuids = menuIds.split(",");
				for (String menuId : menuids) {
					roleMenu2.setMenuId(menuId);
					roleMenuDao.addRoleMenu(roleMenu2);
				}
			}
		}
		
	}

	public void deleteRole(String id) {
		roleDao.deleteRole(id);
	}

	public void addRoleMenu(Role role) {
		RoleMenu roleMenu = new RoleMenu();
		String menus = role.getMenuIds();
		if (menus!=null&&""!=menus) {
			String[] menuList = menus.split(",");
			for (int i = 0; i < menuList.length; i++) {
				roleMenu.setRoleId(role.getId().toString());
				roleMenu.setMenuId(menuList[i]);
				roleMenuDao.addRoleMenu(roleMenu);
			}
		}
	}

	public List<EasyTreeNode> getRoleTree(Role role, boolean flag) {
		List<EasyTreeNode> tree = new ArrayList<EasyTreeNode>(0);
		List<Role> rolelList = roleDao.getAll();
		for (Role role2 : rolelList) {
			tree.add(tree(role2, flag));
		}
		return tree;
	}

	private EasyTreeNode tree(Role role,boolean flag){
		EasyTreeNode node= new EasyTreeNode();
		node.setId(role.getId().toString());
		node.setText(role.getName());
		return node;
	}
}
