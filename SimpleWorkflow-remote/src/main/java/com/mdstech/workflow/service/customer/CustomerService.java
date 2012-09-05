package com.mdstech.workflow.service.customer;

import java.util.Collection;

import com.mdstech.workflow.dto.customer.CustomerDto;
import com.mdstech.workflow.service.AbstractService;

public interface CustomerService extends AbstractService<Long, CustomerDto> {
	static final String QUALIFIER = "customerService";

	Collection<CustomerDto> findByName(String searchTerm);
}
