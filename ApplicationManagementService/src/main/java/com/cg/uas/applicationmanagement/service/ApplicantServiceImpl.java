/*******************************************************************************************
 - File Name        : ApplicantServiceImpl
 - Author           : Charul Gupta	
 - Creation Date    : 12-06-2020
 - Description      : This is Service interface for Application Management in University Admission System. 
  ****************************************************************************************************/

package com.cg.uas.applicationmanagement.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.uas.applicationmanagement.dao.ApplicantRepository;
import com.cg.uas.applicationmanagement.dto.ApplicantEntity;
import com.cg.uas.applicationmanagement.exception.ApplicantAlreadyExsistsException;
import com.cg.uas.applicationmanagement.exception.ApplicantNotFoundException;


@Service
public class ApplicantServiceImpl implements ApplicantService{
	
	@Autowired
	private ApplicantRepository repo;

	
	/************************************************************************
	 - Method Name      : getAllApplicants()
	 - Return type      : List<ApplicantEntity>
	 - Author           : Charul Gupta
	 - Creation Date    : 12-06-2020
	 - Description      : Getting all the applicant information from the database
	  ******************************************************************************/ 
	@Override
	public List<ApplicantEntity> getAllApplicants() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	
	/************************************************************************
	 - Method Name      : addApplicant
	 - Return type      : ApplicantEntity
	 - Author           : Charul Gupta
	 - Creation Date    : 12-06-2020
	 - Description      : Adding applicant information entered by user
	  ******************************************************************************/ 
	@Override
	public ApplicantEntity addApplicant(ApplicantEntity entity) throws ApplicantAlreadyExsistsException{
		// TODO Auto-generated method stub
		if(repo.existsById(entity.getApplicantid()))
			throw new ApplicantAlreadyExsistsException();
		else
		return repo.save(entity);
	}
	

	/************************************************************************
	 - Method Name      : getApplicantByProgramName
	 - Return type      : ApplicantEntity
	 - Author           : Charul Gupta
	 - Creation Date    : 12-06-2020
	 - Description      : Getting all applicant information on the basis of Program Name
	  **********************************************************************************/ 
	@Override
	public ApplicantEntity getApplicantByProgramName( String programName) throws ApplicantNotFoundException{
		Optional<ApplicantEntity> appEntity = repo.findByProgramName(programName);
		if(appEntity.isPresent())
			return appEntity.get();
		else
			throw new ApplicantNotFoundException();
		
			
	}
	
	
	/************************************************************************
	 - Method Name      : updateApplicantById
	 - Return type      : ApplicantEntity
	 - Author           : Charul Gupta
	 - Creation Date    : 12-06-2020
	 - Description      : Updating the applicant information entered by user
	 ******************************************************************************/ 
	@Override
	public ApplicantEntity updateApplicantById(Integer applicantid, ApplicantEntity entity)throws ApplicantNotFoundException {
		// TODO Auto-generated method stub
		Optional<ApplicantEntity> appEntity = repo.findById(applicantid);
		if(appEntity.isPresent())
			return repo.save(entity);
		else
		throw new ApplicantNotFoundException();
	}

	
	
	

}
