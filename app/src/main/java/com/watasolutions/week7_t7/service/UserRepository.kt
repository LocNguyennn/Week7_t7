package com.watasolutions.week7_t7.service

import androidx.lifecycle.LiveData
import com.watasolutions.week7_t7.dao.UserDAO
import com.watasolutions.week7_t7.model.User

class UserRepository(private val userDAO: UserDAO) {
    val readAllData : LiveData<List<User>> = userDAO.readAllData()

    suspend fun addUser(user : User){
        userDAO.addUser(user)
    }
}