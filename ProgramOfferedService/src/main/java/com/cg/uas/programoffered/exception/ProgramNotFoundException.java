/*******************************************************************************************
 - File Name        : ProgramNotFoundException
 - Author           : Yash Raj	
 - Creation Date    : 12-06-2020
 - Description      : This is an ProgramNotFoundException class to handle the 
 				      Exception in and give a user friendly message. 
  ****************************************************************************************************/

package com.cg.uas.programoffered.exception;

public class ProgramNotFoundException extends Exception{
	
	
	/************************************************************************
	 - Method Name      : getMessage
	 - Return type      : String
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : This method return the Error message when Exception occurs.
	  ******************************************************************************/ 
	@Override
	public String getMessage() {
		return "Program not Found";
	}

}
