package com.coherentsolutions.java.webauto.section01.advanced;

import com.coherentsolutions.java.webauto.section01.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * This class demonstrates more advanced Page Factory techniques,
 * including working with lists of elements and custom expected conditions.
 */
public class Ex06AdvancedPageFactoryListsAndWaits extends PageBase {

    @FindBy(css = ".menu-item")
    private List<WebElement> menuItems;

    @FindBy(id = "dynamic-content")
    private WebElement dynamicContent;

    public Ex06AdvancedPageFactoryListsAndWaits() {
        super();
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks a menu item by its index.
     * This method demonstrates working with a list of WebElements.
     *
     * @param index The index of the menu item to click
     */
    public void clickMenuItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            menuItems.get(index).click();
        } else {
            throw new IndexOutOfBoundsException("Invalid menu item index");
        }
    }

    /**
     * Waits for dynamic content to contain specific text.
     * This method demonstrates creating a custom expected condition with WebDriverWait.
     *
     * @param expectedText The text to wait for
     * @param timeoutInSeconds The maximum time to wait
     * @return true if the text appears within the timeout, false otherwise
     */
    public boolean waitForDynamicContent(String expectedText, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(dynamicContent, expectedText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the number of menu items.
     * @return The number of menu items
     */
    public int getMenuItemCount() {
        return menuItems.size();
    }
}