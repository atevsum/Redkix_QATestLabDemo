package com.redkix.automation.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    static DateFormat dateFormatForFileName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    static DateFormat dateFormatForTooltip = new SimpleDateFormat("MM/dd/yy, hh:mm a");

    public static String getCurrentTime(){
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentTimeForFileName(){
        Date date = new Date();
        return dateFormatForFileName.format(date);
    }

    public static String getCurrentTimeForTooltip(){
        Date date = new Date();
        String timestamp = dateFormatForTooltip.format(date);
        timestamp = timestamp.replaceAll("0(\\d:\\d\\d)", "$1");
        return timestamp;
    }
}
