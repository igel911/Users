package com.vladimir_khm.users.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vladimir_khm.users.R;
import com.vladimir_khm.users.app.App;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.user_detail.UserDetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.LinearLayout.VERTICAL;
import static com.vladimir_khm.users.Constants.USER;

public class MainActivity extends AppCompatActivity
        implements OnItemClickListener, MainContract.View {

    @BindView(R.id.recyclerViewMain) RecyclerView mRecyclerView;
    @Inject MainContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.getComponent().injectsMainActivity(this);
        mPresenter.attachView(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerView.getContext(), VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mPresenter.viewIsReady();
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
    public void navigateToAnotherScreen(User user) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(USER, user);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
