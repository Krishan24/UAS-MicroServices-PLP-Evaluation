/****************************************************************************************************************************
 - File Name      : ProgramController
 - Author           : Yash Raj
 - Creation Date    : 12-06-2020
 - Description      : This is an end point controller to consume Program Offered Services.
  ****************************************************************************************************************************/ 
package com.cg.uas.programoffered.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.uas.programoffered.dto.Program;
import com.cg.uas.programoffered.exception.ProgramAlreadyExistsException;
import com.cg.uas.programoffered.exception.ProgramNotFoundException;
import com.cg.uas.programoffered.service.IProgramService;
@RestController
@Validated
@RequestMapping("/programs")

public class ProgramController {
	
	@Autowired
	private IProgramService service;
	
	/****************************************************************************************************************************
	 - Method Name      : getAllPrograms
	 - Input Parameters : void
	 - Return type      : List<Program> 
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : fetching All the Program information from the database.
	 - End point URL    : http://localhost:9001/programs/getAllPrograms
	  ****************************************************************************************************************************/ 
	@GetMapping("/getAllPrograms")
	public ResponseEntity<List<Program>> getAllPrograms()
	{
		 List<Program> list=service.getAllPrograms();
		 return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : getProgramById
	 - Input Parameters : id
	 - Return type      : ResponseEntity<Program> 
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : fetching the Program information on basis of id from the database.
	 - End point URL    : http://localhost:9001/programs/getById/101
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Program> getProgramById(@Valid @PathVariable("id")@Positive  @Max(999) int id) throws ProgramNotFoundException
	{
		Program program=service.getProgramById(id);
		return ResponseEntity.status(HttpStatus.OK).body(program);
	}
	
	

	/****************************************************************************************************************************
	 - Method Name      : addProgram
	 - Input Parameters : Program
	 - Return type      : ResponseEntity<Program> 
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : Add program to the database.
	 - End point URL    : http://localhost:9001/programs/addProgram
	  ****************************************************************************************************************************/ 
	
	
	@PostMapping("/addProgram")
	public ResponseEntity<Program> addProgram( @RequestBody Program program) throws ProgramAlreadyExistsException
	{
		Program p = service.addProgram(program);
		
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : deleteProgram
	 - Input Parameters : id
	 - Return type      : ResponseEntity<String>
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : Delete the program basis of id from the database.
	 - End point URL    : http://localhost:9001/programs/delete/200
	  ****************************************************************************************************************************/
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProgram(@Valid @PathVariable("id")@Positive @Max(999) int id) throws ProgramNotFoundException {
		return ResponseEntity.ok(service.deleteProgramById(id));
		
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : updateProgram
	 - Input Parameters : Program
	 - Return type      : ResponseEntity<Program>
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : Update program information to the database.
	 - End point URL    : http://localhost:9000/programs/updateProgram
	  ****************************************************************************************************************************/
	

	@PutMapping("/updateProgram")
	public ResponseEntity<Program> updateProgram( @RequestBody Program program) throws ProgramNotFoundException {
		Program p = service.updateProgram(program);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	

}
