package com.vladimir_khm.users.main;

import android.support.annotation.NonNull;
import android.util.Log;

import com.vladimir_khm.users.UsersApi;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.repository.UserDao;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private UserDao mUserDao;
    private UsersApi mUsersApi;
    private List<User> mUserList;
    private Disposable subscribe;
    private final String TAG = "tag";


    public MainPresenter(UserDao userDao, UsersApi usersApi) {
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
        subscribe = mUserDao.getUserListWithFriends()
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
                        mUserDao.saveUsersWithFriends(userList);
                        loadUserListFromDB();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "MainPresenter.viewIsReady: " + e);
                    }
                });
    }

    @Override
    public void onItemSelected(User user) {
        mView.navigateToAnotherScreen(user);
    }

    @Override
    public void detachView() {
        mView = null;
        subscribe.dispose();
    }
}
