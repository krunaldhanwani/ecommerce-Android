package com.app.ecommerceshopping.ui.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.custom.classes.CustomAppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : CustomAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    override fun initData() {
        llMale.setOnClickListener {
            rbMale.isChecked = true
            rbFemale.isChecked = false
            rbOther.isChecked = false
//            gender = Constant.MALE
        }

        llFemale.setOnClickListener {
            rbFemale.isChecked = true
            rbMale.isChecked = false
            rbOther.isChecked = false
//            gender = Constant.FEMALE
        }

        llOther.setOnClickListener {
            rbMale.isChecked = false
            rbFemale.isChecked = false
            rbOther.isChecked = true
//            gender = Constant.OTHER
        }
    }


}