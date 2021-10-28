package com.learndev.loginmvvm.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.learndev.loginmvvm.data.LoginRepository

class LoginViewModel: ViewModel() {
    private var isLogin: Boolean = false
    fun login(email: String, password: String, context: Context): Boolean {
        val sharedPref = context.applicationContext.getSharedPreferences("userInformation", Context.MODE_PRIVATE)
        val result = LoginRepository().makeLogin(email, password)
        if (result != "") {
            sharedPref.edit().putString("Token", result).apply()
            isLogin = true
        } else {
            Log.e("Error", result)
        }
        return isLogin
    }

    fun changedInput(email: String, password: String) {
        
    }
}