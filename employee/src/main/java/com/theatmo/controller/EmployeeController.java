package com.theatmo.controller;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import com.theatmo.model.Employee;
import com.theatmo.service.EmployeeServiceImplVersion2;
import com.theatmo.validation.EmployeeDetailsValidation;

/**
 * <p>
 * This controller class is used for getting the request from main and gives it
 * to the service. The input data fetched in view are processed and then called
 * in employee main class.
 * </p>
 */
public class EmployeeController {
	public final static EmployeeServiceImplVersion2 EMPLOYEE_IMPL = new EmployeeServiceImplVersion2();

	/**
	 * <p>
	 * Adds the employee details by getting the inputs from the user and stores in
	 * the database.
	 * </p>
	 * 
	 * @param employee
	 */
	public boolean addEmployee(final Employee employee) {
		return EMPLOYEE_IMPL.addEmployee(employee);
	}

	/**
	 * <p>
	 * Shows the employee details that are available in the 
	 * </p>
	 * 
	 */
	public Map<Integer, Employee> viewEmployeeDetails() {
		return EMPLOYEE_IMPL.viewEmployeeDetails();
	}

	/**
	 * <p>
	 * Updates the employee details by getting the inputs from the user and stores in
	 * the database.
	 * </p>
	 * 
	 * @param employee
	 */
	public boolean updateEmployeeDetails(Employee employee) {
		return EMPLOYEE_IMPL.updateEmployeeDetails(employee);
	}

	/**
	 * <p>
	 * Deletes the employee details by getting the inputs from the user and stores in
	 * the database.
	 * </p>
	 * 
	 * @param employeeId
	 */
	public boolean deleteEmployee(int employeeId) {
		return EMPLOYEE_IMPL.deleteEmployee(employeeId);
	}

	/**
	 * <p>
	 * Checks the employee name by getting the user inputs
	 * <p>
	 * 
	 * @param employeeName
	 */
	public boolean checkEmployeeName(final String employeeName) {
		return EmployeeDetailsValidation.checkEmployeeName(employeeName);
	}
	
	/**
	 * <p>
	 * Checks the employee contact number by getting the user inputs
	 * <p>
	 * 
	 * @param contactNumber
	 */
	public boolean checkContactNumber(String contactNumber) {
		return EmployeeDetailsValidation.checkContactNumber(contactNumber);
	}

	/**
	 * <p>
	 * Checks the employeeId by getting the user inputs
	 * <p>
	 * 
	 * @param employeeId
	 */
	public boolean checkEmployeeId(String employeeId) {
		return EmployeeDetailsValidation.employeeIdValidation(employeeId);
	}

	/**
	 * <p>
	 * Checks the employee salary by getting the user inputs
	 * <p>
	 * 
	 * @param salary
	 */
	public boolean checkSalary(String salary) {
		return EmployeeDetailsValidation.checkSalary(salary);
	}

	/**
	 * <p>
	 * Checks the employee dateOfJoining by getting the user inputs
	 * <p>
	 * 
	 * @param dateOfJoining
	 */
	public static boolean dateValidation(String dateOfJoining) {
		return EmployeeDetailsValidation.dateValidation(dateOfJoining);
	}
	
	/**
	 * <p>
	 * Checks the user choice by getting the user inputs to select the choice
	 * <p>
	 * 
	 * @param userChoice
	 */
	public boolean choiceValidation(String userChoice) {
		return EmployeeDetailsValidation.choiceValidation(userChoice);
	}

	/**
	 * <p>
	 * Checks the employeeId by getting the user inputs to add the employee details
	 * <p>
	 * 
	 * @param employeeId
	 */
	public boolean employeeIdCorrect(final int employeeId) {
		return EmployeeServiceImplVersion2.employeeIdCorrect(employeeId);
	}

	/**
	 * <p>
	 * Checks the employeeId by getting the user inputs to update the employee details
	 * <p>
	 * 
	 * @param employeeId
	 */
	public boolean employeeIdCorrectUpdate(final int employeeId) {
		return EmployeeServiceImplVersion2.employeeIdCorrectUpdate(employeeId);
	}

	/**
	 * <p>
	 * Checks the user choice by getting the user inputs to select the choice
	 * <p>
	 *
	 * @param userChoice
	 */
	public boolean userChoiceValidation(final String userChoice) {
		return EmployeeServiceImplVersion2.validateUserChoice(userChoice);
	}

}
