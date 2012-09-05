package com.mdstech.workflow.repository.customer;

import org.springframework.stereotype.Repository;

import com.mdstech.workflow.domain.customer.Customer;
import com.mdstech.workflow.repository.AbstractRepository;

@Repository
public interface CustomerRepository extends AbstractRepository<Long, Customer> {

}
