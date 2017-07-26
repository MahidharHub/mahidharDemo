package com.mahidhar.demo.exception.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mahidhar.demo.exception.CustomGenericException;

@Controller
public class EmployeeExceptionController {

	@RequestMapping(value = "/{type:.+}", method = RequestMethod.GET)
	public ModelAndView getPages(@PathVariable("type") String type)
		throws Exception {

	  if ("error".equals(type)) {
		// go handleCustomException
		throw new CustomGenericException("Employee DEMO Exception", "This is a custom message");
	  } else if ("io-error".equals(type)) {
		// go handleAllException
		throw new IOException();
	  } else {
		return new ModelAndView("index").addObject("msg", type);
	  }

	}

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		ModelAndView model = new ModelAndView("employee/error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("employee/error");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}
}
