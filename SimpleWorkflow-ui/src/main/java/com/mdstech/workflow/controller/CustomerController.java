package com.mdstech.workflow.controller;

import static com.mdstech.workflow.controller.util.ConvertToJsonFormat.jsonDataErrorFormData;
import static com.mdstech.workflow.controller.util.ConvertToJsonFormat.jsonDataFromList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Map<String, ? extends Object> saveCustomer(
			@Valid @ModelAttribute("customer") final CustomerDto customer,
			final BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return jsonDataErrorFormData(bindingResult.getFieldErrors());
		}
		final CustomerDto customerDto = customerService.create(customer);
		final Map<String, Object> valueMap = new HashMap<String, Object>();
		valueMap.put("success", true);
		valueMap.put("customer", customerDto);
		return valueMap;
	}
}
