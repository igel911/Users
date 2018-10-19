package com.vladimir_khm.users.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;



@Entity(primaryKeys = {"friend_id", "friend_name"}, foreignKeys =
@ForeignKey(entity = User.class, parentColumns = "mId", childColumns = "userId"),
        indices = {@Index("userId")})
public class Friend {

    @ColumnInfo(name = "friend_id")
    private int mId;
    @ColumnInfo(name = "friend_name")
    @NonNull
    private String mName = "";
    private String userId;


    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        if (mId != friend.mId) return false;
        if (!mName.equals(friend.mName)) return false;
        return userId != null ? userId.equals(friend.userId) : friend.userId == null;
    }

    @Override
    public int hashCode() {
        int result = mId;
        result = 31 * result + mName.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}