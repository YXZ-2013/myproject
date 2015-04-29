/**
 * @author yxz
 * @creatTime 2015年4月29日上午11:15:10
 * @version 1.0
 * @description 
 */
package com.myproject.model;

/**
 * @author yinxunzhi
 * @creatTime 2015年4月29日上午11:15:10
 * @version 1.0
 * @description 响应时返回的json数据
 */
public class ResponseJson {
	private boolean success = false;// 是否成功
	private String msg = "";// 提示信息
	private Object obj = null;// 其他信息

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
