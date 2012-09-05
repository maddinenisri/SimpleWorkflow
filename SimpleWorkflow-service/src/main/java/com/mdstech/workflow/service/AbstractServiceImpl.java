package com.mdstech.workflow.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mdstech.workflow.domain.AbstractEntity;
import com.mdstech.workflow.dto.AbstractDto;
import com.mdstech.workflow.repository.AbstractRepository;

public abstract class AbstractServiceImpl<ID extends Serializable, T extends AbstractDto<ID>, E extends AbstractEntity<ID>>
		implements AbstractService<ID, T> {

	public abstract AbstractRepository<ID, E> getRepository();

	public abstract E convertDtoToEntity(T t);

	public abstract T convertEntityToDto(E e);

	public T create(final T t) {
		final E e = convertDtoToEntity(t);
		getRepository().save(e);
		t.setIdProperty(e.getId());
		return t;
	}

	public T update(final T t) {
		final E e = convertDtoToEntity(t);
		final E e1 = getRepository().findOne(t.getIdProperty());
		e.setCreatedDate(e1.getCreatedDate());
		getRepository().save(e);
		t.setIdProperty(e.getId());
		return t;
	}

	public T findOne(final ID id) {
		final E e = getRepository().findOne(id);
		if (e == null) {
			return null;
		}
		return convertEntityToDto(e);
	}

	public void remove(final ID id) {
		getRepository().delete(id);
	}

	public Collection<T> findAll() {
		final Collection<T> dtos = new ArrayList<T>();
		final List<E> entities = getRepository().findAll();
		if (entities != null && entities.size() > 0) {
			for (final E entity : entities) {
				dtos.add(convertEntityToDto(entity));
			}
		}
		return dtos;
	}
}
