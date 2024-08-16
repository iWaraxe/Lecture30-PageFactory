package com.coherentsolutions.java.webauto.section01;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object class representing the Home Page of the application.
 * It contains elements and methods specific to the home page.
 */
public class HomePage extends PageBase {

    @FindBy(linkText = "Sortable Data Tables")
    private WebElement dataTablesLink;

    @FindBy(linkText = "Dynamic Loading")
    private WebElement dynamicLoadingLink;

    /**
     * Constructor for HomePage.
     * Initializes elements using PageFactory.
     */
    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the Data Tables page.
     * @return A new instance of DataTablePage.
     */
    public Ex01DataTablePage navigateToDataTablePage() {
        dataTablesLink.click();
        return new Ex01DataTablePage();
    }

    /**
     * Navigates to the Dynamic Loading page.
     * @return A new instance of DynamicLoadingPage.
     */
    public Ex03DynamicLoadingPage navigateToDynamicLoadingPage() {
        dynamicLoadingLink.click();
        return new Ex03DynamicLoadingPage();
    }
}