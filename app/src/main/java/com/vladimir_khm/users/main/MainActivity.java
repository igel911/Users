package com.vladimir_khm.users.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vladimir_khm.users.R;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.user_detail.UserDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.LinearLayout.VERTICAL;
import static com.vladimir_khm.users.Constants.USER_ID;

public class MainActivity extends MvpAppCompatActivity implements OnItemClickListener, MainView {

    @BindView(R.id.recyclerViewMain) RecyclerView mRecyclerView;
    @InjectPresenter MainPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerView.getContext(), VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(User user) {
        mPresenter.onItemSelected(user);
    }

    @Override
    public void showUserList(List<User> userList) {
        mRecyclerView.setAdapter(new RecyclerAdapterMain(userList, this));
    }

    @Override
    public void navigateToAnotherScreen(String userId) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(USER_ID, userId);
        startActivity(intent);
    }
}
