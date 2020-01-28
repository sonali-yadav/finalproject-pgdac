package com.salon.model;

import javax.persistence.*;

@Entity
@Table(name = "service_master")
public class Service extends AbstractEntity {
	private String serviceName,imagePath, description;
	private int categoryMasterPk;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryMasterPk() {
		return categoryMasterPk;
	}

	public void setCategoryMasterPk(int categoryMasterPk) {
		this.categoryMasterPk = categoryMasterPk;
	}

	public Service() {
		super();
		System.out.println("Service default ctor called.");
	}

	@Column(name = "service_name",nullable = false)
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column(name = "image_path")
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Service [serviceName=" + serviceName + ", imagePath=" + imagePath + "]";
	}
}
