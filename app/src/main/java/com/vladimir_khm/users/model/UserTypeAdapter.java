package com.vladimir_khm.users.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.vladimir_khm.users.util.DateTimeConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.vladimir_khm.users.Constants.FORMATTER;
import static com.vladimir_khm.users.Constants.USER_ABOUT;
import static com.vladimir_khm.users.Constants.USER_ADDRESS;
import static com.vladimir_khm.users.Constants.USER_AGE;
import static com.vladimir_khm.users.Constants.USER_BALANCE;
import static com.vladimir_khm.users.Constants.USER_COMPANY;
import static com.vladimir_khm.users.Constants.USER_EMAIL;
import static com.vladimir_khm.users.Constants.USER_EYE_COLOR;
import static com.vladimir_khm.users.Constants.USER_FAVORITE_FRUIT;
import static com.vladimir_khm.users.Constants.USER_FRIENDS;
import static com.vladimir_khm.users.Constants.USER_GENDER;
import static com.vladimir_khm.users.Constants.USER_ID;
import static com.vladimir_khm.users.Constants.USER_IS_ACTIVE;
import static com.vladimir_khm.users.Constants.USER_NAME;
import static com.vladimir_khm.users.Constants.USER_PHONE;
import static com.vladimir_khm.users.Constants.USER_PICTURE;
import static com.vladimir_khm.users.Constants.USER_REGISTERED;
import static com.vladimir_khm.users.Constants.USER_TAGS;

public class UserTypeAdapter extends TypeAdapter<User> {

    @Override
    public void write(JsonWriter writer, User user) throws IOException {
        writer.beginObject();
        writer.name(USER_ID).value(user.getId());
        writer.name(USER_IS_ACTIVE).value(user.isActive());
        writer.name(USER_BALANCE).value(user.getBalance());
        writer.name(USER_PICTURE).value(user.getPictureUrl());
        writer.name(USER_AGE).value(user.getAge());
        writer.name(USER_EYE_COLOR).value(user.getEyeColor());
        writer.name(USER_NAME).value(user.getName());
        writer.name(USER_GENDER).value(user.getGender());
        writer.name(USER_COMPANY).value(user.getCompany());
        writer.name(USER_EMAIL).value(user.getEmail());
        writer.name(USER_PHONE).value(user.getPhone());
        writer.name(USER_ADDRESS).value(user.getAddress());
        writer.name(USER_ABOUT).value(user.getAbout());
        writer.name(USER_REGISTERED).value(FORMATTER.print(user.getRegistered()));
        writer.name(USER_TAGS);
        writer.beginArray();
        for (String tag : user.getTagList()) {
            writer.value(tag);
        }
        writer.endArray();
        writer.name(USER_FRIENDS);
        writer.beginArray();
        for (Friend friend : user.getFriendList()) {
            writer.beginObject();
            writer.name(USER_ID).value(friend.getId());
            writer.name(USER_NAME).value(friend.getName());
            writer.endObject();
        }
        writer.endArray();
        writer.name(USER_FAVORITE_FRUIT).value(user.getFavoriteFruit());
        writer.endObject();
        writer.close();

    }

    @Override
    public User read(JsonReader reader) throws IOException {
        User user = new User();
        reader.beginObject();
        while (reader.hasNext()) {
            switch (reader.nextName()) {
                case USER_ID:
                    user.setId(reader.nextString());
                    break;
                case USER_IS_ACTIVE:
                    user.setIsActive(reader.nextBoolean());
                    break;
                case USER_BALANCE:
                    user.setBalance(reader.nextString());
                    break;
                case USER_PICTURE:
                    user.setPictureUrl(reader.nextString());
                    break;
                case USER_AGE:
                    user.setAge(reader.nextInt());
                    break;
                case USER_EYE_COLOR:
                    user.setEyeColor(reader.nextString());
                    break;
                case USER_NAME:
                    user.setName(reader.nextString());
                    break;
                case USER_GENDER:
                    user.setGender(reader.nextString());
                    break;
                case USER_COMPANY:
                    user.setCompany(reader.nextString());
                    break;
                case USER_EMAIL:
                    user.setEmail(reader.nextString());
                    break;
                case USER_PHONE:
                    user.setPhone(reader.nextString());
                    break;
                case USER_ADDRESS:
                    user.setAddress(reader.nextString());
                    break;
                case USER_ABOUT:
                    user.setAbout(reader.nextString());
                    break;
                case USER_REGISTERED:
                    user.setRegistered(DateTimeConverter.toDateTime(reader.nextString()));
                    break;
                case USER_TAGS:
                    reader.beginArray();
                    List<String> tagList = new ArrayList<>();
                    while (reader.hasNext()) {
                        tagList.add(reader.nextString());
                    }
                    user.setTagList(tagList);
                    reader.endArray();
                    break;
                case USER_FRIENDS:
                    reader.beginArray();
                    List<Friend> friendList = new ArrayList<>();
                    while (reader.hasNext()) {
                        reader.beginObject();
                        Friend friend = new Friend();
                        friend.setUserId(user.getId());
                        while (reader.hasNext()) {
                            switch (reader.nextName()) {
                                case USER_ID:
                                    friend.setId(reader.nextInt());
                                    break;
                                case USER_NAME:
                                    friend.setName(reader.nextString());
                                    break;
                            }
                        }
                        friendList.add(friend);
                        reader.endObject();
                    }
                    user.setFriendList(friendList);
                    reader.endArray();
                    break;
                case USER_FAVORITE_FRUIT:
                    user.setFavoriteFruit(reader.nextString());
                    break;
            }
        }
        reader.endObject();
        return user;
    }
}
