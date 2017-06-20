package com.redkix.automation.pages;

import com.redkix.automation.utils.BasePage;
import org.openqa.selenium.By;
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
    @FindBy (css = "#previewsContent div[role='button'].ng-scope div.rx-preview-details span:nth-child(1).ng-scope")
    private List<WebElement> inboxMessagesSubjects;
    @FindBy (id = "composeNewMail")
    private WebElement createMessageButton;

    @FindBy (css = "button[ng-click='settingsModal()']")
    private WebElement settingsButton;
    @FindBy (css = "div.button-bar button")
    private List<WebElement> buttonsOnSettingsModal;
    @FindBy (css = "button.rx-btn-red")
    private WebElement logoutButton;

    private By logoutButtonBy = By.cssSelector("button.rx-btn-red");
    private By unreadMessageByPartial = By.cssSelector("span.rx-unread");
    private int indexOfLastMessage = 1;

    InboxPage(WebDriver driver){
        super(driver);
    }

    public void waitForLoad(){
        waitForElementVisibility(markUnreadButton);
    }

    public InboxPage clickMarkUnreadButton(){
        waitForElementVisibility(markUnreadButton);
        markUnreadButton.click();
        return this;
    }

    public InboxPage checkLetterIsUnread(){
        Assert.assertTrue(inboxMessages.get(indexOfLastMessage).findElements(unreadMessageByPartial).size() > 0, "Letter is not marked as unread!");
        return this;
    }

    public InboxPage clickMarkRead(){
        threadSleep(500);
        clickByActions(inboxMessages.get(indexOfLastMessage));
        return this;
    }

    public InboxPage checkLetterIsRead(){
        waitForClassNotContains(inboxMessagesSubjects.get(indexOfLastMessage), "rx-unread");
        int amount = inboxMessages.get(indexOfLastMessage).findElements(unreadMessageByPartial).size();
        Assert.assertTrue(amount == 0, "Letter is not marked as Read!");
        return this;
    }

    public InboxPage createNewMessageButton(){
        createMessageButton.click();
        return this;
    }

    public InboxPage clickSettingsButton(){
        waitForElementVisibility(settingsButton);
        settingsButton.click();
        return this;
    }

    public InboxPage clickLogoutButton(){
        waitForElementPresence(logoutButtonBy);
        logoutButton.click();
        return this;
    }
}
