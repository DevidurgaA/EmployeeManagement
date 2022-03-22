package com.theatmo.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import com.theatmo.exception.ConnectionNotFoundException;

/**
 * Used to get the database connection 
 * 
 * @author DeviDurgaA
 */
public class DBConnection {

    public static Map<String, String> databaseproperty;

    /**
     * Determines the connection for database 
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
     * Gets the properties for database
     *
     * @return connection
     */
     public static void databaseConnection(Map<String, String> properties) {
         databaseproperty = properties;
     }

}
