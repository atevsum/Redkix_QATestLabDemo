package com.redkix.automation.utils;

public class OSValidator {
    private static String OS = System.getProperty("os.name").toLowerCase();

    private OSValidator() {}

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }
}
