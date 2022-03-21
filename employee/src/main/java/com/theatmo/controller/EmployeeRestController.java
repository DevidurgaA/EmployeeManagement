package com.theatmo.controller;

import com.theatmo.model.Employee;

import java.util.List;

/**
 * Provides interface for EmployeeRestControllerImpl class
 */
public interface EmployeeRestController {

 boolean addEmployee(final Employee employee);

 public List<Employee> getAllEmployee(final int page, final int limit);

 boolean deleteEmployee(final int employeeId);

 boolean updateEmployeeDetails(final Employee employee);

}
