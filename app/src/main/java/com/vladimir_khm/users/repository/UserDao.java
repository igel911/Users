package com.vladimir_khm.users.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.vladimir_khm.users.model.Friend;
import com.vladimir_khm.users.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public abstract class UserDao {

    @Insert
    abstract void saveUser(User user);

    @Query("SELECT * FROM user")
    public abstract List<User> getUserList();

    public void saveUsersWithFriends(List<User> userList) {
        for (User user : userList) {
            saveUser(user);
            saveFriendList(user.getFriendList());
        }
    }

    public Single<List<User>> getUserListWithFriends() {
        return Single.fromCallable(() -> {
            List<User> userList = new ArrayList<>(getUserList());
            for (User user : userList) {
                List<Friend> friendList = getFriendList(user.getId());
                user.setFriendList(friendList);
            }
            return userList;
        });
    }

    @Insert
    abstract void saveFriendList(List<Friend> friend);

    @Query("SELECT * FROM friend WHERE friend.userId = :userId")
    abstract List<Friend> getFriendList(String userId);
}
