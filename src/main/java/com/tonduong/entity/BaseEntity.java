package com.tonduong.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass /// để kế thừa nó tạo entity
@EntityListeners(AuditingEntityListener.class) //Lắng nghe ???
public class BaseEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "createddate")
	@CreatedDate
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date createddate;

	@Column(name = "modifieddate")
	@CreatedDate
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date modifieddate;

	@Column(name = "createdby")
	@CreatedBy
	protected String createdby;

	@Column(name = "modifiedby")
	@LastModifiedBy
	protected String modifiedby;

	public Long getId() {
		return id;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
}
