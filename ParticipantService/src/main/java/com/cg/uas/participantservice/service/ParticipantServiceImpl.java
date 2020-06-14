/**********************************************************************************************
 - File Name        : ParticipantServiceImpl
 - Author           : SatyaPavani Chekka
 - Creation Date    : 11-06-2020
 - Description      : This is the Service Implementation class to consume University Admission System. 
  *********************************************************************************************/
package com.cg.uas.participantservice.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.uas.participantservice.dao.ParticipantRepository;
import com.cg.uas.participantservice.dto.ParticipantEntity;
import com.cg.uas.participantservice.exception.*;

import java.util.Optional;

@Service
public class ParticipantServiceImpl implements IParticipantService{
	

	@Autowired
	ParticipantRepository repository;
	
	

	/************************************************************************************
	 - Method Name      : getApplicationsByProgramName
	 - Return type      : Optional<ParticipantEntity>
	 - Author           : SatyaPavani Chekka
	 - Creation Date    : 11-06-2020
	 - Description      : Getting all Applicants By Program Name
	 
	  
	  ************************************************************************************/
	@Override
public Optional<ParticipantEntity> getApplicationsByProgramName(String programName) throws ProgramNameNotFoundException
	{
		// TODO Auto-generated method stub
		Optional<ParticipantEntity> interview=repository.getByProgramName(programName);
		if(interview.isPresent())
		{
			return interview;
		}
		else
			throw new ProgramNameNotFoundException();
	}
	

	/**************************************************************************************
	 - Method Name      : updateInterviewByApplicationId
	 - Return type      : String
	 - Author           : SatyaPavani Chekka
	 - Creation Date    : 11-06-2020
	 - Description      : Update the Interview with the Application ID
	 
	  
	  *************************************************************************************/
	@Override
public String updateInterviewByApplicationId(int applicationId, LocalDate interviewDate, String status) throws ApplicationIdNotFoundException
	{
		// TODO Auto-generated method stub
		Optional<ParticipantEntity> optional = repository.findById(applicationId);
		ParticipantEntity entity = optional.get();
		entity.setInterviewDate(interviewDate);
		entity.setStatus(status);
		
           if(repository.existsById(applicationId))
           {
        	   repository.saveAndFlush(entity);
        		return "Interview Date and Status updated successfully";
           }
           else
        	   throw new ApplicationIdNotFoundException();
	        
		
	}



	
  
	

	
	

}
