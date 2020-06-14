/*******************************************************************************************
 - File Name        : ProgramAlreadyExistsException
 - Author           : Yash Raj	
 - Creation Date    : 12-06-2020
 - Description      : This is an ProgramAlreadyExistsException class which is
 					   used to handle the Exception and give a user friendly message when it occurs. 
  ****************************************************************************************************/

package com.cg.uas.programoffered.exception;

public class ProgramAlreadyExistsException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	/************************************************************************
	 - Method Name      : getMessage
	 - Return type      : String
	 - Author           : Yash Raj	
	 - Creation Date    :12-06-2020
	 - Description      : This method return the Error message when Exception occurs.
	  ******************************************************************************/ 
	@Override
	public String getMessage() {
		return "Program Already Exist";
	}

}
