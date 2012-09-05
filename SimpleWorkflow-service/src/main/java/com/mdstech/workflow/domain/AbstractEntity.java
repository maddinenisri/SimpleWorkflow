package com.mdstech.workflow.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractEntity<T> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private T id;

	@Column(name = "DT_CREATED", nullable = false)
	private Date createdDate;

	@Column(name = "DT_LST_UPDT", nullable = false)
	private Date lastUpdatedDate;

	@PreUpdate
	public void preUpdate() {
		lastUpdatedDate = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date now = new Date();
		lastUpdatedDate = now;
		createdDate = now;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(final Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public T getId() {
		return id;
	}

	public void setId(final T id) {
		this.id = id;
	}
}
