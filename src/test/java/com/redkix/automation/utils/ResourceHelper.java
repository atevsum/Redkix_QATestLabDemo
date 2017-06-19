package com.redkix.automation.utils;

import java.io.File;

public class ResourceHelper {
    public static final String TEXT_FILE_TO_ATTACH = "TextAttachment.txt";
    public static final String GIF_FILE_TO_ATTACH = "babySeal.gif";

    private ResourceHelper() {}

    public static String getResourcePath(String resourceName) {
        return new File(ResourceHelper.class.getResource("/"+resourceName).getFile()).getAbsolutePath();
    }
}
