package com.theatmo.dao;

import java.util.Map;

import com.theatmo.model.Employee;

/**
 * Interface created for Employee database 
 */
public interface EmployeeDao {
    
    boolean addEmployee(final Employee employee);
    
    Map<Integer, Employee> viewEmployeeDetails();
    
    boolean deleteEmployee(final int employeeId);
    
    boolean updateEmployeeDetails(final Employee employee);
}
