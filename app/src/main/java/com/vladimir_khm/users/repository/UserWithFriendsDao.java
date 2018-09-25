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

@Dao
public interface UserWithFriendsDao {

    @Query("SELECT * FROM user")
    @Transaction
    Flowable<List<UserWithFriends>> getUsersWithFriends();

    @Insert
    void saveUserList(List<User> userList);

    @Insert
    void saveFriendList(List<Friend> friendList);
}
