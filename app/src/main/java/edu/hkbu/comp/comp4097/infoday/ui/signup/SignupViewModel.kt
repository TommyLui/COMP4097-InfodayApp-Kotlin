package edu.hkbu.comp.comp4097.infoday.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel : ViewModel() {
    val email = MutableLiveData<String>().apply {
        value = ""
    }
    val password = MutableLiveData<String>().apply {
        value = ""
    }
    val confirmPassword = MutableLiveData<String>().apply {
        value = ""
    }
    val displayName = MutableLiveData<String>().apply {
        value = ""
    }
    val avatarUrl = MutableLiveData<String>().apply {
        value = ""
    }
}