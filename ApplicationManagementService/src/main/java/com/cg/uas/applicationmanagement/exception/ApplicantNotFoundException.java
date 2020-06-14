/*******************************************************************************************
 - File Name        : ApplicantNotFoundException
 - Author           : Charul Gupta	
 - Creation Date    : 12-06-2020
 - Description      : This is an ApplicantNotFoundException class to handle the 
 				      Exception in Application Management. 
  ****************************************************************************************************/ 

package com.cg.uas.applicationmanagement.exception;

public class ApplicantNotFoundException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	/************************************************************************
	 - Method Name      : getMessage
	 - Return type      : String
	 - Author           : Charul Gupta
	 - Creation Date    : 12-06-2020
	 - Description      : This method return the Error message when Exception occurs.
	  ******************************************************************************/ 
	@Override
	public String getMessage() {
		return "Applicant Not Found";
	}


}
