package com.vladimir_khm.users.user_detail;

import com.arellomobile.mvp.MvpView;
import com.vladimir_khm.users.model.UserWithFriends;

public interface DetailView extends MvpView {

    void showUserWithFriends(UserWithFriends userWithFriends);
}
