package com.mdstech.workflow.service.customer;

import static com.mdstech.workflow.service.specifications.SearchSpecifications.firstNameOrlastNameIsLike;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mdstech.workflow.domain.customer.Customer;
import com.mdstech.workflow.dto.customer.CustomerDto;
import com.mdstech.workflow.repository.AbstractRepository;
import com.mdstech.workflow.repository.customer.CustomerRepository;
import com.mdstech.workflow.service.AbstractServiceImpl;

@Service(CustomerService.QUALIFIER)
public class CustomerServiceImpl extends
		AbstractServiceImpl<Long, CustomerDto, Customer> implements
		CustomerService {

	@Inject
	private CustomerRepository customerRepository;

	@Override
	public AbstractRepository<Long, Customer> getRepository() {
		return customerRepository;
	}

	@Override
	public Customer convertDtoToEntity(final CustomerDto customerDto) {
		final Customer customer = new Customer();
		customer.setId(customerDto.getIdProperty());
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setMiddleName(customerDto.getMiddleName());
		customer.setEmail(customerDto.getEmail());
		customer.setBirthDate(customerDto.getBirthDate());
		customer.setGenderType(customerDto.getGenderType());
		customer.setMaritalStatusType(customerDto.getMaritalStatusType());
		customer.setOccupation(customerDto.getOccupation());
		customer.setOrgName(customerDto.getOrgName());
		customer.setSalutationType(customerDto.getSalutationType());
		return customer;
	}

	@Override
	public CustomerDto convertEntityToDto(final Customer customer) {
		final CustomerDto dto = new CustomerDto();
		dto.setIdProperty(customer.getId());
		dto.setFirstName(customer.getFirstName());
		dto.setLastName(customer.getLastName());
		dto.setMiddleName(customer.getMiddleName());
		dto.setEmail(customer.getEmail());
		dto.setBirthDate(customer.getBirthDate());
		dto.setGenderType(customer.getGenderType());
		dto.setMaritalStatusType(customer.getMaritalStatusType());
		dto.setOccupation(customer.getOccupation());
		dto.setOrgName(customer.getOrgName());
		dto.setSalutationType(customer.getSalutationType());
		return dto;
	}

	public Collection<CustomerDto> findByName(final String searchTerm) {
		final Collection<CustomerDto> dtos = new ArrayList<CustomerDto>();
		final List<Customer> entities = customerRepository
				.findAll(firstNameOrlastNameIsLike(searchTerm));
		if (entities != null && entities.size() > 0) {
			for (final Customer entity : entities) {
				dtos.add(convertEntityToDto(entity));
			}
		}
		return dtos;
	}

}
