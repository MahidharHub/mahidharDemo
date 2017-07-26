package com.mahidhar.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.mahidhar.demo.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	
}