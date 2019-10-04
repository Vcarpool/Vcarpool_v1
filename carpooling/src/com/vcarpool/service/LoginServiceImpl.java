package com.vcarpool.service;

import java.sql.SQLException;

import com.vcarpool.dao.LoginDAO;
import com.vcarpool.helper.FactoryEmployeeDB;
import com.vcarpool.model.LoginModel;
import com.vcarpool.view.EmployeeView;

public class LoginServiceImpl  implements LoginService{
	
	LoginDAO loginDAO=null;

	 
	 public LoginServiceImpl() {
			this.loginDAO=FactoryEmployeeDB.createLoginDAO();
		}

	
	 
	 @Override
	public String userAuthenticationService(LoginModel loginModel)throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		
		String result="fail";
			boolean userValid=loginDAO.userAuth(loginModel.getEmployeeId(),loginModel.getPassword());
			if(userValid){
				result="success";}
			else{
				EmployeeView employeesView=new EmployeeView();
				employeesView.showLoginFailure();}
		
		return result;
	}
}
