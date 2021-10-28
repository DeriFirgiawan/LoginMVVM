package com.learndev.loginmvvm.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var counter = 0
    private var statusLogin: Boolean = false

    fun increment() {
        counter++
    }

    fun checkUserLogin(context: Context): Boolean {
        val sharedPref = context.applicationContext.getSharedPreferences("userInformation", Context.MODE_PRIVATE)
        val userToken = sharedPref.getString("Token", null)
        Log.e("Token", userToken.toString())
        statusLogin = userToken != null
        return statusLogin
    }
}