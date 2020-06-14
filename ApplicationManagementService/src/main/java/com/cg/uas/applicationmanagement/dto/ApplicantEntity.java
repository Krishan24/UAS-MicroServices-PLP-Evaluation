/*******************************************************************************************
 - File Name        : ApplicantEntity
 - Author           : Charul Gupta	
 - Creation Date    : 12-06-2020
 - Description      : This is an entity class to represent objects in Database of Application Management. 
  ****************************************************************************************************/ 

package com.cg.uas.applicationmanagement.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;



@Entity
@Table(name="application")
public class ApplicantEntity {
	
	@Id
	@Column(name="applicantid")
	@Positive(message="Id should be positive")
	@NotNull(message="Id should not be null")
	private Integer applicantid;
	
	
	@NotBlank(message="Name should not be blank")
	@Size(min = 3, message = "Name should be of atleast 3 characters")
	@Column(name="applicantname")
	private String applicantname;
	
	@Past
	@Column(name="DATEOFBIRTH")
	private LocalDate dateOfBirth;
	
	
	@NotBlank(message="HighestQualification should not be blank ")
	@Size(min = 2, message = "Atleast 2 characters required")
	@Column(name="highestqualification")
	private String highestQualification;
	
	
	@NotNull(message="MarksObtained should not be null")
	@Min(value = 35, message = "Marks Obtained should not be less than 35")
    @Max(value = 100, message = "Marks Obtained should not be greater than 100")
	@Column(name="marksobtained")
	private Integer marksObtained;
	
	@NotEmpty(message="Goals should not be empty")
	@Column(name="goals")
	private String goals;
	
	@Email(message="Email should be valid")
	@NotBlank(message="Email should not be blank")
	@Column(name="emailid")
	private String emailId;
	
	
	@NotNull(message="ScheduledProgramId cannot be null")
	@Positive(message="ScheduledProgramId should be positive")
	@Column(name="scheduledprogramid")
	private Integer scheduledProgramId;
	
	@NotBlank(message="programName should not be blank ")
	@Size(min = 2, message = "Atleast 2 characters required")
	@Column(name="programname")
	private String programName;
	
	
	@NotBlank(message="Status should not be blank")
	@Column(name="status")
	private String status;
	
	@Future
	@Column(name="dateofinterview")
	private LocalDate dateOfInterview;

	
	public ApplicantEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApplicantEntity(Integer applicantid, String applicantname, LocalDate dateOfBirth, String highestQualification,
			Integer marksObtained, String goals, String emailId, Integer scheduledProgramId, String programName,
			String status, LocalDate dateOfInterview) {
		super();
		this.applicantid = applicantid;
		this.applicantname = applicantname;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.goals = goals;
		this.emailId = emailId;
		this.scheduledProgramId = scheduledProgramId;
		this.programName = programName;
		this.status = status;
		this.dateOfInterview = dateOfInterview;
	}


	public Integer getApplicantid() {
		return applicantid;
	}


	public void setApplicantid(Integer applicantid) {
		this.applicantid = applicantid;
	}


	public String getApplicantname() {
		return applicantname;
	}


	public void setApplicantname(String applicantname) {
		this.applicantname = applicantname;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getHighestQualification() {
		return highestQualification;
	}


	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}


	public Integer getMarksObtained() {
		return marksObtained;
	}


	public void setMarksObtained(Integer marksObtained) {
		this.marksObtained = marksObtained;
	}


	public String getGoals() {
		return goals;
	}


	public void setGoals(String goals) {
		this.goals = goals;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Integer getScheduledProgramId() {
		return scheduledProgramId;
	}


	public void setScheduledProgramId(Integer scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}


	public String getProgramName() {
		return programName;
	}


	public void setProgramName(String programName) {
		this.programName = programName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDate getDateOfInterview() {
		return dateOfInterview;
	}


	public void setDateOfInterview(LocalDate dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}


	@Override
	public String toString() {
		return "Applicant [applicantid=" + applicantid + ", applicantname=" + applicantname + ", dateOfBirth="
				+ dateOfBirth + ", highestQualification=" + highestQualification + ", marksObtained=" + marksObtained
				+ ", goals=" + goals + ", emailId=" + emailId + ", scheduledProgramId=" + scheduledProgramId
				+ ", programName=" + programName + ", status=" + status + ", dateOfInterview=" + dateOfInterview + "]";
	}


}



