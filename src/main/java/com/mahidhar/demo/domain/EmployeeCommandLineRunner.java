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

		
		
		
		employeeRepository.save(new Employee("Mahidhar","Reddy","mahi@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));
		employeeRepository.save(new Employee("Rama","Rao","rama@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));
		employeeRepository.save(new Employee("Raja","Reddy","raja@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));
		employeeRepository.save(new Employee("Raghu","Nayak","raghu@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));
		employeeRepository.save(new Employee("Prasad","Naidu","prasad@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));
		employeeRepository.save(new Employee("Raman","Singh","Raman@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));
		employeeRepository.save(new Employee("Chintu","Reddy","chintu@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));
		employeeRepository.save(new Employee("Madhu","Agarwal","madhu@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));
		employeeRepository.save(new Employee("Sasi","Reddy","sasi@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));
		employeeRepository.save(new Employee("Veer","Manohar","veer@gmail.com","cologne","cologne","IT","Architect",new BigDecimal("55000.00")));

		log.info("Initially loaded employees are.....");
		
		for (Employee employee : employeeRepository.findAll()) {
			log.info(employee.toString());
		}
	
	}

}
