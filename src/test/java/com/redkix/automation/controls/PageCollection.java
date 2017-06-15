package com.redkix.automation.controls;

import com.redkix.automation.pages.CreateMessagePage;
import com.redkix.automation.pages.InboxPage;
import com.redkix.automation.pages.LoginPage;
import com.redkix.automation.utils.BasePage;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.function.Supplier;

public class PageCollection {
    private HashMap <String, BasePage> pageCollection;
    private WebDriver driver;

    public PageCollection(WebDriver driver){
        pageCollection = new HashMap<>();
        this.driver = driver;
    }

    private <T extends BasePage> T getPage(String pageName, Supplier <T> pageConstructor){
        if(!pageCollection.containsKey(pageName)){
            pageCollection.put(pageName, pageConstructor.get());
        }
        return (T)pageCollection.get(pageName);
    }

    public LoginPage getLoginPage(){
        return getPage("LoginPage", () -> new LoginPage(driver));
    }
    public InboxPage getInboxPage(){
        return getPage("InboxPage", () -> new InboxPage(driver));
    }
    public CreateMessagePage getCreateMessagePage(){
        return getPage("CreateMessagePage", () -> new CreateMessagePage(driver));
    }

    public void clearPageCollection(){
        pageCollection.clear();
    }
}
