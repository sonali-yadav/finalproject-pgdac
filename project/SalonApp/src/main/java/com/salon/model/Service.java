package com.salon.model;

import javax.persistence.*;

@Entity
@Table(name = "service_master")
public class Service extends AbstractEntity {
	private String serviceName,imagePath;
	private Type type;
	
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

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Service [serviceName=" + serviceName + ", imagePath=" + imagePath + ", type=" + type + "]";
	}
}
