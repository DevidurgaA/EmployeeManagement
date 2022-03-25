package com.theatmo.model;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

/**
 * Gives information about employee details.
 */
public class Employee {

    @NotNull(message = "Id Is Mandatory", groups = {AddEmployee.class, DeleteEmployee.class, UpdateEmployee.class, SearchEmployee.class})
    private Integer employeeId;

    @NotNull(message = "Name Is Mandatory", groups = {AddEmployee.class, UpdateEmployee.class})
    @Pattern(regexp = "^([A-Za-z]+\\s)*[a-zA-Z]+$|^[a-zA-z]$", message = "Please enter valid name", groups = {AddEmployee.class, UpdateEmployee.class})
    private String employeeName;

    @NotNull(message = "Salary Is Mandatory", groups = {AddEmployee.class, UpdateEmployee.class})
    @Pattern(regexp = "[0-9]+([,.][0-9]{2,})?", message = "Please enter valid salary credentials", groups = {AddEmployee.class, UpdateEmployee.class})
    private String salary;

    @NotNull(message = "Contact Number Is Mandatory", groups = {AddEmployee.class, UpdateEmployee.class})
    @Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Please enter valid contact number", groups = {AddEmployee.class, UpdateEmployee.class})
    private String contactNumber;

    @NotNull(message = "Date Is Mandatory", groups = {AddEmployee.class, UpdateEmployee.class})
    private Date dateOfJoining;

    public Employee() {
        super();
    }

    public Employee(Integer employeeId, String employeeName, String salary, String contactNumber, Date dateOfJoining) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.contactNumber = contactNumber;
        this.dateOfJoining = dateOfJoining;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getSalary() {
        return salary;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setDateOfJoining(Date dateOfBirth) {
        this.dateOfJoining = dateOfBirth;
    }

    public String toString() {
        return new StringBuffer().append("\n").append("EmployeeId:").append(employeeId).append("\n").append("Name:").append(employeeName).append("\n").append("Salary:").append(salary).
                append("\n").append("Contact Number:").append(contactNumber).append("\n").append("DateOfJoining:").append(dateOfJoining).append("\n").append("\n").toString();
    }
}
