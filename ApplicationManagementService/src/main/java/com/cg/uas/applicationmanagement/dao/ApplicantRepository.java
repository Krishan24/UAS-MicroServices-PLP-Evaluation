/*******************************************************************************************
 - File Name        : ApplicantRepository
 - Author           : Charul Gupta	
 - Creation Date    : 12-06-2020
 - Description      : This is a Repository Interface which defines operations for 
 					  Entity class  in Application Management. 
  ****************************************************************************************************/ 

package com.cg.uas.applicationmanagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.uas.applicationmanagement.dto.ApplicantEntity;
import com.cg.uas.applicationmanagement.exception.ApplicantNotFoundException;


@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantEntity, Integer>{

	public Optional<ApplicantEntity> findByProgramName(String programName) throws ApplicantNotFoundException;
}
