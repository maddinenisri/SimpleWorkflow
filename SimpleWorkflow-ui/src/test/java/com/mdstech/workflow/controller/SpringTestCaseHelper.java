package com.mdstech.workflow.controller;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ImportResource(value = "classpath:META-INF/spring/workflow-services-context.xml")
@ContextConfiguration({
		"classpath*:META-INF/spring/workflow-services-context.xml",
		"classpath*:META-INF/spring/workflow-ui-context.xml" })
public class SpringTestCaseHelper {

}
