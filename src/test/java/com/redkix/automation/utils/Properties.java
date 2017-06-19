package com.redkix.automation.utils;

import org.openqa.selenium.remote.BrowserType;

public class Properties {
    private static final String DEFAULT_BROWSER = BrowserType.CHROME;

    private Properties() {
    }

    public static String getBrowser() {
        return System.getProperty(EnvironmentVariables.BROWSER.toString(), DEFAULT_BROWSER);
    }

    public static String getReportDirectory() {
        return System.clearProperty(EnvironmentVariables.REPORT_DIR.toString());
    }
}

enum EnvironmentVariables {
    BROWSER("browser"),
    REPORT_DIR("reportsDirectory");

    private String value;

    EnvironmentVariables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
