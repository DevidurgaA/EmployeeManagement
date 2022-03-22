package com.theatmo.controller;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.theatmo.databaseconnection.DBConnection;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.Map;
import com.theatmo.view.EmployeeDetails;

/**
 * Provides address for the rest implementation
 */
@Component(name = "databaseconnection", immediate = true)
public class RestService {

    private Server server;
    private final EmployeeDetails EMPLOYEE_DETAILS = new EmployeeDetails();

    @Activate
    public void activate(Map<String, String> properties) {

        try{
            DBConnection.databaseConnection(properties);
            JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();

            bean.setAddress("/employee");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new EmployeeRestControllerImpl());
            server = bean.create();

            EMPLOYEE_DETAILS.selectChoice();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Deactivate
    public void deactivate() {

        try{

            if (server != null) {
                server.destroy();
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }

    }
}
