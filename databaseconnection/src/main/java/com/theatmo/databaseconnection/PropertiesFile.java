package com.theatmo.databaseconnection;

import com.theatmo.exception.PropertiesFileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    public static Properties readProperties() {

        try {
            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream("C:/karaf/etc/system.properties");

            properties.load(inputStream);
            return properties;
        } catch (Exception exception) {
			throw new PropertiesFileNotFoundException("No such file found!!!");
       }
    }
}
