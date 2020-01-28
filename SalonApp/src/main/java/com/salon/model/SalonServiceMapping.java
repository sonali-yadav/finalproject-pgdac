package com.salon.model;

import javax.persistence.*;

@Entity
@Table(name="salon_service_mapping")
public class SalonServiceMapping extends AbstractEntity {
	
	//data members
	private int salonMasterPk, serviceMasterPk, serviceCost, homeServiceFlag, activeDeactive, categoryMasterPk;

	public int getSalonMasterPk() {
		return salonMasterPk;
	}

	public void setSalonMasterPk(int salonMasterPk) {
		this.salonMasterPk = salonMasterPk;
	}

	public int getServiceMasterPk() {
		return serviceMasterPk;
	}

	public void setServiceMasterPk(int serviceMasterPk) {
		this.serviceMasterPk = serviceMasterPk;
	}

	public int getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
	}

	public int getHomeServiceFlag() {
		return homeServiceFlag;
	}

	public void setHomeServiceFlag(int homeServiceFlag) {
		this.homeServiceFlag = homeServiceFlag;
	}

	public int getActiveDeactive() {
		return activeDeactive;
	}

	public void setActiveDeactive(int activeDeactive) {
		this.activeDeactive = activeDeactive;
	}

	public int getCategoryMasterPk() {
		return categoryMasterPk;
	}

	public void setCategoryMasterPk(int categoryMasterPk) {
		this.categoryMasterPk = categoryMasterPk;
	}
	

	
}
