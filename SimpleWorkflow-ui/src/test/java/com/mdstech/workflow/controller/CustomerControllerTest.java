package com.mdstech.workflow.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

public class CustomerControllerTest extends SpringTestCaseHelper {

	MockHttpServletRequest requestMock;
	MockHttpServletResponse responseMock;
	AnnotationMethodHandlerAdapter handlerAdapter;
	ObjectMapper mapper;

	@Inject
	CustomerController customerController;

	@Before
	public void setUp() {
		requestMock = new MockHttpServletRequest();
		responseMock = new MockHttpServletResponse();
		// responseMock.setOutputStreamAccessAllowed(true);
		handlerAdapter = new AnnotationMethodHandlerAdapter();
	}

	@Test
	public void testController() {
		assertNotNull("Controller can not be NULL", customerController);
	}

	@Test
	public void testFindAllCustomers() throws Exception {

		requestMock = new MockHttpServletRequest("GET", "/customer/all");
		requestMock.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING,
				true);
		requestMock.setContentType("application/json");
		requestMock.addHeader("Accept", "application/json");
		requestMock.addHeader("Content-Type", "application/json");
		// requestMock.setMethod("GET");
		// requestMock.setRequestURI("/customer/all");
		responseMock.setContentType("application/json");
		responseMock.addHeader("Accept", "application/json");

		handlerAdapter.handle(requestMock, responseMock, customerController);

		assertEquals(responseMock.getStatus(), HttpStatus.OK);
	}
}
