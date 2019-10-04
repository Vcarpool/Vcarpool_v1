package com.vcarpool.view;

import com.vcarpool.model.RegisterEmployeeModel;

public class EmployeeView {

	private MainView mainView=new MainView();

public void showRegistrationSuccess(RegisterEmployeeModel model) {
		
		System.out.println("\n Registration successful for employee id=>"+model.getEmployeeId());
		mainView.mainMenu();
	}
	
	public void showRegistrationFailure(RegisterEmployeeModel model) {
		System.out.println("\n Registration unsuccessful for employee id=>"+model.getEmployeeId());
		mainView.mainMenu();
	}
	public void validationFailedError() {
		  System.out.println("Data validation failed!!");
	  }
	public void loginSuccess() {
		  System.out.println("login Successful");
	  }
	public void loginFailedError() {
		  System.out.println("login failed!!");
	  }
	public void showLoginFailure()
	{
		System.out.println("========!! Login failed -invalid credentials !!");
	}

}
