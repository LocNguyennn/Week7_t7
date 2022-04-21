package com.watasolutions.week7_t7.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.watasolutions.week7_t7.model.User


@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user : User)

    @Query("SELECT * FROM user ORDER BY username ASC")
    suspend fun readAllData() : List<User>

}