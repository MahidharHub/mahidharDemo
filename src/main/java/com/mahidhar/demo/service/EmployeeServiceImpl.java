package com.mahidhar.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahidhar.demo.domain.Employee;
import com.mahidhar.demo.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository ;
	}
	@Override
	public Iterable<Employee> list() {
		// TODO Auto-generated method stub
		 return employeeRepository.findAll();
	}

	@Override
	public Employee create(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee read(long id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public Employee update(long id, Employee udpate) {
		Employee employee = employeeRepository.findOne(id);
		//Set firstName
		if( udpate.getFirstName() != null ) {
			employee.setFirstName(udpate.getFirstName());
		}
		
		//setlastName
		if( udpate.getLastName() != null ) {
			employee.setLastName(udpate.getLastName());
		}
		
		//set email
		if( udpate.getEmail() != null ) {
			employee.setEmail(udpate.getEmail());
		}
		
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(long id) {
		
		employeeRepository.delete(id);

	}
	
	

}
