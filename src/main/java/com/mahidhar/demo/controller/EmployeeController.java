package com.mahidhar.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mahidhar.demo.domain.Employee;
import com.mahidhar.demo.exception.EmployeeNotFoundException;
import com.mahidhar.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory
			.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("employees", employeeService.list());
		return "employee/list";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		employeeService.delete(id);
		redirectAttrs.addFlashAttribute("message", "Employee has been deleted from records!");
		return "redirect:/employees/list" ;
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model){
		
		Employee employee = employeeService.read(id);
		if(employee != null){
			model.addAttribute("employee", employee);	
			return "employee/postForm";	
		}else
		{
			return "redirect:/employees/list";	
		}
		
		
		
			
	}
	
	@RequestMapping( value = "/save", method = RequestMethod.POST )
	public String save(@Valid Employee employee, BindingResult bindingResult, Model model) {
				
		if( bindingResult.hasErrors() ){
			log.info("Binding Result has Errors ..." + bindingResult.getErrorCount());
			return "employee/postForm";
		} else {
			log.info("Binding Result has nooooooooooooo Errors ..." );
			Employee savedEmployee = employeeService.create(employee);
			return "redirect:/employees/list" ;
		}

	}
	
	

	@RequestMapping("/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("post", employeeService.read(id));
		return "employee/view";
	}
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public Iterable<Employee> list(){
		return employeeService.list();
	}
	
	@RequestMapping( value = "/", method = RequestMethod.POST )
	public Employee create(@RequestBody Employee employee){
		return employeeService.create(employee);
	}
	
	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("employee", new Employee());
		
		return "employee/postForm";
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public Employee read(@PathVariable(value="id") long id) throws EmployeeNotFoundException {
		Employee employee = employeeService.read(id);
		if( employee == null ){
			throw new EmployeeNotFoundException("employee with id: " + id + " not found.");
		}
		return employee;
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.PUT )
	public Employee update(@PathVariable(value="id") long id, @RequestBody Employee employee){
		return employeeService.update(id,employee);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
	public void delete(@PathVariable(value="id") int id){
		employeeService.delete(id);
	}	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public void handleEmployeeNotFound(EmployeeNotFoundException exception, HttpServletResponse response) throws IOException{
		response.sendError( HttpStatus.NOT_FOUND.value(), exception.getMessage() );
	}
}
