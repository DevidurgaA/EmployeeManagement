package com.theatmo.service;

import com.theatmo.model.Employee;

import java.util.Map;

/**
 * Provides interface for EmployeeServiceImpl class
 */
public interface EmployeeServices {
    
    boolean addEmployee(final Employee employee);

	Map<Integer, Employee> viewEmployeeDetails();

	boolean updateEmployeeDetails(final Employee employee);

	boolean deleteEmployee(final int employeeId);
	
}
