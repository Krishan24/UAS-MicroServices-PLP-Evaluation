/*******************************************************************************************
 - File Name        : ScheduleProgramService ScheduleServiceImpl
 - Author           : Krishan Sitlani	
 - Creation Date    : 11-06-2020
 - Description      : This is Service Class for implementing CRUD Operation on  University Addmission System. 
  ****************************************************************************************************/ 
package com.cg.uas.schedule.program.service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cg.uas.schedule.program.service.dao.ScheduleProgramRepository;
import com.cg.uas.schedule.program.service.dto.ScheduleProgram;
import com.cg.uas.schedule.program.service.exception.ScheduleProgramExistException;
import com.cg.uas.schedule.program.service.exception.ScheduleProgramNotFoundException;

@Service
public class ScheduleServiceImpl implements ScheduleService
{
	
	Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
	String msg = "Sorry for the inconvinience, currently database is down";
	String loggerMsg = "Problem with connectivity with service to DAO layer";
	
	@Autowired
	private ScheduleProgramRepository repo;

	/************************************************************************
	 - Method Name      : getAllSchedules
	 - Return type      : List<ScheduleProgram>
	 - Author           : Krishan Sitlani
	 - Creation Date    :11-06-2020
	 - Description      : Getting all Programs which are Scheduled
	  ******************************************************************************/ 
	@Override
	public List<ScheduleProgram> getAllSchedules() {
		return repo.findAll();
	}
	/************************************************************************
	 - Method Name      : getScheduleById
	 - Return type      : List<ScheduleProgram>
	 - Author           : Krishan Sitlani
	 - Creation Date    :11-06-2020
	 - Description      : Getting all Programs which are Scheduled by Id
	  ******************************************************************************/ 
	@Override
	public ScheduleProgram getScheduleById(int id) throws ScheduleProgramNotFoundException {
		return repo.findById(id).orElseThrow(() -> new ScheduleProgramNotFoundException());
	}
	/************************************************************************
	 - Method Name      : addSchedule
	 - Return type      : ScheduleProgram
	 - Author           : Krishan Sitlani
	 - Creation Date    :11-06-2020
	 - Description      : Adding all Programs which are Scheduled
	  ******************************************************************************/ 
	@Override
	public ScheduleProgram addSchedule(ScheduleProgram schedule) throws ScheduleProgramExistException {
		if (repo.existsById(schedule.getProgramId())){
			logger.error(loggerMsg);
			throw new ScheduleProgramExistException();
		}else
			return repo.saveAndFlush(schedule);
	}
	/************************************************************************
	 - Method Name      : deleteScheduleById
	 - Return type      : ScheduleProgram
	 - Author           : Krishan Sitlani
	 - Creation Date    :11-06-2020
	 - Description      : Deleting all Programs which are Scheduled
	 ******************************************************************************/ 
	@Override
	public ScheduleProgram deleteScheduleById(int id) throws ScheduleProgramNotFoundException {
		if (repo.existsById(id)) {
			logger.error(loggerMsg);
			ScheduleProgram s = repo.findById(id).orElse(null);
			ScheduleProgram result = new ScheduleProgram(s.getProgramId(), s.getProgramName(), s.getLocation(), s.getStartDate(),
					s.getEndDate(), s.getNoOfSeats());
			repo.deleteById(id);
			return result;
		}else {
			throw new ScheduleProgramNotFoundException();
		}
	}
	

}
