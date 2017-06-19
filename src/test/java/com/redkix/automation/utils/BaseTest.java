package com.redkix.automation.utils;

import com.redkix.automation.actions.ActionCollection;
import com.redkix.automation.pages.PageCollection;
import com.redkix.automation.logging.EventHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private EventFiringWebDriver driver;
    private final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
    protected PageCollection pages;
    protected ActionCollection actions;

    @BeforeClass
    public void setUp() {
        driver = new EventFiringWebDriver(DriverFactory.initDriver(Properties.getBrowser()));
        driver.register(new EventHandler());
        System.setProperty(ESCAPE_PROPERTY, "false");
        pages = new PageCollection(driver);
        actions = new ActionCollection(pages);
    }

    @AfterClass
    public void tearDown() {
        if (pages != null)
            pages.clearPageCollection();
        if (actions != null)
            actions.clearActionCollection();
        if (driver != null)
            driver.quit();
    }

    public EventFiringWebDriver getDriver(){
        return driver;
    }
}
