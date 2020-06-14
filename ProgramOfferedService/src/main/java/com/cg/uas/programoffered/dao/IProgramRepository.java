/*******************************************************************************************
 - File Name        : IProgramRepository
 - Author           : Yash Raj	
 - Creation Date    : 12-06-2020
 - Description      : This is a Repository Interface which defines operations for 
 					  Entity class  in Program Offered Service. 
  ****************************************************************************************************/

package com.cg.uas.programoffered.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.uas.programoffered.dto.Program;

@Repository
public interface IProgramRepository extends JpaRepository<Program, Integer>{

}
