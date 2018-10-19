package com.vladimir_khm.users.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class UserWithFriends {

    @Embedded
    private User user;
    @Relation(parentColumn = "mId", entityColumn = "userId")
    private List<Friend> friendList;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserWithFriends that = (UserWithFriends) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return friendList != null ? friendList.equals(that.friendList) : that.friendList == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (friendList != null ? friendList.hashCode() : 0);
        return result;
    }
}
