package com.redkix.automation.logging;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EventHandler implements WebDriverEventListener {
    private static String previousEvent;
    public static boolean isForLogging = true;

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        writeToLogAndConsole("Navigate to " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) { }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        writeToLogAndConsole("Navigate back");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        writeToLogAndConsole("Current URL: " + driver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        writeToLogAndConsole("Navigate forward");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        writeToLogAndConsole("Current URL: " + driver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        writeToLogAndConsole("Refresh page");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        writeToLogAndConsole("Current URL: " + driver.getCurrentUrl());
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        if (isForLogging)
            writeToLogAndConsole("Search for element " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        if (element != null && isForLogging) {
            writeToLogAndConsole("Found element " + element.getTagName());
        }
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        writeToLogAndConsole("Click on element " + element.getTagName() + " " + element.getAttribute("name"));
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        writeToLogAndConsole("Clicked successfully");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        writeToLogAndConsole("Change value of " + webElement.getTagName() + " " + webElement.getAttribute("id"));
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        writeToLogAndConsole("Changed value of " + webElement.getTagName() + " : " + webElement.getAttribute("value"));
    }

/*    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver webDriver) {
        writeToLogAndConsole("Change value of " + element.getTagName() + " " + element.getAttribute("id"));
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver webDriver) {
        writeToLogAndConsole("Changed value of " + element.getTagName() + " : " + element.getAttribute("value"));
    }*/

    @Override
    public void beforeScript(String script, WebDriver driver) {
        writeToLogAndConsole("Execute script: " + script);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        writeToLogAndConsole("Script executed");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    public static void writeToLogAndConsole(String event){
        String timedEvent = String.format("[%s] %s", CurrentTime.getCurrentTime(), event);
        if (!event.equals(previousEvent)) {
            System.out.println(timedEvent);
            Reporter.log(timedEvent + "<br/>");
            previousEvent = event;
        }
    }

    public static void writeToLogAndConsoleBold(String event){
        writeToLogAndConsole("<span style='color:blue;font-weight:bold;'>" + event + "</span>");
    }
}
