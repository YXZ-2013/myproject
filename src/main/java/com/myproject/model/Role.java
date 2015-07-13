package com.myproject.model;



/**
 *   shaql
 * @author Administrator
 *
 */
public class Role {

	private Integer id;
	
	private String name;
	
	private String description;
	
	private Boolean deleted;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
