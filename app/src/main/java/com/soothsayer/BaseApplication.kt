package com.soothsayer

import android.app.Application
import com.soothsayer.di.component.AppComponent
import com.soothsayer.di.component.DaggerAppComponent

class BaseApplication : Application(){

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}