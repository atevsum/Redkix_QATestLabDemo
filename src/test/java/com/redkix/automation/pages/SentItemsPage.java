package com.redkix.automation.pages;

import com.redkix.automation.actions.SentItemsActions;
import com.redkix.automation.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SentItemsPage extends BasePage {
    @FindBy (css = "ol[ng-model='mailBoxFolders'] li")
    private List<WebElement> mailBoxFoldersList;
    @FindBy (css = "#previewsContent div[role='button'].ng-scope")
    private List<WebElement> sentMessages;

    private By subjectItemByPartial = By.cssSelector("div.subject");

    SentItemsPage(WebDriver driver){
        super(driver);
    }

    public SentItemsPage clickFoldersLeftTab(){
        int foldersItemIndex = 2;
        mailBoxFoldersList.get(foldersItemIndex).click();
        return this;
    }

    public SentItemsPage clickSentItemsTab(){
        int inboxItemsIndex = 5;
        mailBoxFoldersList.get(inboxItemsIndex).click();
        return this;
    }

    public void waitForMessageWithSubject(String subject){
        waitForElementWithText(sentMessages, subjectItemByPartial, subject);
    }
}
