
/*******************************************************************************************
 - File Name        : ScheduleProgramService Controller
 - Author           : Krishan Sitlani	
 - Creation Date    : 11-06-2020
 - Description      : This is an end point controller to consume University Addmission System. 
  ****************************************************************************************************/ 

package com.cg.uas.schedule.program.service.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.uas.schedule.program.service.dto.ScheduleProgram;
import com.cg.uas.schedule.program.service.exception.ScheduleProgramExistException;
import com.cg.uas.schedule.program.service.exception.ScheduleProgramNotFoundException;
import com.cg.uas.schedule.program.service.service.ScheduleService;

@Validated
@RestController
public class ScheduleProgramController 
{
	@Autowired
	private ScheduleService service;
	
	/************************************************************************
	 - Method Name      : getAllSchedule
	 - Return type      : List<ScheduleProgram>
	 - Author           : Krishan Sitlani
	 - Creation Date    :11-06-2020
	 - Description      : Getting all Programs which are Scheduled
	 -End Point URL		: http://localhost:4040/fetchall
	  ******************************************************************************/ 

	@GetMapping("/fetchall")
	public List<ScheduleProgram> getAllSchedule() {
		return service.getAllSchedules();
	}
	/*****************************************************************************
	 - Method Name      	: getScheduleById
	 - Input Parameeteres 	: id
	 - Return type      	: ResponseEntity<ScheduleProgram>
	 - Author           	: Krishan Sitlani
	 - Creation Date    	: 11-06-2020
	 - Description     	 	: Getting all Programs which are Scheduled by Id
	 -End Point URL			: http://localhost:4040/fetchbyid/101
	  ************************************************************************/ 
	@GetMapping("/fetchbyid/{id}")
	public ResponseEntity<ScheduleProgram> getScheduleById(@PathVariable ("id") @Max(999) int id) throws ScheduleProgramNotFoundException {
		ScheduleProgram sp = service.getScheduleById(id);
		return ResponseEntity.status(HttpStatus.OK).body(sp);
	}
	/*****************************************************************************
	 - Method Name      	: addSchedule
	 - Input Parameeteres 	: schedule
	 - Return type      	: ResponseEntity<ScheduleProgram>
	 - Author           	: Krishan Sitlani
	 - Creation Date    	: 11-06-2020
	 - Description      	: Adding all Programs to be schedule
	 -End Point URL			: http://localhost:4040/addschedule
	  ************************************************************************/ 
	
	@PostMapping("/addschedule")
	public ResponseEntity<ScheduleProgram> addSchedule(@Valid @RequestBody ScheduleProgram schedule) throws ScheduleProgramExistException {
		ScheduleProgram sp = service.addSchedule(schedule);
		return ResponseEntity.status(HttpStatus.OK).body(sp);
	}
	/*****************************************************************************
	 - Method Name      	: deleteSchedule
	 - Input Parameeteres 	: id
	 - Return type      	: ResponseEntity<ScheduleProgram>
	 - Author           	: Krishan Sitlani
	 - Creation Date    	: 11-06-2020
	 - Description      	: Deleting all Programs which are Scheduled by Id
	 -End Point URL			: http://localhost:4040/deletebyid/101
	  ************************************************************************/ 
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<ScheduleProgram> deleteSchedule(@PathVariable ("id") int id) throws ScheduleProgramNotFoundException {
		ScheduleProgram sp = service.deleteScheduleById(id);
		return ResponseEntity.status(HttpStatus.OK).body(sp);
	}

}
