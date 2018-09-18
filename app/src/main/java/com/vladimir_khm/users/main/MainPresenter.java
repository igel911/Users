package com.vladimir_khm.users.main;

import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vladimir_khm.users.UsersApi;
import com.vladimir_khm.users.app.App;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.model.UserWithFriends;
import com.vladimir_khm.users.repository.UserWithFriendsDao;

import java.util.List;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject UserWithFriendsDao mUserDao;
    @Inject UsersApi mUsersApi;
    private List<UserWithFriends> mUserList;
    private final String TAG = "tag";
    private Disposable subscribe;


    MainPresenter() {
        App.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
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
        getViewState().showUserList(mUserList);
        subscribe.dispose();
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

    public void onItemSelected(UserWithFriends user) {
        getViewState().navigateToAnotherScreen(user);
    }
}
