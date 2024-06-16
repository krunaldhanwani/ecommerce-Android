package com.app.ecommerceshopping.ui.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.custom.classes.CustomAppCompatActivity

class ForgetPasswordActivity : CustomAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
        initData()
    }

    override fun initData() {
    }
}