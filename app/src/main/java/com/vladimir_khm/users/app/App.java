package com.vladimir_khm.users.app;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static AppComponent sComponent;
    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sComponent = DaggerAppComponent.create();
        sInstance = this;
    }

    public static AppComponent getComponent() {
        return sComponent;
    }

    public static Context getAppContext() {
        return sInstance;
    }
}
