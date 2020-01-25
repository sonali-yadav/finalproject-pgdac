package com.salon.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="online_cart")
public class OnlineCart extends AbstractEntity {

	private Customer customerMasterPk;
	private SalonServiceMapping salonServiceMappingPk;
	private int quantity;
	private LocalDateTime dateAdded;
	
	public OnlineCart() {
		super();
		System.out.println("OnlineCart default ctor called.");
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_master_pk",referencedColumnName = "pk")
	public Customer getCustomerMasterPk() {
		return customerMasterPk;
	}

	public void setCustomerMasterPk(Customer customerMasterPk) {
		this.customerMasterPk = customerMasterPk;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "salon_service_mapping_pk",referencedColumnName = "pk")
	public SalonServiceMapping getSalonServiceMappingPk() {
		return salonServiceMappingPk;
	}

	public void setSalonServiceMappingPk(SalonServiceMapping salonServiceMappingPk) {
		this.salonServiceMappingPk = salonServiceMappingPk;
	}

	@Column
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@CreatedDate
	@Column
	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "OnlineCart [customerMasterPk=" + customerMasterPk + ", salonServiceMappingPk=" + salonServiceMappingPk
				+ ", quantity=" + quantity + ", dateAdded=" + dateAdded + "]";
	}
	
}
