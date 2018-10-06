package com.vladimir_khm.users.user_detail;

import com.arellomobile.mvp.InjectViewState;
import com.vladimir_khm.users.BasePresenter;
import com.vladimir_khm.users.app.App;
import com.vladimir_khm.users.model.UserWithFriends;
import com.vladimir_khm.users.repository.UserWithFriendsDao;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class DetailPresenter extends BasePresenter<DetailView> {

    @Inject
    UserWithFriendsDao mUserDao;


    DetailPresenter() {
        App.getComponent().injectDetail(this);
    }

    void viewIsReady(String userId) {
        Disposable subscribe = mUserDao.getUserWithFriends(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showUserWithFriends);
        unsubscribeOnDestroy(subscribe);
    }

    private void showUserWithFriends(UserWithFriends userWithFriends) {
        getViewState().showUserWithFriends(userWithFriends);
    }
}
