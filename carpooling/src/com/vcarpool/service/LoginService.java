package com.vcarpool.service;

import java.sql.SQLException;

import com.vcarpool.model.LoginModel;

public interface LoginService {
	
	public String userAuthenticationService(LoginModel loginModel)throws ClassNotFoundException,SQLException;
	

}
