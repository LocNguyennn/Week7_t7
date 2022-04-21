package com.watasolutions.week7_t7.service

import androidx.lifecycle.LiveData
import com.watasolutions.week7_t7.dao.UserDAO
import com.watasolutions.week7_t7.model.User

class UserRepository(private val userDAO: UserDAO) {
    suspend fun loadUser() : List<User>{
        return userDAO.readAllData()
    }

    suspend fun addUser(user : User){
        userDAO.addUser(user)
    }
}