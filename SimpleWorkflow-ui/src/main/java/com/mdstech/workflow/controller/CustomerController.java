package com.mdstech.workflow.controller;

import static com.mdstech.workflow.controller.util.ConvertToJsonFormat.jsonDataFromList;

import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mdstech.workflow.dto.customer.CustomerDto;
import com.mdstech.workflow.service.customer.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Inject
	@Named("customerService")
	CustomerService customerService;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Map<String, ? extends Object> findAllCustomers() {
		final Collection<CustomerDto> dtos = customerService.findAll();
		return jsonDataFromList(dtos);
	}
}
