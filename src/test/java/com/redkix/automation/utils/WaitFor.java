package com.redkix.automation.utils;

import com.redkix.automation.logging.EventHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
    private int TIMEOUT_10_SECONDS = 10;
    private int TIMEOUT_30_SECONDS = 30;
    private int TIMEOUT_120_SECONDS = 120;
    private WebDriver driver;

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

    protected void forClickable(WebElement element){
        EventHandler.writeToLogAndConsole("WaitFor for element to be clickable" + element.getTagName() + " " + element.getAttribute("name") + ":");
        getWait(TIMEOUT_30_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void forPresence(By locator){
        EventHandler.writeToLogAndConsole("Wait for element presence " + locator.toString());
        getWait(TIMEOUT_30_SECONDS).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void forElementsAmountBe(By locator, int amount){
        EventHandler.writeToLogAndConsole("Wait for elements (" + locator.toString() + ") amount will be " + amount);
        getWait(TIMEOUT_30_SECONDS).until(ExpectedConditions.numberOfElementsToBe(locator, amount));
    }

    protected void forTextToBe(WebElement element, String text){
        EventHandler.writeToLogAndConsole("Wait for element text to be " + element.toString());
        getWait(TIMEOUT_30_SECONDS).until((driver) -> element.getText().equals(text));
    }
}
