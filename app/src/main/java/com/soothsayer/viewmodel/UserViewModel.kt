package com.soothsayer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soothsayer.model.UserModel
import com.soothsayer.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserViewModel : ViewModel{

    val userRepository:UserRepository
    var compositeDisposable:CompositeDisposable?= CompositeDisposable()
    var modelMutableLiveData : MutableLiveData<UserModel> = MutableLiveData()

    @Inject
    constructor(userRepository: UserRepository){
        this.userRepository = userRepository
    }

    fun getMutableLiveData():MutableLiveData<UserModel>{
        loadData()
        return modelMutableLiveData
    }

    fun loadData(){
        compositeDisposable?.add(userRepository.getUserDetail().observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<UserModel>() {
                override fun onSuccess(t: UserModel) {
                modelMutableLiveData.value= t
                }

                override fun onError(e: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }))
    }
}


