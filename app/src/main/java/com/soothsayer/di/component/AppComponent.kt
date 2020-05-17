package com.soothsayer.di.component

import com.soothsayer.MainActivity
import com.soothsayer.di.modules.ContextModule
import com.soothsayer.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetworkModule::class,ContextModule::class))
interface AppComponent{
    fun inject(activity: MainActivity)
}