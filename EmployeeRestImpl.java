package com.theatmo.service;

import com.theatmo.dao.EmployeeDao;
import com.theatmo.dao.EmployeeDaoImpl;
import com.theatmo.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * <p>
 *     Provides the implemenation for the employee rest
 * </p>
 */
public class EmployeeRestImpl implements EmployeeRest {

    private static final EmployeeDao EMPLOYEEDAO = new EmployeeDaoImpl();

    /**
     * <p>
     *    Adds the employee data to the map
     * </p>
     *
     * @param employee
     * @return map
     */
    public Map addEmployee(final Employee employee) {
        final Map employeeMap = new HashMap<>();
        boolean isAdded = false;

        if (!EMPLOYEEDAO.viewEmployeeDetails().containsKey(employee.getEmployeeId())) {
            isAdded = EMPLOYEEDAO.addEmployee(employee);
        }
        employeeMap.put("Employee added successfully", isAdded);
        return employeeMap;
    }

    /**
     * <p>
     *   Gets all the employee details avaliable in the database
     * </p>
     *
     * @param page
     * @param limit
     * @return list
     */
    public List getEmployees(final int page, final int limit) {
        List<Employee> employeeList = new ArrayList<>(EMPLOYEEDAO.viewEmployeeDetails().values());
        int start = 0, end = 0;

        if (page > 0 && limit >= 0) {
            start = (page - 1) * limit;
            end = limit * page;
        }

        if (start < employeeList.size() && end < employeeList.size()) {
            return employeeList.subList(start, end);
        } else if (start < employeeList.size()) {
            return employeeList.subList(start, employeeList.size());
        } else {
            final List emptyList = new ArrayList();

            emptyList.add("Page is not available");
            return emptyList;
        }
    }

    /**
     * <p>
     *     Deletes the employee details by getting the employeeId
     *     as the input
     * </p>
     *
     * @param employeeId
     * @return map
     */
    public Map deleteEmployee(final Integer employeeId) {
        final Map employeeMap = new HashMap<>();
        final boolean isDeleted = EMPLOYEEDAO.deleteEmployee(employeeId);

        employeeMap.put("Employee deleted",isDeleted);
        return employeeMap;
    }

    /**
     * <p>
     *     Updates the employee details by getting the employeeId
     *     as the input from the user
     * </p>
     *
     * @param employee
     * @return map
     */
    public Map updateEmployeeDetails(final Employee employee) {
        final Map employeeMap = new HashMap<>();
        final boolean isUpdated = EMPLOYEEDAO.updateEmployeeDetails(employee);

        employeeMap.put("Employee updated",isUpdated);
        return employeeMap;
    }

    /**
     * <p>
     *     Gets the desired employee details by getting the
     *     employeeId as the input from the user
     * </p>
     *
     * @param employeeId
     * @return list
     */
    public List selectEmployee(final Integer employeeId) {
        final List employeeList = new ArrayList();
        final Employee selectEmployee = EMPLOYEEDAO.selectEmployee(employeeId);

        if (selectEmployee == null) {
            employeeList.add("Employee Id is not available");
        } else {
            employeeList.add(selectEmployee);
        }
        return employeeList;
    }
}
