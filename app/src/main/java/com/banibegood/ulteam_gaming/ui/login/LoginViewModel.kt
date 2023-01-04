package com.banibegood.ulteam_gaming.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is LOGIN Fragment"
    }
    val text: LiveData<String> = _text
}