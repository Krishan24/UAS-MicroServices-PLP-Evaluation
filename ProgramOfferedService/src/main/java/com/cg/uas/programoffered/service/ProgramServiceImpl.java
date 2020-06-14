/*******************************************************************************************
 - File Name        : ProgramServiceImpl
 - Author           : Yash Raj
 - Creation Date    : 12-06-2020
 - Description      : This is Service implementation class of ProgramService 
  ****************************************************************************************************/

package com.cg.uas.programoffered.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.uas.programoffered.dao.IProgramRepository;
import com.cg.uas.programoffered.dto.Program;
import com.cg.uas.programoffered.exception.ProgramAlreadyExistsException;
import com.cg.uas.programoffered.exception.ProgramNotFoundException;

@Service
public class ProgramServiceImpl implements IProgramService {
	
	@Autowired
	private IProgramRepository repo;


	/****************************************************************************************************************************
	 - Method Name      : getAllPrograms
	 - Return type      : List<Program> 
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : fetching All the Program information from the database.
	  ****************************************************************************************************************************/ 
	@Override
	public List<Program> getAllPrograms() {

		return repo.findAll();
	}


	/****************************************************************************************************************************
	 - Method Name      : getProgramById
	 - Return type      : ResponseEntity<Program> 
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : fetching the Program information on basis of id from the database.
	  ****************************************************************************************************************************/ 
	@Override
	public Program getProgramById(int id) throws ProgramNotFoundException {
		return repo.findById(id).orElseThrow(() -> new ProgramNotFoundException());
	}

	/****************************************************************************************************************************
	 - Method Name      : addProgram
	 - Return type      : ResponseEntity<Program> 
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : Add program to the database.
	  ****************************************************************************************************************************/ 
	
	@Override
	public Program addProgram(Program program) throws ProgramAlreadyExistsException {
		if (repo.existsById(program.getProgramid()))
			throw new ProgramAlreadyExistsException();
		else
			return repo.saveAndFlush(program);
	}

	/****************************************************************************************************************************
	 - Method Name      : updateProgramById
	 - Return type      : ResponseEntity<Program>
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : Update program information to the database.
	  ****************************************************************************************************************************/
	@Override
	public Program updateProgram(Program program) throws ProgramNotFoundException {
		if (!repo.existsById(program.getProgramid()))
			throw new ProgramNotFoundException();
		else
			return repo.save(program);
	}

	/****************************************************************************************************************************
	 - Method Name      : deleteProgram
	 - Return type      : ResponseEntity<String>
	 - Author           : Yash Raj
	 - Creation Date    : 12-06-2020
	 - Description      : Delete the program basis of id from the database.
	  ****************************************************************************************************************************/
	
	@Override
	public String deleteProgramById(int id) throws ProgramNotFoundException {
		if (repo.existsById(id)) {
			repo.findById(id).orElse(null);
			
			repo.deleteById(id);
			return "Deleted Successfully";
		} else {
			throw new ProgramNotFoundException();
		}
	}

}
