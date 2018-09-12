package com.vladimir_khm.users.app;

import com.vladimir_khm.users.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PresenterModule.class})
public interface AppComponent {

    void injectsMainActivity(MainActivity mainActivity);
}
