package com.theatmo.databaseconnection;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

/**
 * <p>
 *     Provides the database connection by loading the congigurationPid
 * </p>
 */
@Component(immediate = true, configurationPid = "databaseconnection")
public class DataBaseProperty {

    /**
     * <p>
     *     Activates the database connection
     * </p>
     *
     * @param properties
     */
    @Activate
    public void activate(Map<String, String> properties) {
        DBConnection.setdatabaseConnection(properties);
    }
}
