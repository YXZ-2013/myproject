package com.myproject.model;

import java.util.Date;

public class Withdraw {

	private String id;
	
	private String userId;

	private Date time;

	private Double fee;
	
	private String bankCard;
	
	private Double actualMoney;

	private String status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public Double getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(Double actualMoney) {
		this.actualMoney = actualMoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
