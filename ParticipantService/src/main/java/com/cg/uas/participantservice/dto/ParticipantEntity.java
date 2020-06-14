/**********************************************************************************************
 - File Name        : Participant Entity
 - Author           : SatyaPavani Chekka
 - Creation Date    : 11-06-2020
 - Description      : This is an entity class to represent objects in Database of Participant.  
  *********************************************************************************************/
package com.cg.uas.participantservice.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="participant")
public class ParticipantEntity {

	@Id
	@Positive(message ="Id should be positive")
    @Column(name="application_id")
	private int applicationId;
	
	@NotBlank(message="fullName is mandatory")
	@Size(min=3, message="Name should be atleast 3 characters")
	@Column(name="full_name")
	private String fullName;
	

	@Past
    @Column(name="date_ofbirth")
	private LocalDate dateOfBirth;
	
	@NotBlank(message="highestQualification is mandatory")
	@Size(min=2, message="Atleast 2 characters required")
    @Column(name="highest_qualification")
	private String highestQualification;
	
	
	@NotNull(message="marksObtained is mandatory")
	@Min(value=35, message="Marks Obtained should not be less than 35") 
	@Max(value=100, message="Marks Obtained should not be greater than 100")
	@Column(name="marks_obtained")
	private double marksObtained;
	
	@NotEmpty(message="goals are mandatory")
	@Column(name="goals")
	private String goals;
	
	@NotBlank(message="emailId is mandatory")
	@Email(message="Email Should not be Blank")
    @Column(name="email_id")
	private String emailId;
	
	@NotNull(message="scheduledProgramId cannot be null")
	@Positive(message="scheduledProgramId schould be postive")
	@Column(name="scheduled_programid")
	private Integer scheduledProgramId;
	
	@NotNull(message="programName is mandatory")
	@Size(min=2,message="Atleast 2 characters required")
	@Column(name="program_name")
	private String programName;
	
	@NotBlank(message="status is mandatory")
	@Size(min=2,max=10)
	@Column(name="status")
	private String status;
	

	@DateTimeFormat(pattern= "yyyy-mm-dd")
	@Future
    @Column(name="interview_date")
	private LocalDate interviewDate;
	
	public ParticipantEntity() {
		super();
	}
	public ParticipantEntity(int applicationId, String fullName, LocalDate dateOfBirth, String highestQualification,
			double marksObtained, String goals, String emailId, Integer scheduledProgramId, String programName, String status,
			LocalDate interviewDate) {
		super();
		this.applicationId = applicationId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.goals = goals;
		this.emailId = emailId;
		this.scheduledProgramId = scheduledProgramId;
		this.programName = programName;
		this.status = status;
		this.interviewDate = interviewDate;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public double getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(double marksObtained) {
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
	public LocalDate getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}
	public Integer getScheduledProgramId() {
		return scheduledProgramId;
	}
	public void setScheduledProgramId(Integer scheduledProgramId) {
		this.scheduledProgramId = scheduledProgramId;
	}
	
	
	
}
