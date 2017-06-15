package com.redkix.automation.actions;

import com.redkix.automation.controls.PageCollection;
import com.redkix.automation.logging.EventHandler;
import com.redkix.automation.utils.BaseAction;

public class LoginActions extends BaseAction {
    public LoginActions(PageCollection pages){
        super(pages);
    }

    public void loginInApp(String email, String password){
        if(pages.getInboxPage().checkUserIsAlreadyLogin())
            logoutFromApp();
        loginIn(email, password);
    }

    public void loginIn(String email, String password){
        EventHandler.writeToLogAndConsoleBold("Log in application");
        pages.getLoginPage().fillEmailInput(email)
                    .clickGetStartedButton()
                    .fillPasswordInput(password)
                    .clickSignInButton();
    }

    public void logoutFromApp(){
        EventHandler.writeToLogAndConsoleBold("Log out from application");
        pages.getInboxPage().clickSettingsButton()
                .clickLogoutButton();
        pages.getLoginPage().waitForLoad();
    }
}
