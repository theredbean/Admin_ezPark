package vn.redbean.adminezpark.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeFormatter {

    public static String getDateFromString(String fullDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date date = sdf.parse(fullDate);
            return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(date);
        } catch (ParseException e) {
            return "N/A";
        }
    }

    public static String getTimeFromString(String fullDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            Date date = sdf.parse(fullDate);
            return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(date);
        } catch (ParseException e) {
            return "N/A";
        }
    }
}
