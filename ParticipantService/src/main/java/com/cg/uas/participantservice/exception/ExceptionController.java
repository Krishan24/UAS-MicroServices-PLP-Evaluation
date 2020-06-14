/**********************************************************************************************
 - File Name        : Exception Controller
 - Author           : SatyaPavani Chekka
 - Creation Date    : 11-06-2020
 - Description      :This is an ExceptionController class to handle the Exception in Participant Service. 
  *********************************************************************************************/
package com.cg.uas.participantservice.exception;

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
	/************************************************************************************
	 - Method Name      : handleNameException
	 - Return type      : String
	 - Author           : SatyaPavani Chekka
	 - Creation Date    : 11-06-2020
	 - Description      : To check the ProgramName Exception
	************************************************************************************/
	@ExceptionHandler(ProgramNameNotFoundException.class)
	public String handleNameException(ProgramNameNotFoundException e) {
		
		return e.getMessage();
	}
	
	/************************************************************************************
	 - Method Name      : handleException
	 - Return type      : String
	 - Author           : SatyaPavani Chekka
	 - Creation Date    : 11-06-2020
	 - Description      : To check whether application ID is there are not there Exception
	************************************************************************************/
	@ExceptionHandler(ApplicationIdNotFoundException.class)
	public String handleException(ApplicationIdNotFoundException e) {
		
		return e.getMessage();
	}
	
	/************************************************************************************
	 - Method Name      : handleConstraintViolation
	 - Return type      : String
	 - Author           : SatyaPavani Chekka
	 - Creation Date    : 11-06-2020
	 - Description      : To check Constraint Exception
	************************************************************************************/
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	     
	    ex.getConstraintViolations().forEach(cv -> {
	        errors.put("message", cv.getMessage());
	        errors.put("path", (cv.getPropertyPath()).toString());
	    }); 
	 
	    return errors;
	}
	
	
	/************************************************************************************
	 - Method Name      : handleMethodArgumentNotValidException
	 - Return type      : String
	 - Author           : SatyaPavani Chekka
	 - Creation Date    : 11-06-2020
	 - Description      : To check the Methods exceptions
	************************************************************************************/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
	    return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	  }

}
