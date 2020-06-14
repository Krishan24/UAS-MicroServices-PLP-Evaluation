
/*******************************************************************************************
 - File Name        : ScheduleProgramService ScheduleService
 - Author           : Krishan Sitlani	
 - Creation Date    : 11-06-2020
 - Description      : This is Service interface for Schedulein Program in University Addmission System. 
  ****************************************************************************************************/ 
package com.cg.uas.schedule.program.service.service;

import java.util.List;
import com.cg.uas.schedule.program.service.dto.ScheduleProgram;
import com.cg.uas.schedule.program.service.exception.ScheduleProgramExistException;
import com.cg.uas.schedule.program.service.exception.ScheduleProgramNotFoundException;

public interface ScheduleService 
{

	public List<ScheduleProgram> getAllSchedules();
	
	public ScheduleProgram getScheduleById(int id) throws ScheduleProgramNotFoundException;

	public ScheduleProgram addSchedule(ScheduleProgram schedule) throws ScheduleProgramExistException;
	
	public ScheduleProgram deleteScheduleById(int id) throws ScheduleProgramNotFoundException;

}

