package com.redkix.automation.pages;

import com.redkix.automation.utils.BasePage;
import com.redkix.automation.utils.ResourceHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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
    @FindBy (css = "input[type='file'][aria-label='Attach Files']")
    private List<WebElement> attachFileInput;
    @FindBy (css = "button[ng-click='ctrl.attachment.remove()']")
    private WebElement removeAttachedFileButton;
    @FindBy (css = "div.filename")
    private List<WebElement> attachedFileName;
    @FindBy (css = "div.attachments-padding-left.no-content")
    private WebElement noContentElement;

    private By overlayElementBy = By.cssSelector("div.ngdialog-overlay");

    CreateMessagePage(WebDriver driver){
        super(driver);
        waitForLoad();
    }

    public void waitForLoad(){
        waitForElementVisibility(newMessageContainer);
    }

    public CreateMessagePage fillToInput(String to){
        waitForElementVisibility(toInput);
        sendKeysByActions(toInput, to);
        return this;
    }

    public CreateMessagePage fillSubjectInput(String subject){
        clickByActions(subjectInput);
        subjectInput.sendKeys(subject);
        return this;
    }

    public CreateMessagePage fillBodyInput(String body){
        bodyInput.sendKeys(body);
        return this;
    }

    public CreateMessagePage attachFileToMessage(String filename){
        attachFileInput.get(1).sendKeys(ResourceHelper.getResourcePath(filename));
        waitForTextToBe(attachedFileName.get(0), filename);
        return this;
    }

    public CreateMessagePage checkFileIsAdded(){
        Assert.assertEquals(attachedFileName.get(0).getText().trim(), ResourceHelper.TEXT_FILE_TO_ATTACH, "The file is not loaded!");
        return this;
    }

    public CreateMessagePage removeAttachedFile(){
        removeAttachedFileButton.click();
        waitForElementVisibility(noContentElement);
        return this;
    }

    public CreateMessagePage clickSendLetter(){
        sendButton.click();
        waitForElementsAmount(overlayElementBy, 0);
        return this;
    }
}
