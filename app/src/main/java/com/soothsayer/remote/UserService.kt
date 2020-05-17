package com.soothsayer.remote

import com.soothsayer.model.UserModel
import io.reactivex.Single
import retrofit2.http.GET

interface UserService{
    @GET("/user")
    fun getUserDetails(): Single<UserModel>
}