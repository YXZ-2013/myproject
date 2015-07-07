/**
 * @author yxz
 * @creatTime 2015年4月20日上午11:46:08
 * @version 1.0
 * @description 
 */
package com.myproject.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author yinxunzhi
 * @creatTime 2015年4月20日上午11:46:08
 * @version 1.0
 * @description
 */
public class Menu{
	private String id;
	private boolean state = true;// 是否可用
	private String parentId;
	private String type;
	private String name;
	private String url;
	private Integer seqNum;
	private String description;
	private List<Menu> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
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

	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);

	}
}
