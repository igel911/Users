package com.vladimir_khm.users.app;

import com.vladimir_khm.users.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PresenterModule.class})
public interface AppComponent {

    void inject(MainPresenter mainPresenter);
}
