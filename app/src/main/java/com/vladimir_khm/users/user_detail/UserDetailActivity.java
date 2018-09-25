package com.vladimir_khm.users.user_detail;


import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.vladimir_khm.users.R;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.model.UserWithFriends;
import com.vladimir_khm.users.util.DateTimeConverter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.LinearLayout.VERTICAL;
import static com.vladimir_khm.users.Constants.USER_ID;

public class UserDetailActivity extends MvpAppCompatActivity implements DetailView {

    @BindView(R.id.imageViewDetail) ImageView mImageView;
    @BindView(R.id.tvUserNameDetail) TextView tvUserName;
    @BindView(R.id.tvUserCompanyDetail) TextView tvUserCompany;
    @BindView(R.id.tvUserGenderDetail) TextView tvUserGender;
    @BindView(R.id.tvUserIDDetail) TextView tvUserID;
    @BindView(R.id.tvUserIsActiveDetail) TextView tvUserIsActive;
    @BindView(R.id.tvUserBalanceDetail) TextView tvUserBalance;
    @BindView(R.id.tvUserAgeDetail) TextView tvUserAge;
    @BindView(R.id.tvUserEyeColorDetail) TextView tvUserEyeColor;
    @BindView(R.id.tvUserEmailDetail) TextView tvUserEmail;
    @BindView(R.id.tvUserPhoneDetail) TextView tvUserPhone;
    @BindView(R.id.tvUserAddressDetail) TextView tvUserAddress;
    @BindView(R.id.tvUserAboutDetail) TextView tvUserAbout;
    @BindView(R.id.tvUserRegisteredDetail) TextView tvUserRegistered;
    @BindView(R.id.tvUserFavoriteFruitDetail) TextView tvUserFavoriteFruit;
    @BindView(R.id.tvUserTagsDetail) TextView tvUserTags;
    @BindView(R.id.recyclerViewDetail) RecyclerView mRecyclerView;
    @InjectPresenter DetailPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerView.getContext(), VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        String userId = getIntent().getStringExtra(USER_ID);
        mPresenter.viewIsReady(userId);
    }

    @Override
    public void showUserWithFriends(UserWithFriends userWithFriends) {
        User user = userWithFriends.getUser();
        Glide.with(this)
                .load(user.getPictureUrl())
                .into(mImageView);
        tvUserName.setText(user.getName());
        tvUserCompany.setText(user.getCompany());
        tvUserGender.setText(user.getGender());
        tvUserID.setText(user.getId());
        tvUserIsActive.setText(String.valueOf(user.isActive()));
        tvUserBalance.setText(user.getBalance());
        tvUserAge.setText(String.valueOf(user.getAge()));
        tvUserEyeColor.setText(user.getEyeColor());
        tvUserEmail.setText(user.getEmail());
        tvUserPhone.setText(user.getPhone());
        tvUserAddress.setText(user.getAddress());
        tvUserAbout.setText(user.getAbout());
        tvUserRegistered.setText(DateTimeConverter.toString(user.getRegistered()));
        tvUserFavoriteFruit.setText(user.getFavoriteFruit());
        tvUserTags.setText(user.getTags());

        mRecyclerView.setAdapter(new RecyclerAdapterDetail(userWithFriends.getFriendList()));
    }
}
