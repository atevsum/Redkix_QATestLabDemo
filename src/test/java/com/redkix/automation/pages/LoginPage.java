package com.redkix.automation.pages;

import com.redkix.automation.logging.EventHandler;
import com.redkix.automation.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy (id = "getStartedWorkEmail")
    private WebElement emailInput;
    @FindBy (id = "getStartedButton")
    private WebElement getStartedButton;
    @FindBy (id = "exchangePassword")
    private WebElement passwordInput;
    @FindBy (id = "exchangeSignInButton")
    private WebElement signInButton;

    private By emailInputBy = By.id("getStartedWorkEmail");

    LoginPage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoad(){
        waitForElementVisibility(emailInput);
    }

    public LoginPage fillEmailInput(String email){
        waitForElementVisibility(emailInput);
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage clickGetStartedButton(){
        getStartedButton.click();
        return this;
    }

    public LoginPage fillPasswordInput(String password){
        waitForElementVisibility(passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInButton(){
        signInButton.click();
        return this;
    }

    public boolean checkUserIsAlreadyLogin(){
        try{
            waitForElementPresence(emailInputBy);
            return false;
        }
        catch(TimeoutException ex){
            EventHandler.writeToLogAndConsole("User is already logged in");
            return true;
        }
    }
}
