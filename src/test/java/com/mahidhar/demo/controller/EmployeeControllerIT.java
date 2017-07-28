package com.mahidhar.demo.controller;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mahidhar.demo.MahidharDemoApplication;
import com.mahidhar.demo.domain.Employee;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = MahidharDemoApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class EmployeeControllerIT {

	
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Before
	public void before() {

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
	}
	
	@Test
	public void retrieveEmployee() throws Exception {

		Employee employee = new Employee("Nicolas","Cage","nicolas@gmail.com","Cologne","Cologne","IT","Architect",new BigDecimal("70000.00"));
		
		HttpEntity entity = new HttpEntity<Employee>(employee, headers);
		
		ResponseEntity<Employee> response = restTemplate.exchange(
				createPort("/employees/1"),
				HttpMethod.GET, entity, Employee.class);

		

		assertTrue(response.getBody().getCity().equals("Cologne"));
	}
	
	@Ignore
	public void addEmployee() {

		Employee employee = new Employee("Leonardo","Dicaprio","leonardo@gmail.com","Munich","Munich","IT","Principal Consultant",new BigDecimal("120000.00"));

		HttpEntity entity = new HttpEntity<Employee>(employee, headers);

		ResponseEntity<Employee> response = restTemplate.exchange(
				createPort("/employees/"),
				HttpMethod.POST, entity, Employee.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/employees/"));

	}

	
	private String createPort(final String uri) {
		return "http://localhost:" + port + uri;
	}
}
