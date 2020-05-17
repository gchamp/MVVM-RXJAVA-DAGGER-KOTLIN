package com.soothsayer.di.modules

import com.soothsayer.remote.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = arrayOf(ViewModelModule::class))
abstract class NetworkModule{
    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun providerRetrofit() : Retrofit= Retrofit.Builder()
                .baseUrl("https://livesurvey.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()



        @JvmStatic
        @Provides
        @Singleton
        fun providerService(retrofit: Retrofit) : UserService= retrofit.create(UserService::class.java)

    }


}