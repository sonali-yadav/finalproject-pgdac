package com.salon.model;

import javax.persistence.*;

@Entity
@Table(name = "salon_master")
public class Salon extends AbstractEntity {

	// data members
	private String salonName, address, contact1, contact2, description, latitude, longitude;
	private Type type;
	private int homeServiceFlag, currentRating, activeDeactive;
	

	// default constructor
	public Salon() {
		super();
		System.out.println("Salon default constructor called.");
	}

	// getters and setters

	@Column(length = 30, nullable = false)
	public String getSalonName() {
		return salonName;
	}

	public void setSalonName(String salonName) {
		this.salonName = salonName;
	}

	@Column
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 15, unique = true)
	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	@Column(length = 15)
	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Enumerated(EnumType.ORDINAL)
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column
	public int getHomeServiceFlag() {
		return homeServiceFlag;
	}

	public void setHomeServiceFlag(int homeServiceFlag) {
		this.homeServiceFlag = homeServiceFlag;
	}

	@Column
	public int getCurrentRating() {
		return currentRating;
	}

	public void setCurrentRating(int currentRating) {
		this.currentRating = currentRating;
	}

	@Column
	public int getActiveDeactive() {
		return activeDeactive;
	}

	public void setActiveDeactive(int activeDeactive) {
		this.activeDeactive = activeDeactive;
	}


	@Override
	public String toString() {
		return "Salon [salonName=" + salonName + ", address=" + address + ", contact1=" + contact1 + ", contact2="
				+ contact2 + ", description=" + description + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", type=" + type + ", homeServiceFlag=" + homeServiceFlag + ", currentRating=" + currentRating
				+ ", activeDeactive=" + activeDeactive + "]";
	}
}
