package pl.uramowski.appium.screens;

import com.thoughtworks.selenium.SeleniumException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class APIDemosMainScreen {

    protected AppiumDriver driver;

    public APIDemosMainScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    // page elements
    private By accessibilityButton = By.id("Accessibility");
    private By animationButton = By.id("Animation");
    private List<By> requiredElements;

    // page methods
    public void await() {
        requiredElements = Arrays.asList(accessibilityButton, animationButton);
        for (By element : requiredElements) {
            waitForElementPresent(element);
        }
    }

    public void tapAccessibilityButton() {
        waitForElementPresent(accessibilityButton);
        tap(accessibilityButton);
    }

    public void tapAnimationButton() {
        waitForElementPresent(animationButton);
        tap(animationButton);
    }

    /*
    method accepts one argument:
        element - of class By
    waits for requested elements to be present.
    Element does not need to be visible on the screen to be located using this method.
    */
    public void waitForElementPresent(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (Exception e) {
            throw new org.openqa.selenium.TimeoutException("Timeout waiting for element " + element.toString() + " to be present");
        }
    }

    /*
    method accepts one argument:
        element - of class By
    located element is being tapped
    */
    public void tap(By element) {
        try {
            driver.findElement(element).click();
        } catch (NoSuchElementException e) {
            throw new SeleniumException("cannot execute tap() method - element: " + element.toString() + " not found");
        }
        System.out.println("Element pressed: " + element.toString());
    }
}
