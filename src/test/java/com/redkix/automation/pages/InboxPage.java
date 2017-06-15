package com.redkix.automation.pages;

import com.redkix.automation.logging.EventHandler;
import com.redkix.automation.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class InboxPage extends BasePage {
    @FindBy (css = "md-content #markLastMessageAsUnreadButton")
    private WebElement markUnreadButton;
    @FindBy (css = "#previewsContent div[role='button'].ng-scope")
    private List<WebElement> inboxMessages;
    @FindBy (id = "composeNewMail")
    private WebElement createMessageButton;

    @FindBy (css = "button[ng-click='settingsModal()']")
    private WebElement settingsButton;
    @FindBy (css = "button.rx-btn-red")
    private WebElement logoutButton;

    private By unreadMessageBy = By.cssSelector("span.rx-unread");
    private int indexOfLastMessage = 1;

    public InboxPage(WebDriver driver){
        super(driver);
    }

    public InboxPage clickMarkUnreadButton(){
        waitForElementVisibility(markUnreadButton);
        markUnreadButton.click();
        return this;
    }

    public InboxPage checkLetterIsUnread(){
        Assert.assertTrue(inboxMessages.get(indexOfLastMessage).findElements(unreadMessageBy).size() > 0, "Letter is not marked as unread!");
        return this;
    }

    public InboxPage clickMarkRead(){
        inboxMessages.get(indexOfLastMessage).click();
        return this;
    }

    public InboxPage checkLetterIsRead(){
        Assert.assertTrue(inboxMessages.get(indexOfLastMessage).findElements(unreadMessageBy).size() == 0, "Letter is not marked as Read!");
        return this;
    }

    public InboxPage createNewMessageButton(){
        createMessageButton.click();
        return this;
    }



    public InboxPage clickSettingsButton(){
        settingsButton.click();
        return this;
    }

    public InboxPage clickLogoutButton(){
        waitForElementVisibility(logoutButton);
        logoutButton.click();
        return this;
    }

    public boolean checkUserIsAlreadyLogin(){
        try{
            waitForElementVisibility(settingsButton);
            EventHandler.writeToLogAndConsole("User is already logged in");
            return true;
        }
        catch(TimeoutException ex){
            return false;
        }
    }
}
