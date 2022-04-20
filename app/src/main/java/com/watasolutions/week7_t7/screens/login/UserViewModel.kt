package com.watasolutions.week7_t7.screens.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.watasolutions.week7_t7.model.User
import com.watasolutions.week7_t7.service.UserDatabase
import com.watasolutions.week7_t7.service.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData : LiveData<List<User>>
    private val repository : UserRepository
    private var _saveEventSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val saveEventSuccess: LiveData<Boolean>
        get() = _saveEventSuccess
    init{

        val userDAO = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDAO)
        readAllData = repository.readAllData
    }
    fun addUser(user : User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
        _saveEventSuccess.value = true
    }

}