package com.vladimir_khm.users.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.JsonAdapter;
import com.vladimir_khm.users.repository.DaoConverters;
import com.vladimir_khm.users.util.DateTimeConverter;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (mIsActive != user.mIsActive) return false;
        if (mAge != user.mAge) return false;
        if (!mId.equals(user.mId)) return false;
        if (mBalance != null ? !mBalance.equals(user.mBalance) : user.mBalance != null)
            return false;
        if (mPictureUrl != null ? !mPictureUrl.equals(user.mPictureUrl) : user.mPictureUrl != null)
            return false;
        if (mEyeColor != null ? !mEyeColor.equals(user.mEyeColor) : user.mEyeColor != null)
            return false;
        if (mName != null ? !mName.equals(user.mName) : user.mName != null) return false;
        if (mGender != null ? !mGender.equals(user.mGender) : user.mGender != null) return false;
        if (mCompany != null ? !mCompany.equals(user.mCompany) : user.mCompany != null)
            return false;
        if (mEmail != null ? !mEmail.equals(user.mEmail) : user.mEmail != null) return false;
        if (mPhone != null ? !mPhone.equals(user.mPhone) : user.mPhone != null) return false;
        if (mAddress != null ? !mAddress.equals(user.mAddress) : user.mAddress != null)
            return false;
        if (mAbout != null ? !mAbout.equals(user.mAbout) : user.mAbout != null) return false;
        if (mFavoriteFruit != null ? !mFavoriteFruit.equals(user.mFavoriteFruit) : user.mFavoriteFruit != null)
            return false;
        if (mRegistered != null
                ? !DateTimeConverter.toString(mRegistered).equals(DateTimeConverter.toString(user.mRegistered))
                : user.mRegistered != null)
            return false;
        return !(mTagList != null ? !mTagList.equals(user.mTagList) : user.mTagList != null);
    }

    @Override
    public int hashCode() {
        int result = mId.hashCode();
        result = 31 * result + (mIsActive ? 1 : 0);
        result = 31 * result + mAge;
        result = 31 * result + (mBalance != null ? mBalance.hashCode() : 0);
        result = 31 * result + (mPictureUrl != null ? mPictureUrl.hashCode() : 0);
        result = 31 * result + (mEyeColor != null ? mEyeColor.hashCode() : 0);
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mGender != null ? mGender.hashCode() : 0);
        result = 31 * result + (mCompany != null ? mCompany.hashCode() : 0);
        result = 31 * result + (mEmail != null ? mEmail.hashCode() : 0);
        result = 31 * result + (mPhone != null ? mPhone.hashCode() : 0);
        result = 31 * result + (mAddress != null ? mAddress.hashCode() : 0);
        result = 31 * result + (mAbout != null ? mAbout.hashCode() : 0);
        result = 31 * result + (mFavoriteFruit != null ? mFavoriteFruit.hashCode() : 0);
        result = 31 * result + (mRegistered != null ? DateTimeConverter.toString(mRegistered).hashCode() : 0);
        result = 31 * result + (mTagList != null ? mTagList.hashCode() : 0);
        return result;
    }
}


