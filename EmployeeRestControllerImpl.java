package com.theatmo.controller;

import com.theatmo.model.Employee;
import com.theatmo.model.EmployeeHibernateValidator;
import com.theatmo.service.EmployeeRest;
import com.theatmo.service.EmployeeRestImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

 /**
  * <p>
  *   Provides the implementation for the EmployeeRestController for
  *    the rest implementation using annotations by fetching the
  *    data from the super class methods of EmployeeController
  * </p>
  *
  * @author DevidurgaA
  *
  */
@Path("/")
public class EmployeeRestControllerImpl implements EmployeeRestController  {

    private static final EmployeeRest EMPLOYEE_REST = new EmployeeRestImpl();

    /**
     * <p>
     *    Adds the employee data by using the path("/add") by using the
     *    super class method of EmployeeController
     * </p>
     *
     * @param employee
     * @return employee
     */
    @Override
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Map addEmployee(@Valid final Employee employee) {
        List list = EmployeeHibernateValidator.validateEmployee(employee);

        if (!list.isEmpty()) {
            Map map = new HashMap();

            map.put("message", list);
            return map;
        }
        return EMPLOYEE_REST.addEmployee(employee);
    }

    /**
     * <p>
     *    Gets the employee data by using the path("/getemployee") by using the
     *    super class method of EmployeeController
     * </p>
     *
     * @param employee
     * @return employee
     */
    @Override
    @Path("/getemployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List getEmployees(@Valid @QueryParam("page") final int page, @DefaultValue("5") @QueryParam("limit") final int limit) {
        return EMPLOYEE_REST.getEmployees(page, limit);
    }

    /**
     * <p>
     *    Deletes the employee data by using the path(/{"employeeId"}) by using the
     *    super class method of EmployeeController
     * </p>
     *
     * @param employee
     * @return employee
     */
    @Override
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Map deleteEmployee(@Valid @QueryParam("employeeId") final Integer employeeId) {
        List list = EmployeeHibernateValidator.validateId(employeeId);

        if (!list.isEmpty()) {
            Map map = new HashMap();

            map.put("message", list);
            return map;
        }
        return EMPLOYEE_REST.deleteEmployee(employeeId);
    }

    /**
     * <p>
     *    Updates the employee data by using the path("/update") by using the
     *    super class method of EmployeeController
     * </p>
     *
     * @param employee
     * @return employee
     */
    @Override
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public Map updateEmployeeDetails(@Valid final Employee employee) {
        List list = EmployeeHibernateValidator.validateEmployee(employee);

        if (!list.isEmpty()) {
            Map map = new HashMap();

            map.put("message", list);
            return map;
        }
        return EMPLOYEE_REST.updateEmployeeDetails(employee);
    }

    /**
     * <p>
     *    Gets the employee data by using the employeeId as the input from the
     *    super class method of EmployeeController
     * </p>
     *
     * @param employeeId
     */
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List selectEmployee(@Valid @QueryParam("employeeId") final Integer employeeId) {
        List list = EmployeeHibernateValidator.validateId(employeeId);

        if (!list.isEmpty()) {
            List selecteId = new ArrayList();

            selecteId.add(list);
            return selecteId;
        }
        return EMPLOYEE_REST.selectEmployee(employeeId);
    }
}
