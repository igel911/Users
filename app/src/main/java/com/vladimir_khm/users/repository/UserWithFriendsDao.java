package com.vladimir_khm.users.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.vladimir_khm.users.model.Friend;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.model.UserWithFriends;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserWithFriendsDao {

    @Query("SELECT * FROM user")
    @Transaction
    Single<List<UserWithFriends>> getUsersWithFriends();

    @Insert
    @Transaction
    void saveUserList(List<User> userList);

    @Insert
    @Transaction
    void saveFriendList(List<Friend> friendList);
}
