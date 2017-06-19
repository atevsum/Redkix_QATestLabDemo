package com.redkix.automation.actions;

import com.redkix.automation.actions.CreateMessageActions;
import com.redkix.automation.actions.InboxActions;
import com.redkix.automation.actions.LoginActions;
import com.redkix.automation.pages.PageCollection;
import com.redkix.automation.utils.BaseAction;

import java.util.HashMap;
import java.util.function.Supplier;

public class ActionCollection {
    private HashMap <String, BaseAction> actionCollection;
    private PageCollection pageCollection;

    public ActionCollection(PageCollection pageCollection){
        actionCollection = new HashMap<>();
        this.pageCollection = pageCollection;
    }

    private <T extends BaseAction> T getAction(String actionName, Supplier <T> actionConstructor){
        if(!actionCollection.containsKey(actionName)){
            actionCollection.put(actionName, actionConstructor.get());
        }
        return (T)actionCollection.get(actionName);
    }

    public LoginActions getLoginActions(){
        return getAction("LoginActions", () -> new LoginActions(pageCollection));
    }
    public InboxActions getInboxActions(){
        return getAction("InboxActions", () -> new InboxActions(pageCollection));
    }
    public CreateMessageActions getCreateMessageActions(){
        return getAction("CreateMessageActions", () -> new CreateMessageActions(pageCollection));
    }
    public SentItemsActions getSentItemsActions(){
        return getAction("SentItemsActions", () -> new SentItemsActions(pageCollection));
    }

    public void clearActionCollection(){
        actionCollection.clear();
    }
}
