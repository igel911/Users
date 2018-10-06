package com.vladimir_khm.users.main;

import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.vladimir_khm.users.BasePresenter;
import com.vladimir_khm.users.UsersApi;
import com.vladimir_khm.users.app.App;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.repository.UserWithFriendsDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static com.vladimir_khm.users.Constants.TAG;

@InjectViewState
public class UsersPresenter extends BasePresenter<UsersView> {

    @Inject
    UserWithFriendsDao mUserDao;
    @Inject
    UsersApi mUsersApi;


    UsersPresenter() {
        App.getComponent().injectUsers(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadUserListFromDB();
    }

    private void loadUserListFromDB() {
        Disposable subscribe = mUserDao.getUserList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userList -> {
                    if (userList.isEmpty()) {
                        Log.d(TAG, "load data from internet");
                        loadUserListFromNet();
                    } else {
                        Log.d(TAG, "load data from db");
                        showUserList(userList);
                    }
                });
        unsubscribeOnDestroy(subscribe);
    }

    private void showUserList(List<User> userList) {
        getViewState().showUserList(userList);
    }

    private void loadUserListFromNet() {
        mUsersApi.users()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new DisposableSingleObserver<List<User>>() {
                    @Override
                    public void onSuccess(@NonNull List<User> userList) {
                        mUserDao.saveUserList(userList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "UsersPresenter.loadUserListFromNet: " + e);
                    }
                });
    }

    void onItemSelected(User user) {
        getViewState().navigateToAnotherScreen(user.getId());
    }
}
