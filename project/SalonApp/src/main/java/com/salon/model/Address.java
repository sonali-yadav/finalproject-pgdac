package com.salon.model;

import javax.persistence.*;

@Entity
@Table(name = "address_master")
public class Address extends AbstractEntity {

	// data members
	private int defaultFlag;
	private String address, city, state, pincode;
	private Customer customer;

	// default ctor
	public Address() {
		super();
		customer = new Customer();
		System.out.println("Address default ctor called.");
	}

	public Address(int defaultFlag, String address, String city, String state, String pincode) {
		super();
		this.defaultFlag = defaultFlag;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	// getters and setters
	@Column(name = "default_flag")
	public int getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(int defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	@Column
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@ManyToOne
	@JoinColumn(name = "customer_master_pk")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [defaultFlag=" + defaultFlag + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", customer=" + customer + ", pk="+this.getPk()+"]";
	}
}
