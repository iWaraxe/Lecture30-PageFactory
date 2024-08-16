package com.coherentsolutions.java.webauto.section01;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class demonstrates the Page Object pattern using Page Factory.
 * It represents a page with dynamic loading elements.
 */
public class Ex03DynamicLoadingPage extends PageBase {

    @FindBy(css = "[href='/dynamic_loading/1']")
    private WebElement example1Link;

    @FindBy(css = "[href='/dynamic_loading/2']")
    private WebElement example2Link;

    @FindBy(css = "#start button")
    private WebElement startButton;

    @FindBy(id = "finish")
    private WebElement finishMessage;

    /**
     * Constructor that initializes the Page Factory elements.
     */
    public Ex03DynamicLoadingPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks the link for Example 1.
     */
    public void clickExample1Link() {
        example1Link.click();
    }

    /**
     * Clicks the link for Example 2.
     */
    public void clickExample2Link() {
        example2Link.click();
    }

    /**
     * Clicks the Start button.
     */
    public void clickStartButton() {
        startButton.click();
    }

    /**
     * Gets the WebElement for the finish message.
     * @return The WebElement representing the finish message.
     */
    public WebElement getFinishMessageElement() {
        return finishMessage;
    }

    /**
     * Gets the text of the finish message.
     * @return The text of the finish message.
     */
    public String getMessageText() {
        waiter.until(ExpectedConditions.visibilityOf(finishMessage));
        return finishMessage.getText();
    }
}