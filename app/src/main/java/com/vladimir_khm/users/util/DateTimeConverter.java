package com.vladimir_khm.users.util;

import org.joda.time.DateTime;

import static com.vladimir_khm.users.Constants.FORMATTER;

public class DateTimeConverter {

    public static DateTime toDateTime(String stringDateTime) {
        return FORMATTER.withOffsetParsed().parseDateTime(stringDateTime);
    }

    public static String toString(DateTime dateTime) {
        return FORMATTER.print(dateTime);
    }
}
