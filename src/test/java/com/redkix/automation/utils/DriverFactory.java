package com.redkix.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class DriverFactory {
    private DriverFactory() {}

    public static WebDriver initDriver(String browser) {
        switch (browser) {
            case "chrome":
            default:
                ChromeOptions options = new ChromeOptions();
                options.setBinary(System.getProperty("user.home") + "/AppData/Local/Programs/Redkix/Redkix.exe");
                options.addArguments("--start-maximized");
                System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("chromedriver.exe"));
                return new ChromeDriver(options);
        }
    }

    /*private static String getResourcePath(String resourceName) {
        return new File(DriverFactory.class.getResource("/"+resourceName).getFile()).getAbsolutePath();
    }*/
}