package com.redkix.automation.actions;

import com.redkix.automation.controls.PageCollection;
import com.redkix.automation.pages.CreateMessagePage;
import com.redkix.automation.utils.BaseAction;

public class CreateMessageActions extends BaseAction {
    public CreateMessageActions(PageCollection pages){
        super(pages);
    }

    public void fillMessageDataAndSend(String to, String subject, String body){
        pages.getCreateMessagePage().fillToInput(to)
                .fillSubjectInput(subject)
                .fillBodyInput(subject)
                .clickSendLetter();
    }
}
