/*******************************************************************************************
 - File Name        : ScheduleProgramService  ScheduleProgramRepository 
 - Author           : Krishan Sitlani	
 - Creation Date    : 11-06-2020
 - Description      : This is a Repository Interface which defines operations for 
 					  Entity class  in University Admission System. 
  ****************************************************************************************************/ 

package com.cg.uas.schedule.program.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.uas.schedule.program.service.dto.ScheduleProgram;

public interface ScheduleProgramRepository extends JpaRepository<ScheduleProgram, Integer>
{
	

}
