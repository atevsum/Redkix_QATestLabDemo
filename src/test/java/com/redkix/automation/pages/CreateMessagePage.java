package com.redkix.automation.pages;

import com.redkix.automation.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateMessagePage extends BasePage {
    @FindBy (css = "div.ngdialog-content")
    private WebElement newMessageContainer;
    @FindBy (id = "to-input")
    private WebElement toInput;
    @FindBy (id = "composeDialogSubject")
    private WebElement subjectInput;
    @FindBy (id = "sendBtn")
    private WebElement sendButton;
    @FindBy (id = "compose")
    private WebElement bodyInput;

    public CreateMessagePage(WebDriver driver){
        super(driver);
        waitForLoad();
    }

    public void waitForLoad(){
        waitForElementVisibility(newMessageContainer);
    }

    public CreateMessagePage fillToInput(String to){
        toInput.sendKeys(to);
        return this;
    }

    public CreateMessagePage fillSubjectInput(String subject){
        subjectInput.sendKeys(subject);
        return this;
    }

    public CreateMessagePage fillBodyInput(String body){
        bodyInput.sendKeys(body);
        return this;
    }



    public CreateMessagePage clickSendLetter(){
        sendButton.click();
        return this;
    }
}
