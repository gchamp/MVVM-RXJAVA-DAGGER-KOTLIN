package com.soothsayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.soothsayer.databinding.ActivityMainBinding
import com.soothsayer.model.UserModel
import com.soothsayer.viewmodel.UserViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    @Inject
    lateinit var provider: ViewModelProvider.Factory
    lateinit var userViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as BaseApplication).appComponent.inject(this)
        userViewModel = ViewModelProviders.of(this,provider).get(UserViewModel::class.java)
        userViewModel.modelMutableLiveData.observe(this, object : Observer<UserModel> {
            override fun onChanged(t: UserModel?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}
