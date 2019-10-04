package com.vcarpool.controller;

import java.sql.SQLException;

import com.vcarpool.exception.UserException;
import com.vcarpool.helper.FactoryEmployeeDB;
import com.vcarpool.model.LoginModel;
import com.vcarpool.service.LoginService;
import com.vcarpool.view.ErrorView;
import com.vcarpool.view.MainView;

public class FrontController {

	private LoginService loginService;
	
	MainView mainView=new MainView();
	public FrontController() {
		this.loginService=
				FactoryEmployeeDB.createLoginService();
	}
	public void userAuthentication(int employeeId, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	
		LoginModel loginModel=new LoginModel();
		loginModel.setEmployeeId(employeeId);
		loginModel.setPassword(password);
		try {
			String result=loginService.userAuthenticationService(loginModel);
		if(result.contentEquals("success")) {
			MainView mainView=new MainView();
			mainView.employeeMenu();
		}
		else{
			ErrorView errorView=new ErrorView();
			errorView.authenticationError();
		}
			
	}
		catch(UserException e)
		{
			System.out.println("User Authentication failed.");
		}
		
		
		
	}

}
