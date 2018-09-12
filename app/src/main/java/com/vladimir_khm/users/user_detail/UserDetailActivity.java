package com.vladimir_khm.users.user_detail;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vladimir_khm.users.R;
import com.vladimir_khm.users.model.User;
import com.vladimir_khm.users.util.DateTimeConverter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.LinearLayout.VERTICAL;
import static com.vladimir_khm.users.Constants.USER;

public class UserDetailActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);

        User user = (User) getIntent().getSerializableExtra(USER);
        Picasso.get()
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

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, VERTICAL, false));
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(mRecyclerView.getContext(), VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(new RecyclerAdapterDetail(user.getFriendList()));
    }
}
