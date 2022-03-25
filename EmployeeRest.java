package com.theatmo.service;

import java.util.List;
import java.util.Map;

import com.theatmo.model.Employee;

/**
 * Provides interface for the Rest
 */
public interface EmployeeRest {

    Map addEmployee(final Employee employee);

    List getEmployees(final int page, final int limit);

    Map deleteEmployee(final Integer employeeId);

    Map updateEmployeeDetails(final Employee employee);

    List selectEmployee(final Integer employeeId);

}
