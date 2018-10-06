package com.vladimir_khm.users.user_detail;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vladimir_khm.users.R;
import com.vladimir_khm.users.databinding.ActivityUserDetailBinding;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.model.UserWithFriends;

import static android.widget.LinearLayout.VERTICAL;
import static com.vladimir_khm.users.Constants.USER_ID;

public class UserDetailActivity extends MvpAppCompatActivity implements DetailView {

    @InjectPresenter
    DetailPresenter mPresenter;
    private RecyclerView rvFriends;
    private RecyclerView rvTags;
    private ActivityUserDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail);
        rvFriends = binding.rvFriendsDetail;
        rvTags = binding.rvTagsDetail;

        rvFriends.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        rvFriends.addItemDecoration(
                new DividerItemDecoration(rvFriends.getContext(), VERTICAL));

        rvTags.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));

        String userId = getIntent().getStringExtra(USER_ID);
        mPresenter.viewIsReady(userId);
    }

    @Override
    public void showUserWithFriends(UserWithFriends userWithFriends) {
        User user = userWithFriends.getUser();
        binding.setUser(user);
        rvFriends.setAdapter(new FriendListAdapter(userWithFriends.getFriendList()));
        rvTags.setAdapter(new TagListAdapter(user.getTagList()));
    }
}
