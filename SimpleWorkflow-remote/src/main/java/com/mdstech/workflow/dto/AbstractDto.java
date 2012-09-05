package com.mdstech.workflow.dto;

import java.io.Serializable;

public class AbstractDto<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5904613963675150982L;
	private T idProperty;

	public T getIdProperty() {
		return idProperty;
	}

	public void setIdProperty(final T idProperty) {
		this.idProperty = idProperty;
	}
}
