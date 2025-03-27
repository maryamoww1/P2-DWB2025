package com.customer.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "region")
public class Category {	
	
	@Id
	@JsonProperty("category_id")
	@Column(name = "category_id")
	private Integer category_id;
	
	@JsonProperty("category")
	@Column(name = "category")
	private String category;

	@JsonProperty("tag")
	@Column(name = "tag")
	private String tag;

	@JsonProperty("status")
	@Column(name = "status")
	private Integer status;

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
