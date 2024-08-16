package com.coherentsolutions.java.webauto.section01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Manages WebDriver instances for the tests.
 */
public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Gets the WebDriver instance for the current thread.
     * If no instance exists, it creates a new one.
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    /**
     * Quits the WebDriver instance for the current thread and removes it.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}