package com.vladimir_khm.users.repository;

import android.arch.persistence.room.TypeConverter;

import com.vladimir_khm.users.util.DateTimeConverter;

import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;

public class DaoConverters {

    @TypeConverter
    public DateTime fromTimestamp(String value) {
        return value == null ? null : DateTimeConverter.toDateTime(value);
    }

    @TypeConverter
    public String dateToTimestamp(DateTime date) {
        return date == null ? null : DateTimeConverter.toString(date);
    }

    @TypeConverter
    public String listToString(List<String> tagList) {
        StringBuilder sb = new StringBuilder();
        for (String tag: tagList) {
            if (sb.length() > 0) sb.append("\n");
            sb.append(tag);
        }
        return sb.toString();
    }

    @TypeConverter
    public List<String> stringToList(String data) {
        return Arrays.asList(data.split("\n"));
    }
}
