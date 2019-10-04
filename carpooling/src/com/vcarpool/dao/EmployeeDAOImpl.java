package com.vcarpool.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;


import com.vcarpool.entities.Employees;
import com.vcarpool.integrate.ConnectionManager;

//import com.vcarpool.model.RegisterEmployeeModel;


public class EmployeeDAOImpl implements EmployeesDAO{
	
	
	public boolean storeEmployeeDetails(Employees employees) throws ClassNotFoundException, SQLException {
		Connection connection=ConnectionManager.openConnection();
		
		PreparedStatement statement=
				connection.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?)");
		statement.setInt(1,employees.getEmployeeId());
		statement.setString(2, employees.getFirstName());
		statement.setString(3, employees.getLastName());
		statement.setString(4, employees.getEmail());
		statement.setString(5, employees.getPhoneNumber());
		statement.setString(6,employees.getDesignation());
		statement.setString(7,employees.getEmployeeTier());
		statement.setString(8,employees.getGender());
		statement.setString(9, employees.getPassword());
				
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		
		if(rows>0)
			return true;
		else
	
		return false;
	
}

}