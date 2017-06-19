package com.redkix.automation.actions;

import com.redkix.automation.pages.PageCollection;
import com.redkix.automation.logging.EventHandler;
import com.redkix.automation.utils.BaseAction;

public class InboxActions extends BaseAction {
    public InboxActions(PageCollection pages){
        super(pages);
    }

    public void markMassageAsUnread(){
        EventHandler.writeToLogAndConsoleBold("Mark message as Unread");
        pages.getInboxPage().clickMarkUnreadButton()
            .checkLetterIsUnread();
    }

    public void markMassageAsRead(){
        EventHandler.writeToLogAndConsoleBold("Mark message as Read");
        pages.getInboxPage().clickMarkRead()
                .checkLetterIsRead();
    }
}
