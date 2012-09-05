package com.mdstech.workflow.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.mdstech.workflow.domain.AbstractEntity;

@Repository
public interface AbstractRepository<ID extends Serializable, T extends AbstractEntity<ID>>
		extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

}
