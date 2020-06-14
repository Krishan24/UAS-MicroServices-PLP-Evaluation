/**********************************************************************************************
 - File Name        : Participant Repository
 - Author           : SatyaPavani Chekka
 - Creation Date    : 11-06-2020
 - Description      : This is a Repository Interface which defines operations for 
 					  Entity class  in Participant Service. 
  *********************************************************************************************/

package com.cg.uas.participantservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.uas.participantservice.dto.ParticipantEntity;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Integer>{
	
	
	Optional<ParticipantEntity> getByProgramName(String programName);
	

}
