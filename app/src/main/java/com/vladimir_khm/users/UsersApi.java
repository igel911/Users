package com.vladimir_khm.users;

import com.vladimir_khm.users.model.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface UsersApi {

    @GET("59c92a123f0000780183f72d")
    Single<List<User>> users();
}
