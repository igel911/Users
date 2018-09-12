package com.vladimir_khm.users.repository;

import android.arch.persistence.room.TypeConverter;

import com.vladimir_khm.users.util.DateTimeConverter;

import org.joda.time.DateTime;

public class DaoConverters {

    @TypeConverter
    public static DateTime fromTimestamp(String value) {
        return value == null ? null : DateTimeConverter.toDateTime(value);
    }

    @TypeConverter
    public static String dateToTimestamp(DateTime date) {
        return date == null ? null : DateTimeConverter.toString(date);
    }

}