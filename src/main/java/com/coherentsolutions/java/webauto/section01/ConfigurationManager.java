package com.coherentsolutions.java.webauto.section01;

import java.io.InputStream;
import java.util.Properties;

/**
 * Manages configuration properties for the tests.
 */
public class ConfigurationManager {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigurationManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the base URL for the application under test.
     * @return The base URL as a String.
     */
    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    // Add other configuration getters as needed
}