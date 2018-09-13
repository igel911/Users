package com.vladimir_khm.users.main;

import com.vladimir_khm.users.model.UserWithFriends;

import java.util.List;

public interface MainContract {

    interface View {
        void showUserList(List<UserWithFriends> userList);

        void navigateToAnotherScreen(UserWithFriends user);
    }

    interface Presenter {
        void attachView(View view);

        void viewIsReady();

        void onItemSelected(UserWithFriends user);

        void detachView();
    }
}
