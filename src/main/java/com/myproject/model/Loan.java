package com.myproject.model;

import java.util.Date;


public class Loan {
	private String id;
	
	private String name;// 借款名称
	
	private Double money;// 金额
	
	private String status;// 状态
	
	private String userId;
	
	private Date commitTime;// 项目发起时间
	
	public Date getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
