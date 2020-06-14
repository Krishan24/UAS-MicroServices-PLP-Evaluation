/**********************************************************************************************
 - File Name        : IParticipant Service
 - Author           : SatyaPavani Chekka
 - Creation Date    : 11-06-2020
 - Description      :  This is Service interface for Participant Service in University Admission System.  
  *********************************************************************************************/
package com.cg.uas.participantservice.service;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import com.cg.uas.participantservice.dto.ParticipantEntity;
import com.cg.uas.participantservice.exception.*;
public interface IParticipantService {
	
	
public Optional<ParticipantEntity> getApplicationsByProgramName(String programName) throws ProgramNameNotFoundException; 
public String updateInterviewByApplicationId(int applicationId, LocalDate interviewDate, String status) throws ApplicationIdNotFoundException;
public ParticipantEntity getApplicationStatusById(int applicationId, ParticipantEntity participant) throws ApplicationIdNotFoundException; 
}
