package com.vladimir_khm.users.repository;

import android.arch.persistence.room.TypeConverter;

import org.joda.time.DateTime;

import static com.vladimir_khm.users.Constants.FORMATTER;

public class Converters {

    @TypeConverter
    public static DateTime fromTimestamp(String value) {
        return value == null ? null : FORMATTER.parseDateTime(value);
    }

    @TypeConverter
    public static String dateToTimestamp(DateTime date) {
        return date == null ? null : FORMATTER.print(date);
    }

}
