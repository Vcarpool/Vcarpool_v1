package com.vcarpool.service;

import java.sql.SQLException;
//import java.util.List;
//
//import com.vcarpool.entities.Employees;
//import com.vcarpool.model.LoginModel;
import com.vcarpool.model.RegisterEmployeeModel;

public interface EmployeeService {
	
	public String registerEmployee(RegisterEmployeeModel model)throws ClassNotFoundException,SQLException;

}
