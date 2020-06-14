/*******************************************************************************************
 - File Name        : ExceptionController
 - Author           : Charul Gupta	
 - Creation Date    : 12-06-2020
 - Description      : This is an ExceptionController class to handle the Exception in Application Management. 
  **********************************************************************************************************/

package com.cg.uas.applicationmanagement.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ApplicantNotFoundException.class)
	public String handleException(ApplicantNotFoundException e) {
		
		return e.getMessage();
	}
	
	@ExceptionHandler(ApplicantAlreadyExsistsException.class)
	public String handleNameException(ApplicantAlreadyExsistsException e) {
		
		return e.getMessage();
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	     
	    ex.getConstraintViolations().forEach(cv -> {
	        errors.put("message", cv.getMessage());
	        errors.put("path", (cv.getPropertyPath()).toString());
	    }); 
	 
	    return errors;
	}

}



