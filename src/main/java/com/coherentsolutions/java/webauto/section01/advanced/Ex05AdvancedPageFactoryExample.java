package com.coherentsolutions.java.webauto.section01.advanced;

import com.coherentsolutions.java.webauto.section01.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class demonstrates advanced usage of Page Factory annotations.
 */
public class Ex05AdvancedPageFactoryExample extends PageBase {

    @FindBy(id = "username")
    @CacheLookup
    private WebElement usernameInput;

    @FindBy(css = ".submit-button")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class, 'error-message')]")
    private WebElement errorMessage;

    public Ex05AdvancedPageFactoryExample() {
        super();
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters the username into the input field.
     * The @CacheLookup annotation is used on the usernameInput element,
     * which means its location will be cached after the first lookup.
     * This can improve performance but should be used carefully with dynamic elements.
     *
     * @param username The username to enter
     */
    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    /**
     * Clicks the submit button.
     */
    public void clickSubmit() {
        submitButton.click();
    }

    /**
     * Gets the text of the error message.
     * @return The error message text
     */
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}