/**
 * @author yxz
 * @creatTime 2015年4月20日上午11:46:08
 * @version 1.0
 * @description 
 */
package com.myproject.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author yinxunzhi
 * @creatTime 2015年4月20日上午11:46:08
 * @version 1.0
 * @description 
 */
public class Menu {
	private String id;
	private String state = "open";// 是否展开(open,closed)
	private String type;
	private String name;
	private String url;
	private Long seqNum;
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(Long seqNum) {
		this.seqNum = seqNum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
		
	}	
}
