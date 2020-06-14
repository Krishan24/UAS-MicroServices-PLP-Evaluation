/*******************************************************************************************
 - File Name        : ApplicantService
 - Author           : Charul Gupta	
 - Creation Date    : 12-06-2020
 - Description      : This is Service interface for Application Management in University Admission System. 
  ****************************************************************************************************/ 

package com.cg.uas.applicationmanagement.service;

import java.util.List;

import com.cg.uas.applicationmanagement.dto.ApplicantEntity;
import com.cg.uas.applicationmanagement.exception.ApplicantAlreadyExsistsException;
import com.cg.uas.applicationmanagement.exception.ApplicantNotFoundException;



public interface ApplicantService {
	
public List<ApplicantEntity> getAllApplicants();
	
	public ApplicantEntity addApplicant(ApplicantEntity entity) throws ApplicantAlreadyExsistsException;
	
	public ApplicantEntity getApplicantByProgramName( String programName) throws ApplicantNotFoundException;
	
	public ApplicantEntity updateApplicantById(Integer applicantid, ApplicantEntity entity)throws ApplicantNotFoundException;

}
