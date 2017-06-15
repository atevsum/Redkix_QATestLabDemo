package com.redkix.automation.utils;

import org.testng.annotations.DataProvider;

public class UserData {
    private static String email = "qatest6@redkix.com";
    private static String password = "Redkix111";

    @DataProvider
    public static Object[][] getLoginData() {
        return new String[][] {
                {email, password}
        };
    }
}
