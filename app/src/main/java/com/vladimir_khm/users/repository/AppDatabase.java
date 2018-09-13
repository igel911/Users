package com.vladimir_khm.users.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.vladimir_khm.users.model.Friend;
import com.vladimir_khm.users.model.User;

@Database(entities = {User.class, Friend.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserWithFriendsDao userWithFriendsDao();
}
