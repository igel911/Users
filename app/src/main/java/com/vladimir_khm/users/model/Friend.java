package com.vladimir_khm.users.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;


import java.io.Serializable;

@Entity(primaryKeys = {"friend_id", "friend_name"}, foreignKeys =
@ForeignKey(entity = User.class, parentColumns = "mId", childColumns = "userId"),
        indices = {@Index("userId")})
public class Friend implements Serializable {

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
}