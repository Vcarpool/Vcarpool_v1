package com.vcarpool.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.SQLException;
import java.util.Scanner;

import com.vcarpool.controller.EmployeeController;
import com.vcarpool.controller.FrontController;
//import com.vcarpool.controller.FrontController;
import com.vcarpool.exception.ValidationException;
import com.vcarpool.model.RegisterEmployeeModel;
import com.vcarpool.validation.EmployeeModelValidator;

public class MainView {


//main menu
	public void mainMenu() {
		System.out.println("\n");
		System.out.println("\t \t ========Main Menu========");
		System.out.println("=>1. Admin ");
		//select employee
		System.out.println("=>2. Employee ");
		System.out.println("=>3. Exit");
		try(Scanner scanner=new Scanner(System.in);){

			System.out.print("\nEnter Choice:"); 
			int option=scanner.nextInt(); 

			switch(option) {
			
			case 1:viewAdminMainMenu();
			break;
			//switches to case 2
			case 2:viewEmployeeMainMenu(); 
			break;
			case 3: mainMenu();
			default:System.out.println("!ERROR[SELECT APPROPRIATE OPTION]");
			mainMenu();

			}

		}catch(Exception e) {

			System.out.println("!ERROR[SELECT APPROPRIATE OPTION]");
		}

	}

	private void viewAdminMainMenu() {
	// TODO Auto-generated method stub
	
}

	
	//enters into employee menu
	public void viewEmployeeMainMenu() {

		try(
				Scanner scanner=new Scanner(System.in);
				){
			System.out.println("1. login ");
			//select option 2
			System.out.println("2. Registration ");
			System.out.println("3. Main Menu");

			System.out.print("Enter choice:");
			int option=scanner.nextInt();

			switch(option) {

			case 1:loginEmployee();
			break;
			//switches to register employeeform
			case 2:registerEmployeeForm();
			break;

			case 3:
			default:System.out.println("!ERROR[SELECT APPROPRIATE OPTION]");
			viewEmployeeMainMenu();

			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	private void loginEmployee() throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub
		try(
//				InputStreamReader reader=
//				new InputStreamReader(System.in);
//					BufferedReader buffer=new BufferedReader(reader);
				Scanner sc=new Scanner(System.in);
					
		     ){
			
			System.out.println("Enter EmployeeId:");
//			int employeeId=Integer.parseInt(buffer.readLine());
			int employeeId=sc.nextInt();
			System.out.println("Enter Password:");
//			String password=buffer.readLine().trim();
			String password=sc.next();
			FrontController controller=new FrontController();
			controller.userAuthentication(employeeId, password);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void employeeMenu() {
		
	System.out.print("Login Successful");
	mainMenu();


	}
	
	//comes to register form and  asks details
	public void registerEmployeeForm() {

		try(Scanner scanner=new Scanner(System.in);)
		{			
			System.out.print("Employee  Id:");
			int employeeId=scanner.nextInt();
			EmployeeModelValidator validator=new EmployeeModelValidator();
			System.out.print("First Name:"); 
			String firstName=scanner.next();

			boolean validfirstName=validator.validString(firstName);
			if(!validfirstName)
				try {
					throw new ValidationException("[!ERROR:Invalid First Name]");
				}catch(ValidationException e) {
					System.out.println(e.getMessage());
					mainMenu(); 
				}


			System.out.print("Last Name:");
			String lastName=scanner.next();

			boolean validLastName=validator.validString(lastName);
			if(!validLastName)
				try {
					throw new ValidationException("[!ERROR:Invalid Last Name]");
				}catch(ValidationException e) {
					System.out.println(e.getMessage());
					mainMenu();
				}


			System.out.print("Email:");
			String email=scanner.next();

			boolean validemail=validator.validEmail(email);
			if(!validemail)
				try {
					throw new ValidationException("!ERROR:Invalid Email");
				}catch(ValidationException e) {
					System.out.println(e.getMessage());
					mainMenu();
				}
			System.out.print("PhoneNumber:");
			String phoneNumber=scanner.next();
			System.out.print("Designation :");
			String designation=scanner.next();
			System.out.print("Employee_gender :");
			String gender= scanner.next();
			System.out.print("Employee_Tier :");
			String employeeTier=scanner.next();
			System.out.print("Password :");
			String password=scanner.next();
			
			//creates model object of employee register
			RegisterEmployeeModel model=new RegisterEmployeeModel();
			model.setEmployeeId(employeeId);
			model.setFirstName(firstName);
			model.setLastName(lastName);
			model.setEmail(email);
			model.setPhoneNumber(phoneNumber);
			model.setDesignation(designation);
			model.setEmployeeTier(employeeTier);
			model.setGender(gender);
			model.setPassword(password);
			EmployeeController controller=new EmployeeController();
			controller.handleRegisterEmployee(model);

			mainMenu();
		}catch(Exception e) {

		}	
	}

}
/*Name              Null     Type         
----------------- -------- ------------ 
EMPLOYEE_ID       NOT NULL NUMBER(10)   
FIRST_NAME        NOT NULL VARCHAR2(40) 
LAST_NAME         NOT NULL VARCHAR2(40) 
EMAIL                      VARCHAR2(40) 
PHONE_NUMBER               VARCHAR2(10) 
DESIGNATION                VARCHAR2(20) 
EMPLOYEE_TIER              NUMBER(5)    
EMPLOYEE_GENDER            VARCHAR2(40) 
EMPLOYEE_PASSWORD          VARCHAR2(40) */