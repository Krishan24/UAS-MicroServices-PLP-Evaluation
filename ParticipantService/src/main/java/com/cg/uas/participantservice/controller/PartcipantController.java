/**********************************************************************************************
 - File Name        : Participant Controller
 - Author           : SatyaPavani Chekka
 - Creation Date    : 11-06-2020
 - Description      : This is an end point controller to consume University Admission System. 
  *********************************************************************************************/
package com.cg.uas.participantservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.uas.participantservice.dto.ParticipantEntity;
import com.cg.uas.participantservice.exception.ApplicationIdNotFoundException;
import com.cg.uas.participantservice.exception.ProgramNameNotFoundException;
import com.cg.uas.participantservice.service.*;

import java.util.Optional;


@RestController
@RequestMapping("/interview")
public class PartcipantController {

	
	@Autowired
	private IParticipantService service;
	
	/************************************************************************************
	 - Method Name      : getApplicationsByProgramName
	 - Return type      : ResponseEntity<Optional<ParticipantEntity>>
	 - Author           : SatyaPavani Chekka
	 - Creation Date    : 11-06-2020
	 - Description      : Getting all Applicants By Program Name
	 - End Point URL	: http://localhost:9090/interview/B.E
	  
	  ************************************************************************************/
	@GetMapping("/{programName}")
public ResponseEntity<Optional<ParticipantEntity>> getApplicationsByProgramName(@PathVariable("programName") String programName) throws ProgramNameNotFoundException
	{
		Optional<ParticipantEntity> program=service.getApplicationsByProgramName(programName);
		
		return ResponseEntity.ok(program);
	}
	
	
	/**************************************************************************************
	 - Method Name      : updateInterviewByApplicationId
	 - Return type      : ResponseEntity<String>
	 - Author           : SatyaPavani Chekka
	 - Creation Date    : 11-06-2020
	 - Description      : Getting all Applicants By Program Name
	 - End Point URL	: http://localhost:9090/interview/101
	  
	  *************************************************************************************/
	@PutMapping("/{applicationId}")
public ResponseEntity<String> updateInterviewByApplicationId(@PathVariable("applicationId") int applicationId, @RequestBody ParticipantEntity participant) throws ApplicationIdNotFoundException
	 {
		String interview= service.updateInterviewByApplicationId( applicationId, participant.getInterviewDate(), participant.getStatus());
		return new ResponseEntity<String>(interview, HttpStatus.ACCEPTED);
	 }
	
	
	
}
