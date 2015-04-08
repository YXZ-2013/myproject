package com.myproject.easyui.web.util;

public class ResponseResult {
	private Long total;
	private Object rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
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
