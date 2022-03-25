package com.theatmo.dao;

import java.sql.PreparedStatement;
import java.util.LinkedHashMap;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;

import java.util.Map;

import com.theatmo.databaseconnection.DBConnection;
import com.theatmo.exception.ConnectionNotFoundException;
import com.theatmo.model.Employee;

/**
 * <p>
 *    Database connectivity to store the values
 * </p>
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private static final DBConnection DB_CONNECTION = new DBConnection();

    /**
     * <p>
     *     Stores the data of employees in database
     * </p>
     *
     * @param employee
     */
    public boolean addEmployee(final Employee employee) {
        final String query = "INSERT INTO employeedata (employeeId, employeeName, employeeSalary, employeeContactNumber, employeeJoiningDate, isActive) values (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getSalary());
            preparedStatement.setString(4, employee.getContactNumber());
            preparedStatement.setDate(5, employee.getDateOfJoining());
            preparedStatement.setBoolean(6, true);

            return preparedStatement.executeUpdate() > 0;
        } catch (Exception exception) {
            throw new ConnectionNotFoundException("Connection Error!!!...");
        }
    }

    /**
     * <p>
     *     Shows the list of data in the database
     * </p>
     *
     * @return EMPLOYEE DETAILS
     */
    public Map<Integer, Employee> viewEmployeeDetails() {
        final Map<Integer, Employee> employeeDetails = new LinkedHashMap<>();
        final String query = "SELECT employeeId, employeeName, employeeSalary, employeeContactNumber, employeeJoiningDate FROM employeedata where isActive = true";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                final int employeeId = resultSet.getInt(1);
                final String employeeName = resultSet.getString(2);
                final String employeeSalary = resultSet.getString(3);
                final String employeeContactNumber = resultSet.getString(4);
                final Date employeeJoiningDate = resultSet.getDate(5);
                final Employee employee = new Employee(employeeId, employeeName, employeeSalary, employeeContactNumber, employeeJoiningDate);

                employeeDetails.put(employeeId, employee);
            }
        } catch (Exception exception) {
            throw new ConnectionNotFoundException("Connection Error!!!...");
        }
        return employeeDetails;
    }

    /**
     * <p>
     *     Deletes the employee details by checking the employeeId
     * </p>
     *
     * @param employeeId
     */
    public boolean deleteEmployee(final int employeeId) {
        final String query = "UPDATE employeedata set isActive = false where employeeId = ? ";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, employeeId);

            return preparedStatement.executeUpdate() > 0;
        } catch (Exception exception) {
            throw new ConnectionNotFoundException("Connection Error!!!...");
        }
    }

    /**
     * <p>
     *     Selects the employee details by checking the employeeId
     * </p>
     *
     * @param employeeId
     */
    public Employee selectEmployee(final int employeeId) {
        Employee employee = null;
        final String query = "Select employeeId, employeeName, employeeSalary, employeeContactNumber, employeeJoiningDate FROM employeedata where employeeId = ?";

        try (final Connection connection = DB_CONNECTION.getConnection();
             final PreparedStatement statement = connection.prepareStatement(query);) {
            statement.setInt(1, employeeId);

            try (ResultSet resultset = statement.executeQuery();) {

                while (resultset.next()) {
                    final String employeeName = resultset.getString(2);
                    final String employeeSalary = resultset.getString(3);
                    final String employeeContactNumber = resultset.getString(4);
                    final Date employeeJoiningDate = resultset.getDate(5);
                    employee = new Employee(employeeId, employeeName, employeeSalary, employeeContactNumber, employeeJoiningDate);
                }
            }
        } catch (Exception exception) {
            throw new ConnectionNotFoundException("Connection Error!!!...");
        }
        return employee;
    }

    /**
     * <p>
     *     Updates the employee details as per the user's choice
     * </p>
     *
     * @param employee
     */
    public boolean updateEmployeeDetails(final Employee employee) {
        final StringBuffer updateQuery = new StringBuffer();
        String query = updateQuery.append("UPDATE employeedata SET ").toString();
        boolean hasNextColumn = false;
        int name = 1, salary = 1, date = 1, number = 1, id = 1, count = 0;

        try (Connection connection = DB_CONNECTION.getConnection();) {

            if (employee.getEmployeeName() != null) {
                query = updateQuery.append("employeeName = ?").toString();
                hasNextColumn = true;
                count += 1;
            }

            if (employee.getSalary() != null) {

                if (hasNextColumn) {
                    query = updateQuery.append(",").toString();
                    salary = count + 1;
                }
                query = updateQuery.append("employeeSalary = ?").toString();
                hasNextColumn = true;
                count += 1;
            }

            if (employee.getContactNumber() != null) {

                if (hasNextColumn) {
                    query = updateQuery.append(",").toString();
                    number = count + 1;
                }
                query = updateQuery.append("employeeContactNumber = ?").toString();
                hasNextColumn = true;
                count += 1;
            }

            if (employee.getDateOfJoining() != null) {

                if (hasNextColumn) {
                    query = updateQuery.append(",").toString();
                    date = count + 1;
                }
                query = updateQuery.append("employeeJoiningDate = ?").toString();
                hasNextColumn = true;
                count += 1;
            }
            query = updateQuery.append("WHERE employeeId = ?").toString();
            id = count + 1;
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            if (employee.getEmployeeName() != null) {
                preparedStatement.setString(name, employee.getEmployeeName());
            }

            if (employee.getSalary() != null) {
                preparedStatement.setString(salary, employee.getSalary());
            }

            if (employee.getContactNumber() != null) {
                preparedStatement.setString(number, employee.getContactNumber());
            }

            if (employee.getDateOfJoining() != null) {
                preparedStatement.setDate(date, employee.getDateOfJoining());
            }
            preparedStatement.setInt(id, employee.getEmployeeId());

            return preparedStatement.executeUpdate() > 0;
        } catch (Exception exception) {
            throw new ConnectionNotFoundException("Connection Error!!!...");
        }
    }
}
