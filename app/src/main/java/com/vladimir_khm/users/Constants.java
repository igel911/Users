package com.vladimir_khm.users;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public interface Constants {

    String USER = "USER";
    String USER_ID = "id";
    String USER_IS_ACTIVE = "isActive";
    String USER_BALANCE = "balance";
    String USER_PICTURE = "picture";
    String USER_AGE = "age";
    String USER_EYE_COLOR = "eyeColor";
    String USER_NAME = "name";
    String USER_GENDER = "gender";
    String USER_COMPANY = "company";
    String USER_EMAIL = "email";
    String USER_PHONE = "phone";
    String USER_ADDRESS = "address";
    String USER_ABOUT = "about";
    String USER_REGISTERED = "registered";
    String USER_TAGS = "tags";
    String USER_FRIENDS = "friends";
    String USER_FAVORITE_FRUIT = "favoriteFruit";
    String DATA_BASE_NAME = "database";
    String TAG = "tag";
    DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss ZZ");
}
