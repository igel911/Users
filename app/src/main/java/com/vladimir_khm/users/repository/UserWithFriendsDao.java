package com.vladimir_khm.users.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.vladimir_khm.users.model.Friend;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.model.UserWithFriends;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public abstract class UserWithFriendsDao {

    @Transaction
    @Query("SELECT * FROM user WHERE mId = :userId")
    public abstract Single<UserWithFriends> getUserWithFriends(String userId);

    @Transaction
    @Query("SELECT * FROM user")
    public abstract Flowable<List<User>> getUserList();

    @Insert
    @Transaction
    public void saveUserList(List<User> userList) {
        insertUserList(userList);
        for (User user : userList) {
            insertFriendList(user.getFriendList());
        }
    }

    @Insert
    abstract void insertUserList(List<User> userList);

    @Insert
    abstract void insertFriendList(List<Friend> friendList);
}
