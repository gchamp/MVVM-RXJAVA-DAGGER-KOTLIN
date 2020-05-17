package com.soothsayer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory : ViewModelProvider.Factory{

    var creators : Map<Class<out ViewModel>,Provider<ViewModel>>?

    @Inject
    constructor(creators : Map<Class<out ViewModel>,Provider<ViewModel>>?){
        this.creators = creators
    }
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    var creator : Provider<ViewModel>? = creators?.get(modelClass)
    for (entry : Map.Entry<Class<out ViewModel>,Provider<ViewModel>> in creators?.entries!!){
if (modelClass.isAssignableFrom(entry.key))
    creator = entry.value
        break
    }
        return creator?.get() as T
    }

}