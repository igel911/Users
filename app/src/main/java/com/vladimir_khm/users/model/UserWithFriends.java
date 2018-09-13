package com.vladimir_khm.users.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.io.Serializable;
import java.util.List;

public class UserWithFriends implements Serializable {

    @Embedded private User user;
    @Relation(parentColumn = "mId", entityColumn = "userId") private List<Friend> friendList;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }
}
