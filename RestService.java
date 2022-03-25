package com.theatmo.controller;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import org.apache.log4j.Logger;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.theatmo.view.EmployeeDetails;
import com.theatmo.databaseconnection.DBConnection;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.Map;

/**
 * <p>
 *    Provides address for the rest implementation
 * </p>
 */
@Component(immediate = true)
public class RestService {

    private static Server server;
    private static final Logger LOGGER = Logger.getLogger(RestService.class);

    /**
     * <p>
     *    Provides bean to activate the server
     * </p>
     */
    @Activate
    public void activate() {
        try {
            final JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();

            bean.setAddress("/employee");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new EmployeeRestControllerImpl());
            server = bean.create();
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
    }

    /**
     * <p>
     *    Deactivates the created server
     * </p>
     */
    @Deactivate
    public void deactivate() {
        try {

            if (server != null) {
                server.destroy();
            }
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
    }
}