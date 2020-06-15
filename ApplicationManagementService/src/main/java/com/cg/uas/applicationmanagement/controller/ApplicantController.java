/****************************************************************************************************************************
 - File Name        : ApplicantController
 - Author           : Charul Gupta
 - Creation Date    : 12-06-2020
 - Description      : This is an end point controller to consume Application Management Services.
 ****************************************************************************************************************************/ 

package com.cg.uas.applicationmanagement.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.uas.applicationmanagement.dto.ApplicantEntity;
import com.cg.uas.applicationmanagement.exception.ApplicantAlreadyExsistsException;
import com.cg.uas.applicationmanagement.exception.ApplicantNotFoundException;
import com.cg.uas.applicationmanagement.service.ApplicantService;


@RestController
@Validated
@RequestMapping("/applicants")
public class ApplicantController {
	
	
	
	
	@Autowired
	private ApplicantService service;
	

	
	/****************************************************************************************************************************
	 - Method Name      : getAllApplicants
	 - Input Parameters : void
	 - Return type      : List<ApplicantEntity> 
	 - Author           : Charul Gupta
	 - Creation Date    : 12-06-2020
	 - Description      : fetching the applicant information from the database.
	 - End point URL    : http://localhost:9001/applicants/getall
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/getall")
	public List<ApplicantEntity> getAllApplicants() {
		return service.getAllApplicants();
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : addApplicant
	 - Input Parameters : ApplicantEntity
	 - Return type      : ResponseEntity
	 - Author           : Charul Gupta
	 - Creation Date    : 12-06-2020
	 - Description      : Inserting the applicant information entered by user into the database.
	 - End point URL    : http://localhost:9001/applicants/addApplicant
	  ****************************************************************************************************************************/ 
	
	@PostMapping("/addApplicant")
	public ResponseEntity<ApplicantEntity> addApplicant(@Valid @RequestBody ApplicantEntity entity) throws ApplicantAlreadyExsistsException{
		ApplicantEntity appEntity = service.addApplicant(entity);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(appEntity);
		
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : getApplicantByProgramName
	 - Input Parameters : programName
	 - Return type      : ResponseEntity<ApplicantEntity>
	 - Author           : Charul Gupta
	 - Creation Date    : 12-06-2020
	 - Description      : Fetching the applicant information from the database by Program Name.
	 - End point URL    : http://localhost:9001/applicants/programNames
	  ****************************************************************************************************************************/
	
	@GetMapping("/{programName}")
	public ResponseEntity<ApplicantEntity> getApplicantByProgramName(@PathVariable("programName") String programName) throws ApplicantNotFoundException{
		ApplicantEntity appEntity = service.getApplicantByProgramName(programName);
		return ResponseEntity.status(HttpStatus.OK).body(appEntity);
		
		}
	
	
	/****************************************************************************************************************************
	 - Method Name      : updateApplicantById
	 - Input Parameters : applicantid, ApplicantEntity
	 - Return type      : ResponseEntity<ApplicantEntity>
	 - Author           : Charul Gupta
	 - Creation Date    : 12-06-2020
	 - Description      : Updating the applicant information entered by user into the database.
	 - End point URL    : http://localhost:9001/applicants/applicantid
	  ****************************************************************************************************************************/
	
	@PutMapping("/{applicantid}")
	public ResponseEntity<ApplicantEntity> updateApplicantById(@PathVariable("applicantid") Integer applicantid, @RequestBody ApplicantEntity entity) throws ApplicantNotFoundException{
		ApplicantEntity appEntity = service.updateApplicantById(applicantid, entity);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(appEntity);
	}

	

}
