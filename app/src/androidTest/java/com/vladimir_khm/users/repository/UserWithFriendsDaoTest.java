package com.vladimir_khm.users.repository;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.model.UserWithFriends;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class UserWithFriendsDaoTest {

    private AppDatabase mDatabase;
    private UserWithFriendsDao mUsersDao;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();


    @Before
    public void setUp() {
        mDatabase = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        mUsersDao = mDatabase.userWithFriendsDao();
    }

    @After
    public void tearDown() {
        mDatabase.close();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void whenInsertUsersThenReadThem() {
        List<User> userList = TestHelper.getPreparedUserList(3);
        mUsersDao.saveUserList(userList);
        mUsersDao.getUserList()
                .test()
                .assertValues(userList);
    }

    @Test
    public void whenInsertUserThenReadUserWithFriends() {
        List<User> userList = TestHelper.getPreparedUserList(1);
        mUsersDao.saveUserList(userList);
        UserWithFriends userBeforeSaving = TestHelper.getPreparedUserWithFriends(userList.get(0));
        mUsersDao.getUserWithFriends(userBeforeSaving.getUser().getId())
                .test()
                .assertValue(userBeforeSaving);
    }
}