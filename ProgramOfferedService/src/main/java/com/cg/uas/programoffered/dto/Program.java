/*******************************************************************************************
 - File Name        : Program
 - Author           : Yash Raj	
 - Creation Date    : 12-06-2020
 - Description      : This is an entity class to represent objects in Database of Program Offered. 
  ****************************************************************************************************/

package com.cg.uas.programoffered.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="programoffered")
public class Program {
	

	@Id
	@NotNull(message="Program Id is mandatory")
	@Min(value=1, message="Id can not be smaller than 1")
	@Max(value=999, message="Id can not more than 3 digit")
	private int programid;
	@NotBlank(message=" Program Name should be required")
	@Size(min = 2, max=10, message = " Program Name should be 2 to 10 characters long")
	private String programname;
	@Size(min=2, message="Description has atleast 2 characters ")
	@NotBlank(message="Description should not be blank  ")
	private String description;
	@NotBlank(message="eligibility is Mandatory")
	@Size(min=2, message="Eligibility has atleast 2 characters ")
	private String eligibility;
	@NotNull(message="Duration is required")
	@Max(value=5, message="duration year can not be greater than 5")
	@Positive(message="duration can not be negative or 0")
	private int duration;
	
	
	public Program() {
		super();
	}
	public Program(int programid, String programname, String description, String eligibility, int duration) {
		super();
		this.programid = programid;
		this.programname = programname;
		this.description = description;
		this.eligibility = eligibility;
		this.duration = duration;
	}
	public int getProgramid() {
		return programid;
	}
	public void setProgramid(int programid) {
		this.programid = programid;
	}
	
	public String getProgramname() {
		return programname;
	}
	public void setProgramname(String programname) {
		this.programname = programname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Program [programid=" + programid + ", programname=" + programname + ", description=" + description + ", eligibility="
				+ eligibility + ", duration=" + duration + "]";
	}

}
