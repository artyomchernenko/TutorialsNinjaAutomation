package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
	
    public static String readProperty(String key) {
        String value = "";
        try (InputStream input = new FileInputStream("src/test/resources/data/configuration.properties")) {
            Properties prop = new Properties();
            // Load properties file
            prop.load(input);
            // Get the property value
            value = prop.getProperty(key);
        } catch (Exception e) {
            // Log the exception or print a meaningful error message
            System.err.println("Error reading the property: " + e.getMessage());
        }
        return value;
    }
}