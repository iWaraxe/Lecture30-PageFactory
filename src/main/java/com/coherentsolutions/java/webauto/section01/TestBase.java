package com.coherentsolutions.java.webauto.section01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Base class for all test classes.
 * It contains common setup and teardown methods for tests.
 */
public class TestBase {
    protected HomePage homePage;

    /**
     * Setup method that runs before each test method.
     * Initializes the WebDriver and navigates to the home page.
     */
    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver().get(ConfigurationManager.getBaseUrl());
        homePage = new HomePage();
    }

    /**
     * Teardown method that runs after each test method.
     * Closes the WebDriver and clears any resources.
     */
    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}