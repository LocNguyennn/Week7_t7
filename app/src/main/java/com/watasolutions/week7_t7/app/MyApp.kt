package com.watasolutions.week7_t7.app

import android.app.Application
import com.watasolutions.week7_t7.MySharedPreferences

class MyApp : Application() {
    lateinit var prefs : MySharedPreferences
    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences()
        prefs.init(this)
    }
}