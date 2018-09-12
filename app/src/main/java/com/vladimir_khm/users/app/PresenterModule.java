package com.vladimir_khm.users.app;

import android.arch.persistence.room.Room;

import com.vladimir_khm.users.UsersApi;
import com.vladimir_khm.users.main.MainContract;
import com.vladimir_khm.users.main.MainPresenter;
import com.vladimir_khm.users.repository.AppDatabase;
import com.vladimir_khm.users.repository.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.vladimir_khm.users.Constants.DATA_BASE_NAME;

@Module
public class PresenterModule {

    @Provides
    MainContract.Presenter provideMainPresenter(UserDao userDao, UsersApi usersApi) {
        return new MainPresenter(userDao, usersApi);
    }

    @Singleton
    @Provides
    UserDao provideRepository() {
        AppDatabase database = Room
                .databaseBuilder(App.getAppContext(), AppDatabase.class, DATA_BASE_NAME)
                .build();
        return database.userDao();
    }

    @Singleton
    @Provides
    UsersApi provideUserApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(UsersApi.class);
    }
}
