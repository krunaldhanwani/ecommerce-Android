package com.app.ecommerceshopping

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.app.ecommerceshopping.utils.Constant
import com.app.todo.utils.MyPreferences

@SuppressLint("StaticFieldLeak")
class EcommerceShopping : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        if (MyPreferences.getFromPreferences(this, Constant.TOKEN).toString().isNotEmpty()) {
            Constant.USERTOKEN = MyPreferences.getFromPreferences(this, Constant.TOKEN).toString()
        }
    }
}
