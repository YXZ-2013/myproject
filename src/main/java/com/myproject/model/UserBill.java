package com.myproject.model;

import java.util.Date;

public class UserBill {
	
	private String id;
	
	private Long seqNum;
	
	private String userId;
	
	private Date time;
	
	private String type;
	
	private String typeInfo;
	
	private Double money;
	
	private String detail;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(Long seqNum) {
		this.seqNum = seqNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeInfo() {
		return typeInfo;
	}
	public void setTypeInfo(String typeInfo) {
		this.typeInfo = typeInfo;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
