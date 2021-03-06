/*******************************************************************************************
 - File Name        : ScheduleProgramService ScheduleProgram
 - Author           : Krishan Sitlani	
 - Creation Date    : 11-06-2020
 - Description      : This is entity class to represt objects in Database of University Addmission System. 
  ****************************************************************************************************/ 
package com.cg.uas.schedule.program.service.dto;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="schedule_program")
public class ScheduleProgram 
{
	@Id
	@Min(value=1, message="Id cannot be smaller than 1")
	@Max(value=999,message="ID cannot be more than 3 digit")
	@NotNull(message = "Program Id  should no be null")
	@Column(name="program_id")
	@Positive(message="program id should be positive")
	private Integer programId;
	
	@NotBlank(message = "Program Name should not be blank")
	@NotNull(message = "Program Name should not be null")
	@Column(name="program_name")
	@Size(min=2,max=10, message="Program name should be inside 2 to 10 characters")
	private String programName;
	
	@NotBlank(message = "Location should no be blank")
	@Size(min=2,max=8)
	@NotNull(message = "Location should not be null")
	private String location;
	@DateTimeFormat(pattern= "yyyy-mm-dd")	
	@Column(name="start_date")
	@NotNull(message = "Start Date should not be null")
	private Date startDate;
	
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	@Column(name="end_date")
	@NotNull(message = "End Date should not be null")
	private Date endDate;
	
	@Column(name="no_of_seats")
	@Positive(message="No Of Seats should be positive")
	@Max(value= 200 ,message="No of seats maximum should be 200")
	@NotNull(message = "No Of Seats should not be null")
	private Integer noOfSeats;
	
	public Integer getProgramId() {
		return programId;
	}
	public void setProgramId(Integer programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	@Override
	public String toString() {
		return "ScheduledProgram [programId=" + programId + ", programName=" + programName + ", location=" + location
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", noOfSeats=" + noOfSeats + "]";
	}
	
	public ScheduleProgram()
	{
		
	}
	
	public ScheduleProgram( Integer programId,  String programName,  String location,
			Date startDate,  Date enddDate,  Integer noOfSeats) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.location = location;
		this.startDate = startDate;
		this.endDate = enddDate;
		this.noOfSeats = noOfSeats;
	}
	
}
