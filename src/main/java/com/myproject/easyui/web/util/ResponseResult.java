package com.myproject.easyui.web.util;

public class ResponseResult {
	private int total;
	private Object rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "ResponseResult [total=" + total + ", rows=" + rows + "]";
	}
}
