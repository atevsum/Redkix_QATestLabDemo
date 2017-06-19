package com.redkix.automation.actions;

import com.redkix.automation.logging.EventHandler;
import com.redkix.automation.pages.PageCollection;
import com.redkix.automation.utils.BaseAction;
import com.redkix.automation.utils.ResourceHelper;

public class CreateMessageActions extends BaseAction {
    public CreateMessageActions(PageCollection pages){
        super(pages);
    }

    public void fillMessageDataAndSend(String to, String subject, String body){
        EventHandler.writeToLogAndConsoleBold("Create new message and send it");
        pages.getInboxPage().createNewMessageButton();
        pages.getCreateMessagePage().fillToInput(to)
                .fillSubjectInput(subject)
                .fillBodyInput(body)
                .attachFileToMessage(ResourceHelper.TEXT_FILE_TO_ATTACH)
                .removeAttachedFile()
                .attachFileToMessage(ResourceHelper.GIF_FILE_TO_ATTACH)
                .clickSendLetter();
    }
}
