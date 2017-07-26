package com.mahidhar.demo.service;

import com.mahidhar.demo.domain.Employee;

public interface  EmployeeService {

   Iterable<Employee> list();
	
   Employee create(Employee employee);
	
   Employee read(long id);
	
   Employee update(long id, Employee employee);
	
	void delete(long id);
}
