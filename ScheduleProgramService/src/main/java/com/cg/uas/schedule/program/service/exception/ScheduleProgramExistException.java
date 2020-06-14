
/*******************************************************************************************
 - File Name        : ScheduleProgramService ScheduleProgramExistException
 - Author           : Krishan Sitlani	
 - Creation Date    : 11-06-2020
 - Description      : This is an ScheduleProgramExistException class which is
 					   used to handle the Exception in University Addmission System. 
  ****************************************************************************************************/ 
package com.cg.uas.schedule.program.service.exception;

public class ScheduleProgramExistException extends Exception
{
	/************************************************************************
	 - Method Name      : getMessage
	 - Return type      : String
	 - Author           : Krishan Sitlani
	 - Creation Date    :11-06-2020
	 - Description      : This method return the Error message when Exception occurs.
 	  ******************************************************************************/ 
	@Override
	public String getMessage() {
		return "program schedule already exists";
	}

}
