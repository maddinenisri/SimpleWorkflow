package com.mdstech.workflow.service;

import java.util.Collection;

import com.mdstech.workflow.dto.AbstractDto;

public interface AbstractService<ID, T extends AbstractDto<ID>> {
	T create(final T t);

	T update(final T t);

	T findOne(final ID id);

	void remove(final ID id);

	Collection<T> findAll();
}
