/*******************************************************************************************
 - File Name        : IProgramService
 - Author           : Yash Raj
 - Creation Date    : 12-06-2020
 - Description      :  This is Service interface for ProgramOfferedService
  ****************************************************************************************************/

package com.cg.uas.programoffered.service;

import java.util.List;

import com.cg.uas.programoffered.dto.Program;
import com.cg.uas.programoffered.exception.ProgramAlreadyExistsException;
import com.cg.uas.programoffered.exception.ProgramNotFoundException;

public interface IProgramService {

	
	public List<Program> getAllPrograms();

	public Program getProgramById(int id) throws ProgramNotFoundException;

	public Program addProgram(Program program) throws ProgramAlreadyExistsException;

	public Program updateProgram(Program program) throws ProgramNotFoundException;

	public String deleteProgramById(int id) throws ProgramNotFoundException;
}
