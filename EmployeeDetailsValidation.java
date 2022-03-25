package com.theatmo.validation;

import java.time.LocalDate;

import com.theatmo.exception.InvalidInputException;

/**
 * <p>
 *    Gives the validation to the inputs obtained from the user
 * </p>
 */
public class EmployeeDetailsValidation {

	/**
	 * <p>
	 *    Checks the employee name as accepting only alphabets and returns the
	 *    validated input to the Employee Details class.
	 * </p>
	 * 
	 * @return employeeName
	 */
	public static boolean checkEmployeeName(final String employeeName) {
		return employeeName.matches("^([A-Za-z]+\\s)*[a-zA-Z]+$|^[a-zA-z]$") ? true : false;
	}

	/**
	 * <p>
	 *    Checks the contactNumber as accepting only numeric values as in the pattern
	 *    and returns the validated input to the Employee details class.
	 * </p>
	 * 
	 * @return contactNumber
	 */
	public static boolean checkContactNumber(final String contactNumber) {
		return contactNumber.matches("[6-9]{1}[0-9]{9}") ? true : false;
	}

	/**
	 * <p>
	 *    Checks the as accepting only numeric values as in the pattern and returns the
	 *    validated input to the Employee details class.
	 * </p>
	 * 
	 * @return salary
	 */
	public static boolean checkSalary(final String salary) {
		return salary.matches("[0-9]+([,.][0-9]{2,})?") ? true : false;
	}

	/**
	 * <p>
	 *    Validating employee joining date by checking day, month, year of default
	 *    calendar method. If any input other than predefined values are given, then
	 *    the method is called again to get desired input.
	 * </p>
	 * 
	 * @param dateOfBirth
	 * @return dateOfBirth
	 */
	public static boolean dateValidation(final String dateOfJoining) {

		try {
			final LocalDate inputDate = LocalDate.parse(dateOfJoining);
			final LocalDate currentDate = LocalDate.now();

			if (currentDate.plusDays(1).isAfter(inputDate)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			throw new InvalidInputException("Invalid Input!!!...");
		}
	}

	/**
	 * <p>
	 *    Checks the employee Id as accepting only numerical values and return the
	 *    validated input to the Employee details class.
	 * </p>
	 * 
	 * @param employeeId
	 * @return employeeId
	 */
	public static boolean employeeIdValidation(final String employeeId) {
		return employeeId.matches("[0-9]{1,}") ? true : false;
	}

	/**
	 * <p>
	 *    Checks the choice of the user as accepting only numerical values from 1-5 and
	 *    return the validated input to the Employee details class.
	 * </p>
	 * 
	 * @param choice
	 * @return choice
	 */
	public static boolean choiceValidation(final String choice) {
		return choice.matches("[1-6]") ? true : false;
	}
}
