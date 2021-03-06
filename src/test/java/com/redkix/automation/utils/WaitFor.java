package com.redkix.automation.utils;

import com.redkix.automation.logging.EventHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitFor {
    private int TIMEOUT_10_SECONDS = 10;
    private int TIMEOUT_30_SECONDS = 30;
    private int TIMEOUT_120_SECONDS = 120;
    private WebDriver driver;

    WebElement returnedElement;

    protected WaitFor(WebDriver driver){
        this.driver = driver;
    }

    private WebDriverWait getWait(int timeout){
        return new WebDriverWait(driver, timeout);
    }

    protected void forVisibility(WebElement element){
        EventHandler.writeToLogAndConsole("WaitFor for element visibility:");
        getWait(TIMEOUT_30_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    protected void forPresence(By locator){
        EventHandler.writeToLogAndConsole("Wait for element presence " + locator.toString());
        getWait(TIMEOUT_30_SECONDS).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void forElementsAmountBe(By locator, int amount){
        EventHandler.writeToLogAndConsole("Wait for elements (" + locator.toString() + ") amount will be " + amount);
        getWait(TIMEOUT_30_SECONDS).until(ExpectedConditions.numberOfElementsToBe(locator, amount));
    }

    protected void forElementWithText(List<WebElement> elements, By locatorInside, String subject){
        EventHandler.writeToLogAndConsole(String.format("Wait for element with text '%s' presence", subject));
        getWait(TIMEOUT_30_SECONDS).until((driver) -> {
            for (WebElement element : elements)
                if (element.findElement(locatorInside).getText().equals(subject))
                    return true;
            return false;
        });
    }

    protected void forElementWithText(List<WebElement> elements, String subject){
        EventHandler.writeToLogAndConsole(String.format("Wait for element with text '%s' presence", subject));
        getWait(TIMEOUT_30_SECONDS).until((driver) -> {
            for (WebElement element : elements)
                if (element.getText().equals(subject))
                    return true;
            return false;
        });
    }

    protected void forClassNotContains(WebElement element, String className){
        EventHandler.writeToLogAndConsole("Wait for element class change");
        getWait(TIMEOUT_30_SECONDS).until(ExpectedConditions. not(ExpectedConditions.attributeContains(element, "class", className)));
    }

    protected WebElement forOneOfElementPresent(By locator1, By locator2) {
        EventHandler.writeToLogAndConsole("Wait for one of two elements presence: " + locator1.toString() + " or " + locator2.toString());
        getWait(TIMEOUT_30_SECONDS).until(
                (driver) -> {
                    if (driver.findElements(locator1).size() > 0) {
                        returnedElement = driver.findElement(locator1);
                        return true;
                    }
                    if (driver.findElements(locator2).size() > 0) {
                        returnedElement = driver.findElement(locator2);
                        return true;
                    }
                    return false;
                });
        return returnedElement;
    }
}
