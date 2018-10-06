package com.vladimir_khm.users.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.JsonAdapter;
import com.vladimir_khm.users.repository.DaoConverters;

import org.joda.time.DateTime;

import java.util.List;

@Entity
@JsonAdapter(UserTypeAdapter.class)
@TypeConverters({DaoConverters.class})
public class User {

    @NonNull
    @PrimaryKey
    private String mId = "";
    private boolean mIsActive;
    private int mAge;
    private String mBalance;
    private String mPictureUrl;
    private String mEyeColor;
    private String mName;
    private String mGender;
    private String mCompany;
    private String mEmail;
    private String mPhone;
    private String mAddress;
    private String mAbout;
    private String mFavoriteFruit;
    private DateTime mRegistered;
    private List<String> mTagList;
    @Ignore
    private List<Friend> mFriendList;



    public void setAddress(String address) {
        mAddress = address;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getGender() {
        return mGender;
    }

    public void setAbout(String about) {
        mAbout = about;
    }

    public String getAbout() {
        return mAbout;
    }

    public void setRegistered(DateTime registered) {
        mRegistered = registered;
    }

    public DateTime getRegistered() {
        return mRegistered;
    }

    public void setIsActive(boolean isActive) {
        mIsActive = isActive;
    }

    public boolean isActive() {
        return mIsActive;
    }

    public void setPictureUrl(String picture) {
        mPictureUrl = picture;
    }

    public String getPictureUrl() {
        return mPictureUrl;
    }

    public void setFriendList(List<Friend> friendList) {
        mFriendList = friendList;
    }

    public List<Friend> getFriendList() {
        return mFriendList;
    }

    public void setTagList(List<String> tagList) {
        mTagList = tagList;
    }

    public List<String> getTagList() {
        return mTagList;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        mFavoriteFruit = favoriteFruit;
    }

    public String getFavoriteFruit() {
        return mFavoriteFruit;
    }

    public void setBalance(String balance) {
        mBalance = balance;
    }

    public String getBalance() {
        return mBalance;
    }

    public void setEyeColor(String eyeColor) {
        mEyeColor = eyeColor;
    }

    public String getEyeColor() {
        return mEyeColor;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setCompany(String company) {
        mCompany = company;
    }

    public String getCompany() {
        return mCompany;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public int getAge() {
        return mAge;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getEmail() {
        return mEmail;
    }
}


