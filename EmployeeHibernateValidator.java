package com.theatmo.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * <P>
 *     Provides validation using hibernate validation
 * </P>
 */
public class EmployeeHibernateValidator {

    private static final ValidatorFactory FACTORY = Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
    private static final Validator VALIDATOR = FACTORY.getValidator();

    /**
     * <p>
     *     Validates the employee for updating employeedetails and
     *     adding the employeedetails
     * </p>
     *
     * @param employee
     * @return list
     */
    public static List validateEmployee(final Employee employee) {
        Set<ConstraintViolation<Employee>> constraintViolations = VALIDATOR.validate(employee, AddEmployee.class, UpdateEmployee.class);
        List list = new ArrayList();

        for (ConstraintViolation<Employee> violation : constraintViolations) {
            list.add(violation.getMessage());
        }
        return list;
    }

    /**
     * <p>
     *     Validates the employeeID for searching employeedetails and
     *     deleting the employeedetails
     * </p>
     *
     * @param employeeId
     * @return list
     */
    public static List validateId(final Integer employeeId) {
        Employee employee =  new Employee();

        employee.setEmployeeId(employeeId);
        Set<ConstraintViolation<Employee>> constraintViolations = VALIDATOR.validate(employee, SearchEmployee.class, DeleteEmployee.class);
        List list = new ArrayList();

        for (ConstraintViolation<Employee> violation : constraintViolations) {
            list.add(violation.getMessage());
        }
        return list;
    }
}
