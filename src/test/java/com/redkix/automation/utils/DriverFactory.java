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

                String pathToApp = OSValidator.isWindows() ?
                        System.getProperty("user.home") + "/AppData/Local/Programs/Redkix/Redkix.exe" :
                        "/Applications/Redkix.app/Contents/MacOS/Redkix";
                options.setBinary(pathToApp);

                options.addArguments("--start-maximized");

                String executableName = OSValidator.isWindows() ? "chromedriver.exe" : "chromedriver";
                System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath(executableName));

                return new ChromeDriver(options);
        }
    }
}