/*******************************************************************************************
 - File Name        : ScheduleProgramService ExceptionController
 - Author           : Krishan Sitlani	
 - Creation Date    : 11-06-2020
 - Description      : This is an ExceptionController class to handle the Exception in University Addmission System. 
  ****************************************************************************************************/ 
package com.cg.uas.schedule.program.service.exception;

import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController 
{
	
	@ExceptionHandler(ScheduleProgramNotFoundException.class)
	public String handleException(ScheduleProgramNotFoundException e) {
		
		return e.getMessage();
	}
	
	@ExceptionHandler(ScheduleProgramExistException.class)
	public String handleNameException(ScheduleProgramExistException e) {
		
		return e.getMessage();
	}
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	     
	    ex.getConstraintViolations().forEach(cv -> {
	        errors.put("message", cv.getMessage());
	        errors.put("path", cv.getPropertyPath().toString());
	    }); 
	 
	    return errors;
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
	    return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	  }

}
