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
    @FindBy (id = "getStartedWorkEmail")
    private WebElement emailInput;

    @FindBy (css = "button[ng-click='settingsModal()']")
    private WebElement settingsButton;
    @FindBy (css = "button[ng-click='refreshHandler()']")
    private WebElement refreshButton;
    @FindBy (css = "button.rx-btn-red")
    private WebElement logoutButton;

    private By unreadMessageBy = By.cssSelector("span.rx-unread");
    private int indexOfLastMessage = 1;

    InboxPage(WebDriver driver){
        super(driver);
        turnOffAnimationJQuery();
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
        int amount = inboxMessages.get(indexOfLastMessage).findElements(unreadMessageBy).size();
        System.out.println("ASSERT: " + amount);
        Assert.assertTrue(amount == 0, "Letter is not marked as Read!");
        return this;
    }

    public InboxPage createNewMessageButton(){
        createMessageButton.click();
        return this;
    }



    public InboxPage clickSettingsButton(){
        waitForElementClickable(settingsButton);
        settingsButton.click();
        return this;
    }

    public InboxPage clickLogoutButton(){
        waitForElementPresence(By.cssSelector("button.rx-btn-red"));
        logoutButton.click();
        return this;
    }

    public InboxPage clickRefreshButton(){
        waitForElementClickable(refreshButton);
        refreshButton.click();
        return this;
    }
}
