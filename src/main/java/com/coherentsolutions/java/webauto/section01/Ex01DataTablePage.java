package com.coherentsolutions.java.webauto.section01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class demonstrates the Page Object pattern without using Page Factory.
 * It represents a page with a data table and provides methods to interact with it.
 */
public class Ex01DataTablePage extends PageBase {

    private static final By LAST_NAME_HEADER = By.xpath(".//table[@id = 'table1']//span[contains(text(), 'Last Name')]");
    private static final By FIRST_NAME_HEADER = By.xpath(".//table[@id = 'table1']//span[contains(text(), 'First Name')]");
    private static final By LAST_NAMES = By.cssSelector("#table1 td:nth-child(1)");
    private static final By FIRST_NAMES = By.cssSelector("#table1 td:nth-child(2)");

    /**
     * Clicks the "First Name" header to sort the table by first name.
     */
    public void clickFirstNameHeader() {
        driver.findElement(FIRST_NAME_HEADER).click();
    }

    /**
     * Clicks the "Last Name" header to sort the table by last name.
     */
    public void clickLastNameHeader() {
        driver.findElement(LAST_NAME_HEADER).click();
    }

    /**
     * Retrieves all last names from the table.
     * @return A list of last names as strings.
     */
    public List<String> getLastNameValues() {
        return driver.findElements(LAST_NAMES).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * Retrieves all first names from the table.
     * @return A list of first names as strings.
     */
    public List<String> getFirstNameValues() {
        return driver.findElements(FIRST_NAMES).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}