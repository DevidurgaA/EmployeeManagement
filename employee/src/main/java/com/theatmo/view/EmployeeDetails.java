package com.theatmo.view;

import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.theatmo.controller.EmployeeController;
import com.theatmo.exception.ConnectionNotFoundException;
import com.theatmo.exception.DataNotFoundException;
import com.theatmo.exception.IdAlreadyExistsException;
import com.theatmo.exception.IdNotFoundException;
import com.theatmo.exception.InvalidInputException;
import com.theatmo.model.Employee;
import com.theatmo.userinput.UserInputs;

import java.sql.Date;

/**
 * Used to obtain the input from the user
 * 
 * @author DeviDurga Arunachalam
 */
public class EmployeeDetails {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final Logger LOGGER = Logger.getLogger(EmployeeDetails.class);
	private static final EmployeeController EMPOLYEECONTROLLER = new EmployeeController();

	public void selectChoice() {
		int choice = 0;

		do {
			System.out.println(
					"\n\nEMPLOYEE MANAGEMENT SYSTEM\n1.Add Employee\n2.View EmployeeList\n3.Update Employee Details\n4.Delete Employee details\n5.Exit\n");
			choice = Integer.parseInt(getUserChoice());

			switch (choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				viewEmployeeDetails();
				break;
			case 3:
				updateEmployeeDetails();
				break;
			case 4:
				deleteEmployee();
				break;
			case 5:
				EmployeeDetails.SCANNER.close();
                System.exit(choice);
			}
		} while (choice < 5);
	}

	/**
	 * Used to get the user Id in the numerical values
	 * 
	 * @return employeeId
	 */
	public int getEmployeeId() {
		final String employeeId = (UserInputs.getString("Enter the EmployeeId:\n[Back To Main: $ ]"));
		final boolean isIdCorrect = EMPOLYEECONTROLLER.checkEmployeeId(employeeId);

		if ("$".equals(employeeId)) {
			selectChoice();
		}

		if (isIdCorrect) {
			return Integer.parseInt(employeeId);
		} else {
			LOGGER.warn("Invalid Input!!!... \tEnter Numerical Values from 0-9)");
			return getEmployeeId();
		}
	}

	/**
	 * <p>
	 * Used to get the user name. By calling the EmployeeDetailsValidation class to
	 * validate the input.
	 * </p>
	 * 
	 * @return employeeName
	 */
	public String getEmployeeName() {
		final String employeeName = (UserInputs.getString("Enter the EmployeeName :\n[Back To Main: $ ]"));
		final boolean isNameCorrect = EMPOLYEECONTROLLER.checkEmployeeName(employeeName);

		if ("$".equals(employeeName)) {
			selectChoice();
		}

		if (isNameCorrect) {
			return employeeName;
		} else {
			LOGGER.warn("Invalid Input!!!...\tEnter Valid Alphabets(a-z)");
			return getEmployeeName();
		}
	}

	/**
	 * <p>
	 * Used to get the contact number. By calling the EmployeeDetailsValidation
	 * class to validate the input.
	 * </p>
	 * 
	 * @return contactNumber
	 */
	public String getContactNumber() {
		final String contactNumber = (UserInputs.getString("Enter the Contact Number :\n[Back To Main: $ ]"));
		final boolean isNumberCorrect = EMPOLYEECONTROLLER.checkContactNumber(contactNumber);

		if ("$".equals(contactNumber)) {
			selectChoice();
		}

		if (isNumberCorrect) {
			return contactNumber;
		} else {
			LOGGER.warn("Invalid Input!!!...\tEnter Valid 10 Digit Number");
			return getContactNumber();
		}
	}

	/**
	 * <p>
	 * Used to get employee salary details. By calling the EmployeeDetailsValidation
	 * class to validate the input.
	 * </p>
	 * 
	 * @return salary
	 */
	public String getEmployeeSalary() {
		final String salary = (UserInputs.getString("Enter the Salary :\n[Back To Main: $ ]"));
		final boolean isSalaryCorrect = EMPOLYEECONTROLLER.checkSalary(salary);

		if ("$".equals(salary)) {
			selectChoice();
		}

		if (isSalaryCorrect) {
			return salary;
		} else {
			LOGGER.warn("Invalid Input!!!...\tEnter Numerical Values(0-9)");
			return getEmployeeSalary();
		}
	}

	/**
	 * <p>
	 * Used to get the user choice. By calling the EmployeeDetailsValidation class
	 * to validate the input.
	 * </p>
	 * 
	 * @return user choice
	 */
	public String getUserChoice() {
		final String userChoice = (UserInputs.getString("Enter the Choice:"));
		
		if (EMPOLYEECONTROLLER.choiceValidation(userChoice)) {
			return userChoice;
		} else {
			LOGGER.warn("Please Enter Valid Choice!!!...");
			return getUserChoice();
		}
	}

	/**
	 * <p>
	 * Used to get the date of birth of the employee By calling the
	 * EmployeeDetailsValidation class to validate the input
	 * </p>
	 * 
	 * @return dateOfJoining
	 */
	public Date getDateOfJoining() {
		final String dateOfJoining = (UserInputs.getString("Enter employee date of joining (YYYY-MM-dd) :\t[Back To Main: $ ]"));

		boolean isDateCorrect = false;

		if ("$".equals(dateOfJoining)) {
		    selectChoice();
		}

		try {
			isDateCorrect = EMPOLYEECONTROLLER.dateValidation(dateOfJoining);
		} catch (InvalidInputException exception) {
			System.out.println(exception);
		}

		if (isDateCorrect) {
			return Date.valueOf(dateOfJoining);
		} else {
			LOGGER.warn("Invalid Input!!!...");
			return getDateOfJoining();
		}
	}

	/**
	 * <p>
	 * Used to add employee details as including employeeId, name of the employee,
	 * salary details,contact number and date of joining of the employee and pass it
	 * to the controller.
	 * </p>
	 */
	public void addEmployee() {
		final int employeeId = getEmployeeId();

		try {
			EMPOLYEECONTROLLER.employeeIdCorrect(employeeId);
		} catch (IdAlreadyExistsException exception) {
			System.out.println(exception);
			addEmployee();
			selectChoice();
		}
		final String employeeName = getEmployeeName();
		final String salary = getEmployeeSalary();
		final String contactNumber = getContactNumber();
		final Date dateOfJoining = getDateOfJoining();
		final Employee employee = new Employee(employeeId, employeeName, salary, contactNumber, dateOfJoining);

		try {
			final boolean isAdded = EMPOLYEECONTROLLER.addEmployee(employee);

			if (isAdded) {
				System.out.println("Successfully Added");
			}
		} catch (ConnectionNotFoundException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Used to view the employee details
	 */
	public void viewEmployeeDetails() {

		try {
			Map<Integer, Employee> data = EMPOLYEECONTROLLER.viewEmployeeDetails();

			System.out.println(data);
		} catch (DataNotFoundException exception) {
			System.out.println(exception);
		} catch (ConnectionNotFoundException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * Used to delete the employee details by checking the employeeId
	 */
	public void deleteEmployee() {

		try {
			EMPOLYEECONTROLLER.deleteEmployee(getEmployeeId());
			System.out.println("Successfully Deleted");
		} catch (IdNotFoundException exception) {
			System.out.println(exception);
		} catch (ConnectionNotFoundException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * <p>
	 * Used to update the employee details by using iterator and employeeId for
	 * checking the availability of the details of the employee and then update
	 * employee details using switch case Implementation by user choice.
	 * </p>
	 */
	public void updateEmployeeDetails() {
		Employee employee = new Employee();
		int employeeId = getEmployeeId();

		try {
			EMPOLYEECONTROLLER.employeeIdCorrectUpdate(employeeId);
		} catch (IdNotFoundException exception) {
			System.out.println(exception);
			updateEmployeeDetails();
			selectChoice();
		}
		employee.setEmployeeId(employeeId);
		String updateInput;
		System.out.println("Update Changes To Employee Name ?\t yes or no");

		while (true) {
			updateInput = EmployeeDetails.SCANNER.next().trim();

			if (updateInput.equalsIgnoreCase("yes")) {
				employee.setEmployeeName(getEmployeeName());
				break;
			} else if (updateInput.equalsIgnoreCase("no")) {
				break;
			} else {
				LOGGER.warn("Enter Valid Input (yes or no)");
				continue;
			}
		}
		System.out.println("Update Changes To Employee Salary ?\t yes or no");

		while (true) {
			updateInput = EmployeeDetails.SCANNER.next().trim();

			if (updateInput.equalsIgnoreCase("yes")) {
				employee.setSalary(getEmployeeSalary());
				break;
			} else if (updateInput.equalsIgnoreCase("no")) {
				break;
			} else {
				LOGGER.warn("Enter Valid Input (yes or no)");
				continue;
			}
		}
		System.out.println("Update Changes To Employee Contact Number ?\t yes or no");

		while (true) {
			updateInput = EmployeeDetails.SCANNER.next().trim();

			if (updateInput.equalsIgnoreCase("yes")) {
				employee.setContactNumber(getContactNumber());
				break;
			} else if (updateInput.equalsIgnoreCase("no")) {
				break;
			} else {
				LOGGER.warn("Enter Valid Input (yes or no)");
				continue;
			}
		}
		System.out.println("Update Changes To Employee DateOfJoining ?\t yes or no");

		while (true) {
			updateInput = EmployeeDetails.SCANNER.next().trim();

			if (updateInput.equalsIgnoreCase("yes")) {
				employee.setDateOfJoining(getDateOfJoining());
				break;
			} else if (updateInput.equalsIgnoreCase("no")) {
				break;
			} else {
				LOGGER.warn("Enter Valid Input (yes or no)");
				continue;
			}
		}

		try {
			EMPOLYEECONTROLLER.updateEmployeeDetails(employee);
			System.out.println("Data Updated Successfully");
		} catch (IdNotFoundException exception) {
			System.out.println(exception);
		} catch (ConnectionNotFoundException exception) {
			System.out.println(exception);
		}
	}
}
