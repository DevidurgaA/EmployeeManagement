package com.theatmo.controller;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.DefaultValue;

import javax.ws.rs.Produces;

import org.osgi.service.component.annotations.Component;

import com.theatmo.model.Employee;
import com.theatmo.service.EmployeeServiceImplVersion2;

/**
 * <p>
 * Provides the implementation for the EmployeeRestController for
 * the rest implementation using annotations by fetching the
 * data from the super class methods of EmployeeController
 * </p>
 */
@Path("/")
public class EmployeeRestControllerImpl extends EmployeeController implements EmployeeRestController {

    /**
     * <p>
     * Adds the employee data by using the path("/add") by using the
     * super class method of EmployeeController
     * </p>
     *
     * @param employee
     * @return employee
     */
    @Override
    @Path("/add")
    @Consumes("application/json")
    @POST
    public boolean addEmployee(final Employee employee) {
        return super.addEmployee(employee);
    }

    /**
     * <p>
     * Gets the employee data by using the path("/getallemployee") by using the
     * super class method of EmployeeController
     * </p>
     *
     * @param employee
     * @return employee
     */
    @Override
    @Path("/getallemployee")
    @Produces("application/json")
    @GET
    public List<Employee> getAllEmployee(@QueryParam("page") int page, @DefaultValue("5") @QueryParam("limit") int limit) {
        List<Employee> employeeList = new ArrayList<>(super.viewEmployeeDetails().values());
        int start = 0, end = 0;

        if (page > 0 && limit >= 0) {
            start = (page - 1) * limit;
            end = limit * page;
        }
        if (start < employeeList.size() && end < employeeList.size()){
            return employeeList.subList(start, end);
        }
        else if (start < employeeList.size()){
            return employeeList.subList(start, employeeList.size());
        }
        return null;
    }

    /**
     * <p>
     * Updates the employee data by using the path("/update") by using the
     * super class method of EmployeeController
     * </p>
     *
     * @param employee
     * @return employee
     */
    @Override
    @Path("/update")
    @Consumes("application/json")
    @PUT
    public boolean updateEmployeeDetails(final Employee employee) {
        return super.updateEmployeeDetails(employee);
    }

    /**
     * <p>
     * Deletes the employee data by using the path(/{"employeeId"}) by using the
     * super class method of EmployeeController
     * </p>
     *
     * @param employee
     * @return employee
     */
    @Override
    @Path("/{employeeId}")
    @DELETE
    public boolean deleteEmployee(@PathParam("employeeId") final int employeeId) {
        return super.deleteEmployee(employeeId);
    }

}