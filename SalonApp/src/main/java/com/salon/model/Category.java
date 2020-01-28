package com.salon.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="category_master")
public class Category {
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
