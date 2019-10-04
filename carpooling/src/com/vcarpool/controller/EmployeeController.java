package com.vcarpool.controller;

import java.sql.SQLException;


import com.vcarpool.helper.FactoryEmployeeDB;
import com.vcarpool.model.RegisterEmployeeModel;
import com.vcarpool.service.EmployeeService;
import com.vcarpool.validation.EmployeeModelValidator;
import com.vcarpool.view.EmployeeView;

public class EmployeeController {
	
	
	private EmployeeService employeeService;
	EmployeeView employeeView=new EmployeeView();
	
	public EmployeeController() {
		this.employeeService=
				FactoryEmployeeDB.createEmployeesService();
	}

public void handleRegisterEmployee(RegisterEmployeeModel model) throws ClassNotFoundException, SQLException{
		
		EmployeeModelValidator validator=new EmployeeModelValidator();
				
		if(validator.validate(model)) {
		
		String outcome=employeeService.registerEmployee(model);
		if(outcome.contentEquals("success")) {
			employeeView.showRegistrationSuccess(model);	
		}else {
			employeeView.showRegistrationFailure(model);
		}
	}else {
		employeeView.validationFailedError(); 
	}
	} 


}
