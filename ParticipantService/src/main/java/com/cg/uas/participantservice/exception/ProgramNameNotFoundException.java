/**********************************************************************************************
 - File Name        : ProgramNameNotFoundException
 - Author           : SatyaPavani Chekka
 - Creation Date    : 11-06-2020
 - Description      : This is an ProgramNameNotFoundException class which is
 					   used to handle the Exception in Participant Service.  
  *********************************************************************************************/
package com.cg.uas.participantservice.exception;

public class ProgramNameNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/************************************************************************************
	 - Method Name      : getMessage
	 - Return type      : String
	 - Author           : SatyaPavani Chekka
	 - Creation Date    : 11-06-2020
	 - Description      : This method return the Error message when Exception occurs.
	  ************************************************************************************/
	public String getMessage()
	{
		return "Program Name Not Found";
	}

}
