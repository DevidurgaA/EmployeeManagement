package com.theatmo.service;

import java.util.Map;

import com.theatmo.dao.EmployeeDao;
import com.theatmo.dao.EmployeeDaoImpl;
import com.theatmo.exception.DataNotFoundException;
import com.theatmo.exception.IdAlreadyExistsException;
import com.theatmo.exception.IdNotFoundException;
import com.theatmo.model.Employee;

/**
 * <p>
 *    Implements the EmployeeDB interface
 * </p>
 */
public class EmployeeServiceImplVersion2 implements EmployeeDao {

    private static final EmployeeDaoImpl EMPLOYEE_DAO = new EmployeeDaoImpl();

    /**
     * <p>
     *    Adds the employee details to the database
     * </p>
     *
     * @param employee
     */
    public boolean addEmployee(final Employee employee) {

        if (EMPLOYEE_DAO.viewEmployeeDetails().containsKey(employee.getEmployeeId())) {
            throw new IdAlreadyExistsException("Employee Id Already Exists!!!...");
        } else {
            return EMPLOYEE_DAO.addEmployee(employee);
        }
    }

    /**
     * <p>
     *    Shows all the employee details from the database
     * </p>
     */
    public Map<Integer, Employee> viewEmployeeDetails() {

        if (EMPLOYEE_DAO.viewEmployeeDetails().isEmpty()) {
            throw new DataNotFoundException("Data doesnot exists!!!...");
        }
        return EMPLOYEE_DAO.viewEmployeeDetails();
    }

    /**
     * <p>
     *    Deletes the employee details from the database
     * </p>
     *
     * @param employeeId
     */
    public boolean deleteEmployee(final int employeeId) {

        if (EMPLOYEE_DAO.deleteEmployee(employeeId)) {
            return true;
        } else {
            throw new IdNotFoundException("Employee Id Not Found!!!...");
        }
    }

    /**
     * <p>
     *    Updates the employee details from the database
     * </p>
     *
     * @param employeeId
     */
    public boolean updateEmployeeDetails(final Employee employee) {
        boolean isUpdated = EMPLOYEE_DAO.updateEmployeeDetails(employee);

        if (isUpdated) {
            return true;
        } else {
            throw new IdNotFoundException("Employee Id Not Found!!!...");
        }
    }

    /**
     * <p>
     *    Selects the employee details as per the input
     *    given by the user
     * </p>
     *
     * @param employeeId
     */
    public Employee selectEmployee(final int employeeId) {

        if (EMPLOYEE_DAO.viewEmployeeDetails().containsKey(employeeId)) {
            return EMPLOYEE_DAO.selectEmployee(employeeId);
        } else {
            throw new DataNotFoundException("Data doesnot exists!!!...");
        }
    }

    /**
     * <p>
     *    Checks the employeeId whether contained in the database
     *    and adds if not present
     * </p>
     *
     * @param employeeId
     */
    public static boolean employeeIdCorrect(final int employeeId) {

        if (!EMPLOYEE_DAO.viewEmployeeDetails().containsKey(employeeId)) {
            return true;
        }
        throw new IdAlreadyExistsException("Employee Id Already Exists!!!...");
    }

    /**
     * <p>
     *    Checks the employeeId whether contained in the database
     *    to update in the database
     * </p>
     *
     * @param employeeId
     */
    public static boolean employeeIdCorrectUpdate(final int employeeId) {

        if (EMPLOYEE_DAO.viewEmployeeDetails().containsKey(employeeId)) {
            return true;
        }
        throw new IdNotFoundException("Employee Id Not Found!!!...");
    }

    /**
     * <p>
     *    Checks the user choice to update the details to
     *    the employee database
     * </p>
     *
     * @param userChoice
     */
    public static boolean validateUserChoice(final String userChoice) {
        return (userChoice.matches("(yes|no) |(YES|No)")) ? true : false;
    }

    /**
     * <p>
     *    Checks the employeeId which is available and return the validated input to
     *    the Employee details class.
     * </p>
     *
     * @param employeeId
     * @return employeeId
     */
    public boolean checkEmployeeId(final String employeeId) {
        int employee = Integer.parseInt(employeeId);

        return (EMPLOYEE_DAO.viewEmployeeDetails().containsKey(employee)) ? true : false;
    }
}

