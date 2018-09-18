package com.vladimir_khm.users.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.vladimir_khm.users.model.UserWithFriends;

import java.util.List;

public interface MainView extends MvpView {

    void showUserList(List<UserWithFriends> userList);

    @StateStrategyType(SkipStrategy.class)
    void navigateToAnotherScreen(UserWithFriends user);
}
