package com.redkix.automation.actions;

import com.redkix.automation.pages.PageCollection;
import com.redkix.automation.utils.BaseAction;

public class SentItemsActions extends BaseAction {
    public SentItemsActions(PageCollection pages){
        super(pages);
    }


    public void checkMessageIsSent(String subject){
        pages.getSentItemsPage().clickFoldersLeftTab()
                .clickSentItemsTab()
                .waitForMessageWithSubject(subject);
    }
}
