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
import org.slf4j.Logger;
import com.cg.uas.participantservice.dao.ParticipantRepository;
import com.cg.uas.participantservice.dto.ParticipantEntity;
import com.cg.uas.participantservice.exception.*;

import org.slf4j.LoggerFactory;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements IParticipantService{
	

	@Autowired
	ParticipantRepository repository;
	String msg = "Sorry for the inconvinience, currently database is down";
	String loggerMsg= "Problem with connectivity with service to DAO Layer";
	Logger logger = LoggerFactory.getLogger(ParticipantServiceImpl.class);
	
	

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
				logger.error(loggerMsg);
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
		   	logger.error(loggerMsg);
        	   throw new ApplicationIdNotFoundException();
	        
		
	}

	
	      
  	/**************************************************************************************
 	 - Method Name      : getApplicationStatusById
 	 - Return type      : ParticipantEntity
 	 - Author           : SatyaPavani Chekka
 	 - Creation Date    : 11-06-2020
 	 - Description      : Can view the Status of the interview with the Application ID
 	  *************************************************************************************/
	@Override
	public ParticipantEntity getApplicationStatusById(int applicationId, ParticipantEntity participant) throws ApplicationIdNotFoundException {
		// TODO Auto-generated method stub
		//Optional<ParticipantEntity> entity= repository.findById(applicationId);
		if(repository.existsById(applicationId))
		{
		    return repository.saveAndFlush(participant);
		}
		else
				logger.error(loggerMsg);
			throw new ApplicationIdNotFoundException();
	}


	
  
	

	
	

}
