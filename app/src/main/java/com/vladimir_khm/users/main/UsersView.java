package com.vladimir_khm.users.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.vladimir_khm.users.model.User;

import java.util.List;

public interface UsersView extends MvpView {

    void showUserList(List<User> userList);

    @StateStrategyType(SkipStrategy.class)
    void navigateToAnotherScreen(String userId);
}
