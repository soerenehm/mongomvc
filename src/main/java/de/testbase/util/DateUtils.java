package de.testbase.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DB_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {
    }

    public static Date getDate(String dateAsString, String format) throws ParseException {
        final DateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(dateAsString);
    }
}
