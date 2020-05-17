package com.soothsayer.repository

import com.soothsayer.model.UserModel
import com.soothsayer.remote.UserService
import io.reactivex.Single
import javax.inject.Inject

class UserRepository{

    lateinit var userService:UserService

    @Inject
    constructor(userService: UserService){
        this.userService = userService
    }

    fun getUserDetail():Single<UserModel>{
        return userService.getUserDetails()
    }
}