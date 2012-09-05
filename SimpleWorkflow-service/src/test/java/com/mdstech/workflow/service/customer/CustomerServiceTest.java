package com.mdstech.workflow.service.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdstech.workflow.dto.customer.CustomerDto;
import com.mdstech.workflow.service.SpringTestCaseHelper;
import com.mdstech.workflow.type.GenderType;
import com.mdstech.workflow.type.MaritalStatusType;
import com.mdstech.workflow.type.SalutationType;

public class CustomerServiceTest extends SpringTestCaseHelper {

	private static final Logger _logger = LoggerFactory
			.getLogger(CustomerServiceTest.class);

	@Inject
	@Named(CustomerService.QUALIFIER)
	private CustomerService customerService;

	@Test
	public void testCreateCustomer() {
		_logger.debug("Executing createCustomer test case");
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName("testFname");
		customerDto.setLastName("testLname");
		customerDto.setMiddleName("testMname");
		customerDto.setBirthDate(new Date());
		customerDto.setEmail("test@test.com");
		customerDto.setGenderType(GenderType.M);
		customerDto.setMaritalStatusType(MaritalStatusType.MARRIED);
		customerDto.setOccupation("IT Consultant");
		customerDto.setOrgName("Test");
		customerDto.setSalutationType(SalutationType.Mr);
		customerDto = customerService.create(customerDto);
		assertEquals(customerDto.getFirstName(), "testFname");
		assertNotNull(customerDto.getIdProperty());

		customerDto.setFirstName("Srini");
		customerDto = customerService.update(customerDto);
		assertEquals(customerDto.getFirstName(), "Srini");

		final CustomerDto cDto = customerService.findOne(1L);
		assertNotNull(cDto);
		assertEquals(cDto.getFirstName(), "Srini");

		final Collection<CustomerDto> dtos = customerService.findAll();
		assertNotNull(dtos);
		assertEquals(dtos.size(), 1);

		final Collection<CustomerDto> dtos1 = customerService
				.findByName("Srini");
		assertNotNull(dtos1);
		assertEquals(dtos1.size(), 1);

		customerService.remove(1L);
		final CustomerDto cDto1 = customerService.findOne(1L);
		assertNull(cDto1);

	}
}
