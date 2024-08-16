package com.coherentsolutions.java.webauto.section01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Base class for all Page Object classes.
 * It contains common elements and methods used across different pages.
 */
public abstract class PageBase {
    protected WebDriver driver;
    protected WebDriverWait waiter;

    /**
     * Constructor for PageBase.
     * Initializes the WebDriver and WebDriverWait instances.
     */
    public PageBase() {
        this.driver = DriverManager.getDriver();
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Gets the title of the current page.
     * @return The title of the page as a String.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Gets the current URL of the page.
     * @return The current URL as a String.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}