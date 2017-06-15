package com.redkix.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    private WaitFor wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WaitFor(driver);
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementVisibility(WebElement element){
        wait.forVisibility(element);
    }

}
