package com.app.ecommerceshopping.ui.login.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowManager
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.MainActivity
import com.app.ecommerceshopping.custom.classes.CustomAppCompatActivity
import com.app.ecommerceshopping.ui.home.activity.HomeActivity
import com.app.ecommerceshopping.utils.Constant
import com.app.todo.utils.MyPreferences

@SuppressLint("CustomSplashScreen")
class SplashActivity : CustomAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

//        fetchAndSaveFCM()
        initData()
    }

    /** This Function For Initialize **/
    override fun initData() {


//        if (MyPreferences.getFromPreferences(this, Constant.TOKEN).isNotEmpty()) {
//            MyPreferences.saveStringInPreference(this, Constant.IsLogin, "true")
//        } else {
//            MyPreferences.saveStringInPreference(this, Constant.IsLogin, "false")
//        }

        Log.e("isLoginCheck", ""+ MyPreferences.getFromPreferences(this, Constant.IsLogin))
//        Handler(Looper.getMainLooper()).postDelayed({
//            if (MyPreferences.getFromPreferences(this, Constant.TOKEN).isNotEmpty()) {
//                startActivity(Intent(this, HomeActivity::class.java)
//                    .putExtra("type","Home")
//                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
//            } else {
//                startActivity(Intent(this, LoginActivity::class.java)
//                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
//            }
//        }, 3000)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java)
                .putExtra("type","Home")
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }, 3000)

    }

    /** this function used for check fetch firebase token **/
//    private fun fetchAndSaveFCM() {
//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) { return@OnCompleteListener }
//            if (task.result != MyPreferences.getFromPreferences(this, Constant.FCM_TOKEN)) {
//                MyPreferences.saveStringInPreference(this, Constant.FCM_TOKEN , task.result)
//                Constant.USERTOKEN = MyPreferences.getFromPreferences(this, Constant.TOKEN)
//                Log.e("FCM_TOKEN","-->"+task.result)
//                Log.e("TOKEN","-->"+MyPreferences.getFromPreferences(this, Constant.TOKEN))
//                Log.e("UserToken","-->"+Constant.USERTOKEN)
//            }
//        })
//    }
}