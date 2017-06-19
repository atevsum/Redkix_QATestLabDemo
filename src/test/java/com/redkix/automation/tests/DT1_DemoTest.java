package com.redkix.automation.tests;

import com.redkix.automation.utils.BaseTest;
import com.redkix.automation.utils.UserData;
import org.testng.annotations.Test;

import java.util.Random;

public class DT1_DemoTest extends BaseTest {

    @Test (description = "First demo test",
            dataProvider = "getLoginData", dataProviderClass = UserData.class)
    public void loginTest(String email, String password){
        actions.getLoginActions().loginInApp(email, password);

        actions.getInboxActions().markMassageAsUnread();
        actions.getInboxActions().markMassageAsRead();

        Random rand = new Random();
        String to = "qatest6@redkix.com";
        String subject = "Functional" + rand.nextInt(100000);
        String body = "Types" +  + rand.nextInt(100000);
        actions.getCreateMessageActions().fillMessageDataAndSend(to, subject, body);

        actions.getSentItemsActions().checkMessageIsSent(subject);

        actions.getLoginActions().logoutFromApp();
    }
}
