package com.watasolutions.week7_t7

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences {

    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        private const val PREF_NAME = "shared_preference"
    }

    enum class KEY(val value: String) {
        KEY_USERNAME("KEY_USERNAME"),
        KEY_PASSWORD("KEY_PASSWORD"),
    }

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(Companion.PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveUsername(username: String) {
        sharedPreferences.edit().putString(KEY.KEY_USERNAME.value, username).apply()
    }

    fun getUsername(): String? {
        return sharedPreferences.getString(KEY.KEY_USERNAME.value, null)
    }

    fun savePassword(password: String){
        sharedPreferences.edit().putString(KEY.KEY_PASSWORD.value, password).apply()
    }

    fun getPassword() : String? {
        return sharedPreferences.getString(KEY.KEY_PASSWORD.value, "")
    }

}