package com.vladimir_khm.users.app;

import com.vladimir_khm.users.main.UsersPresenter;
import com.vladimir_khm.users.user_detail.DetailPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PresenterModule.class})
public interface AppComponent {

    void injectUsers(UsersPresenter usersPresenter);

    void injectDetail(DetailPresenter detailPresenter);
}
