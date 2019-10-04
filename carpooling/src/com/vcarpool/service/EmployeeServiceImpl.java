package com.vcarpool.service;

import java.sql.SQLException;
import com.vcarpool.dao.EmployeesDAO;
import com.vcarpool.entities.Employees;
import com.vcarpool.helper.FactoryEmployeeDB;
//import com.vcarpool.model.LoginModel;
import com.vcarpool.model.RegisterEmployeeModel;

public class EmployeeServiceImpl  implements EmployeeService{
	
	private EmployeesDAO employeesDAO;
	
		
	public EmployeeServiceImpl() {
		
		
		this.employeesDAO=FactoryEmployeeDB.createEmployeesDAO();
	}
	
	
	@Override
	public String registerEmployee(RegisterEmployeeModel model) {
		
		Employees employees=new Employees();
		employees.setEmployeeId(model.getEmployeeId());
		employees.setFirstName(model.getFirstName());
		employees.setLastName(model.getLastName());
		employees.setEmail(model.getEmail());
		employees.setPhoneNumber(model.getPhoneNumber());
		employees.setDesignation(model.getDesignation());
		employees.setEmployeeTier(model.getEmployeeTier());
		employees.setGender(model.getGender()); 
		employees.setPassword(model.getPassword());
		
		String result="fail";
		
		
		try {
			boolean stored=employeesDAO.storeEmployeeDetails(employees);
			if(stored)
				result="success";
		} catch (ClassNotFoundException| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("!ERROR[Registration failed because of internal issues...]");
		} 
			return result;
			
	}

	

}
