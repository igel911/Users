package com.vladimir_khm.users.main;

import android.support.annotation.NonNull;
import android.util.Log;

import com.vladimir_khm.users.UsersApi;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.model.UserWithFriends;
import com.vladimir_khm.users.repository.UserWithFriendsDao;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private UserWithFriendsDao mUserDao;
    private UsersApi mUsersApi;
    private List<UserWithFriends> mUserList;
    private Disposable subscribe;
    private final String TAG = "tag";


    public MainPresenter(UserWithFriendsDao userDao, UsersApi usersApi) {
        mUserDao = userDao;
        mUsersApi = usersApi;
    }

    @Override
    public void attachView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void viewIsReady() {
        loadUserListFromDB();
    }

    private void loadUserListFromDB() {
        subscribe = mUserDao.getUsersWithFriends()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userList -> {
                    mUserList = userList;
                    if (mUserList.isEmpty()) {
                        loadUserListFromNet();
                    } else {
                        Log.d(TAG, "load data from db");
                        showUserList();
                    }
                });
    }

    private void showUserList() {
        mView.showUserList(mUserList);
    }

    private void loadUserListFromNet() {
        Log.d(TAG, "load data from internet");
        mUsersApi.users()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new DisposableSingleObserver<List<User>>() {
                    @Override
                    public void onSuccess(@NonNull List<User> userList) {
                        mUserDao.saveUserList(userList);
                        for (User user : userList) {
                            mUserDao.saveFriendList(user.getFriendList());
                        }
                        loadUserListFromDB();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "MainPresenter.viewIsReady: " + e);
                    }
                });
    }

    @Override
    public void onItemSelected(UserWithFriends user) {
        mView.navigateToAnotherScreen(user);
    }

    @Override
    public void detachView() {
        mView = null;
        subscribe.dispose();
    }
}
