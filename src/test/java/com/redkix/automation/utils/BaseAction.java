package com.redkix.automation.utils;

import com.redkix.automation.pages.PageCollection;

public abstract class BaseAction {
    protected PageCollection pages;

    public BaseAction(PageCollection pageCollection){
        this.pages = pageCollection;
    }
}
