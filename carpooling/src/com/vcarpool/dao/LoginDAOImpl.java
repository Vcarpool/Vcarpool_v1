package com.vcarpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vcarpool.integrate.ConnectionManager;

public class LoginDAOImpl implements LoginDAO{

	@Override
	public boolean userAuth(int employeeId, String password)throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		String query = "select count(*) from employees where employee_id=? AND  employee_password=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, employeeId);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			if (rs.getInt(1)>0) 
				return true;
			else
				return false;
	}
	
	
}
