package com.learndev.loginmvvm.data

import android.util.Log

class LoginRepository {
    private var userToken: String? = null
    fun makeLogin(email: String, password: String): String {
        Log.e("Email", email.toString())
        Log.e("Password", password.toString())
        userToken = "123"
        return userToken as String
    }
}