package com.theatmo.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.theatmo.exception.ConnectionNotFoundException;

/**
 * Used to get the database connection 
 * 
 * @author DeviDurgaA
 */
public class DBConnection {

    /**
     * Determines the connection for database 
     *    
     * @return connection
     */
    public Connection getConnection() {

        final Properties property = PropertiesFile.readProperties();
        final String url = property.getProperty("karaf.jdbc.url");
        final String user = property.getProperty("karaf.jdbc.user");
        final String password = property.getProperty("karaf.jdbc.password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(url, user, password);

            return connection;
        } catch (Exception exception) {
            throw new ConnectionNotFoundException("Connection failed");
        }
     }

}
