package com.vladimir_khm.users.main;

import com.vladimir_khm.users.model.User;

import java.util.List;

public interface MainContract {

    interface View {
        void showUserList(List<User> userList);

        void navigateToAnotherScreen(User user);
    }

    interface Presenter {
        void attachView(View view);

        void viewIsReady();

        void onItemSelected(User user);

        void detachView();
    }
}
