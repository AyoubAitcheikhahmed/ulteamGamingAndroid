package com.banibegood.ulteam_gaming.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String>
    get() = _username


    public fun setUsername(username: String){
        _username.value = username
    }

}