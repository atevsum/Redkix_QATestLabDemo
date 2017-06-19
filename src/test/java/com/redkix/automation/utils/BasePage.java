package com.redkix.automation.utils;

import com.redkix.automation.logging.EventHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
    private WaitFor wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WaitFor(driver);
        PageFactory.initElements(driver, this);
    }

    protected void sendKeysByActions(WebElement element, String text){
        EventHandler.writeToLogAndConsole("Change value of " + element.getAttribute("name") + ": " + "text");
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(text);
        actions.build().perform();
    }

    protected void clickByActions(WebElement element){
        EventHandler.writeToLogAndConsole("Click on element:");
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }

    protected void clickByJS(WebElement element){
        EventHandler.writeToLogAndConsole("Click on element:");
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    protected void waitForElementVisibility(WebElement element){
        wait.forVisibility(element);
    }

    protected void waitForElementClickable(WebElement element){
        wait.forClickable(element);
    }

    protected void waitForElementPresence(By locator){
        wait.forPresence(locator);
    }

    protected void waitForElementsAmount(By locator, int amount){
        wait.forElementsAmountBe(locator, amount);
    }

    protected void waitForTextToBe(WebElement element, String text){
        wait.forTextToBe(element, text);
    }

    protected void waitForElementWithText(List<WebElement> elements, By locatorInside, String subject){
        wait.forElementWithText(elements, locatorInside, subject);
    }

    protected void waitForClassNotContains(WebElement element, String className){
        wait.forClassNotContains(element, className);
    }

    protected WebElement waitForOneOfElementPresent(By locator1, By locator2){
        return wait.forOneOfElementPresent(locator1, locator2);
    }

    protected void threadSleep(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
