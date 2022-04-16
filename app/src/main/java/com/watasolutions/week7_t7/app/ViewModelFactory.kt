package com.watasolutions.week7_t7.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.watasolutions.week7_t7.screens.login.LoginViewModel

class ViewModelFactory(val app : MyApp) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(app.prefs) as T
        }
        throw IllegalArgumentException("unknown view model")
    }
}