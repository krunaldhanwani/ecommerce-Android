package com.app.ecommerceshopping.ui.login.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.custom.classes.CustomAppCompatActivity
import com.app.ecommerceshopping.ui.home.activity.HomeActivity
import com.app.todo.utils.isValidEmail
import kotlinx.android.synthetic.main.activity_authentication.*

class AuthenticationActivity : CustomAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        initData()
        setOnViewClicks()
    }

    override fun initData() {
        var account = getString(R.string.don_t_have_an_account_sign_up)
        account = account.replace("Sign Up", "<font color='#FF725E'><b>Sign Up</b></font>")
        tvSignUp.text = Html.fromHtml(account)
    }

    private fun validation() {
        if (etEmail.text.toString().trim().isEmpty()) { showToast("Please enter email address") }

        else if (!etEmail.text.toString().trim().isValidEmail()) { showToast("please enter valid email address") }

        else if (etPassword.text.toString().trim().isEmpty()) { showToast("Please enter a password") }

        else if (etPassword.text.toString().trim().length < 6) { showToast("Password should be at least of 6 character") }

        else{ startActivity(Intent(this,HomeActivity::class.java))}
    }

    private fun setOnViewClicks() {
        tvLogin.setOnClickListener {
            validation()
        }
    }
}