package com.vcarpool.dao;

import java.sql.SQLException;
//import java.util.List;

import com.vcarpool.entities.Employees;


public interface EmployeesDAO {
	
	
	public boolean storeEmployeeDetails(Employees employees)throws ClassNotFoundException, SQLException;
	
		
}
