package com.coherentsolutions.java.webauto.section01;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;

/**
 * This class demonstrates how to use the DataTablePage in a test scenario.
 * It includes tests for sorting the data table by last name and first name.
 */
public class Ex02DataTableTest extends TestBase {

    private Ex01DataTablePage dataTablePage;

    @BeforeMethod
    public void goToDataTablePage() {
        dataTablePage = homePage.navigateToDataTablePage();
    }

    /**
     * Tests sorting the table by last name.
     */
    @Test
    public void sortLastNameTest() {
        List<String> lastNames = dataTablePage.getLastNameValues();
        Collections.sort(lastNames);
        dataTablePage.clickLastNameHeader();
        List<String> sortedLastNames = dataTablePage.getLastNameValues();
        Assert.assertEquals(sortedLastNames, lastNames);
    }

    /**
     * Tests sorting the table by first name.
     */
    @Test
    public void sortFirstNameTest() {
        List<String> firstNames = dataTablePage.getFirstNameValues();
        Collections.sort(firstNames);
        dataTablePage.clickFirstNameHeader();
        List<String> sortedFirstNames = dataTablePage.getFirstNameValues();
        Assert.assertEquals(sortedFirstNames, firstNames);
    }
}