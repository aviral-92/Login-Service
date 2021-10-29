package com.login.modal;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "created_date", insertable = true, updatable = false)
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "is_active")
	private boolean isActive;

	@PrePersist
	public void onItemsCreation() {
		this.createdDate = new Timestamp(System.currentTimeMillis());
		this.updatedDate = new Timestamp(System.currentTimeMillis());
		this.isActive = true;
	}

	@PreUpdate
	public void onPersist() {
		this.updatedDate = new Timestamp(System.currentTimeMillis());
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Login [createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", isActive=" + isActive + "]";
	}

}
