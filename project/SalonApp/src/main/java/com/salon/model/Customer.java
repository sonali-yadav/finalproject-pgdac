package com.salon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer_master")
public class Customer extends AbstractEntity {
	// data members
	private String firstName, lastName, email, gender, contact1, contact2="";
	private List<Address> addresses;
	public int activeDeactive=1;

	// default ctor
	public Customer() {
		super();
		addresses = new ArrayList<>();
		System.out.println("Customer default ctor called.");
	}

	public Customer(String firstName, String lastName, String email, String gender, String contact1, String contact2,
			int activeDeactive) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.activeDeactive = activeDeactive;
	}




	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(unique = true)
	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	@Column
	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public int getActiveDeactive() {
		return activeDeactive;
	}

	public void setActiveDeactive(int activeDeactive) {
		this.activeDeactive = activeDeactive;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contact1="
				+ contact1 + ", contact2=" + contact2 + ", addresses=" + addresses + ", activeDeactive="
				+ activeDeactive + "]";
	}
	
	//helper methods

	//to add  new address
	public void addAddress(Address a) {
		addresses.add(a);
		a.setCustomer(this);
	}
	
	//to remove an address
	public void removeAddress(Address a) {
		addresses.remove(a);
		a.setCustomer(null);
	}
}
