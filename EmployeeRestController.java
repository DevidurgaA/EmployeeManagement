package com.theatmo.controller;

import com.theatmo.model.Employee;

import java.util.List;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *    Provides interface for EmployeeRestControllerImpl class
 * </p>
 */
public interface EmployeeRestController {

    Map addEmployee(final Employee employee);

    List getEmployees(final int page, final int limit);

    Map deleteEmployee(final Integer employeeId);

    Map updateEmployeeDetails(final Employee employee);

    List selectEmployee(final Integer employeeId);
}
