package com.coherentsolutions.java.webauto.section01;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class demonstrates how to use the DynamicLoadingPage in test scenarios.
 * It includes tests for both hidden and non-existent elements.
 */
public class Ex04DynamicLoadingTest extends TestBase {

    private Ex03DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    public void goToDynamicLoadingPage() {
        dynamicLoadingPage = homePage.navigateToDynamicLoadingPage();
    }

    /**
     * Tests the scenario with a hidden element.
     */
    @Test
    public void hiddenElementTest() {
        dynamicLoadingPage.clickExample1Link();
        dynamicLoadingPage.clickStartButton();
        String messageText = dynamicLoadingPage.getMessageText();
        WebElement messageElement = dynamicLoadingPage.getFinishMessageElement();
        Assert.assertTrue(messageElement.isDisplayed());
        Assert.assertEquals(messageText, "Hello World!");
    }

    /**
     * Tests the scenario with a non-existent element.
     */
    @Test
    public void nonExistElementTest() {
        dynamicLoadingPage.clickExample2Link();
        dynamicLoadingPage.clickStartButton();
        String messageText = dynamicLoadingPage.getMessageText();
        WebElement messageElement = dynamicLoadingPage.getFinishMessageElement();
        Assert.assertTrue(messageElement.isDisplayed());
        Assert.assertEquals(messageText, "Hello World!");
    }
}