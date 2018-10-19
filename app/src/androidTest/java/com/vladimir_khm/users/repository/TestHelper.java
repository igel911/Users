package com.vladimir_khm.users.repository;

import com.vladimir_khm.users.model.Friend;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.model.UserWithFriends;
import com.vladimir_khm.users.util.DateTimeConverter;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;


public class TestHelper {

    private TestHelper() {}

    static List<User> getPreparedUserList(int countOfUsers) {
        List<User> preparedUserList = new ArrayList<>();
        for (int i = 0; i < countOfUsers; i++) {
            List<String> tagList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                tagList.add("" + j + i);
            }
            List<Friend> friendList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Friend friend = new Friend();
                friend.setId(j);
                friend.setName("" + j + i);
                friend.setUserId("" + i);
                friendList.add(friend);
            }
            User user = new User();
            user.setId("" + i);
            user.setIsActive(i % 2 == 0);
            user.setAge(i);
            user.setBalance("" + i);
            user.setPictureUrl("" + i);
            user.setEyeColor("" + i);
            user.setName("" + i);
            user.setGender("" + i);
            user.setCompany("" + i);
            user.setEmail("" + i);
            user.setPhone("" + i);
            user.setAddress("" + i);
            user.setAbout("" + i);
            user.setFavoriteFruit("" + i);
            user.setRegistered(DateTime.now());
            user.setTagList(tagList);
            user.setFriendList(friendList);

            preparedUserList.add(user);
        }
        return preparedUserList;
    }

    public static UserWithFriends getPreparedUserWithFriends(User user) {
        UserWithFriends userWithFriends = new UserWithFriends();
        userWithFriends.setUser(user);
        userWithFriends.setFriendList(user.getFriendList());
        return userWithFriends;
    }
}
