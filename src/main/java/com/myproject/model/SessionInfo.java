package com.myproject.model;

import java.util.List;

/**
 * 登陆后session集合
 * 
 * @author 尹逊志
 * @time 2015年4月20日下午11:22:30
 * 
 */
public class SessionInfo {
	private String userId;// 用户ID
	private String ip;// IP地址
	private List<Menu> menuList;// 用户可以访问的资源地址列表

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}


}
