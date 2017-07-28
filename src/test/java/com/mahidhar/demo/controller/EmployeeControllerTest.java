package com.mahidhar.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Map;

import javax.validation.Valid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mahidhar.demo.domain.Employee;
import com.mahidhar.demo.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;


	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void retrieveEmployee() throws Exception {
		Employee mockEmployee = new Employee("Nicolas","Cage","nicolas@gmail.com","Cologne","Cologne","IT","Architect",new BigDecimal("70000.00"));
		
		Mockito.when(
				employeeService.read(Mockito.anyLong())).thenReturn(mockEmployee);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/employees/edit/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder)
								  .andExpect(status().isOk())
								  .andExpect(view().name("employee/postForm"))
				                   .andReturn();
		
		Map<String,Object> resultMap =  result.getModelAndView().getModel();
		Employee employee = (Employee) resultMap.get("employee");
		
		assertEquals("Cologne", employee.getCity());
		assertEquals("Nicolas", employee.getFirstName());
		
	}
	
	
	
	
	
}
