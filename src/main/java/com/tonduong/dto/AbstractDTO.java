package com.tonduong.dto;

import java.sql.Timestamp;

public class AbstractDTO<T> {
	protected Long id;
	protected Timestamp createddate;
	protected Timestamp modifieddate;
	protected String createdby;
	protected String modifiedby;

	public AbstractDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return createddate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createddate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifieddate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifieddate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdby;
	}

	public void setCreatedBy(String createdBy) {
		this.createdby = createdBy;
	}

	public String getModifiedBy() {
		return modifiedby;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedby = modifiedBy;
	}
}
