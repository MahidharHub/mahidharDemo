package com.mahidhar.demo.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import com.mahidhar.demo.repository.EmployeeRepository;

@Component
public class EmployeeCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory
			.getLogger(EmployeeCommandLineRunner.class);

	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {

		
		
		
		employeeRepository.save(new Employee("Nicolas","Cage","nicolas@gmail.com","Cologne","Cologne","IT","Architect",new BigDecimal("70000.00")));
		employeeRepository.save(new Employee("Johnny","Depp","johnny@gmail.com","Frankfurt","Frankfurt","Finance","Manager",new BigDecimal("80000.00")));
		employeeRepository.save(new Employee("Al","pacino","pacino@gmail.com","Los Angeles","Los Angeles","IT","Consultant",new BigDecimal("90000.00")));
		employeeRepository.save(new Employee("Russel","Crowe","russel@gmail.com","Sydney","Sydney","Marketing","Sales Head",new BigDecimal("120000.00")));
		employeeRepository.save(new Employee("Denzel","Washington","denzel@gmail.com","New York","New York","HR","Manager",new BigDecimal("80000.00")));
		employeeRepository.save(new Employee("Brad","Pitt","brad@gmail.com","London","London","IT","SAP Consultant",new BigDecimal("70000.00")));
		employeeRepository.save(new Employee("Leonardo","Dicaprio","leonardo@gmail.com","Munich","Munich","IT","Principal Consultant",new BigDecimal("120000.00")));
		employeeRepository.save(new Employee("Sylvester","Stallone","sylvester@gmail.com","Amsterdam","Amsterdam","Finance","Senior Manager",new BigDecimal("90000.00")));
		employeeRepository.save(new Employee("Keanu","Reeves","keanu@gmail.com","Brussels","Brussels","IT","Software Engineer",new BigDecimal("60000.00")));
		employeeRepository.save(new Employee("Hugh","Jackman","jackman@gmail.com","Paris","Paris","IT","Software Engineer",new BigDecimal("70000.00")));

		log.info("Initially loaded employees are.....");
		
		for (Employee employee : employeeRepository.findAll()) {
			log.info(employee.toString());
		}
	
	}

}
