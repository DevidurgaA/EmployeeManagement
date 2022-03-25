package com.theatmo.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Map;

import com.theatmo.exception.ConnectionNotFoundException;

/**
 * <p>
 *     Used to get the database connection
 * </p>
 *
 * @author DeviDurgaA
 */
public class DBConnection {

    private static Map<String, String> databaseproperty;

    /**
     * <p>
     *     Determines the connection for database
     * </p>
     *
     * @return connection
     */
    public Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(databaseproperty.get("database.url"), databaseproperty.get("database.user"), databaseproperty.get("database.password"));

            return connection;
        } catch (Exception exception) {
            throw new ConnectionNotFoundException("Connection failed");
        }
     }

    /**
     * <p>
     *     Gets the properties for database
     * </p>
     *
     * @return properties
     */
     public static void setdatabaseConnection(Map<String, String> properties) {
         databaseproperty = properties;
     }
}
