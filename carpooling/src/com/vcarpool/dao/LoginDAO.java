package com.vcarpool.dao;

import java.sql.SQLException;

public interface LoginDAO {

	public boolean userAuth(int employeeId,String password)throws ClassNotFoundException,SQLException;

}
