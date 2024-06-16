package com.app.ecommerceshopping.custom.classes

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.utils.ConnectionLiveData
import com.app.ecommerceshopping.utils.InitApplication
import com.app.ecommerceshopping.utils.LoadingDialog

abstract class CustomAppCompatActivity : AppCompatActivity() {

    private lateinit var context : Context
    private lateinit var loadingDialog: LoadingDialog
    private var initApplication: InitApplication? = null
    private var isInternetAvailable = false
    private var firstTime = true
    private var imageFile = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        ConnectionLiveData(this).observe(this) { t ->
            isInternetAvailable = t
            if (!firstTime) {

                /*                val string = if (t) "Internet back" else "Internet Lost"
                    Snackbar.make(window.decorView.rootView, string, Snackbar.LENGTH_LONG).setAction("CLOSE") { }.setActionTextColor(resources.getColor(android.R.color.holo_red_light)).show()*/

            }
            firstTime = false
        }
        loadingDialog = LoadingDialog(this)
    }

    open fun checkAppVersion(activity: AppCompatActivity?) {
//        var installedVersion = 0.0
//        var appVersion = 0.0
//        var version: String? = null
//        try {
//            val pInfo = packageManager.getPackageInfo(packageName, 0)
//            version = pInfo.versionName
//            installedVersion = pInfo.versionName.toDouble()
//
//            if (Constant.versionCode.isNotEmpty()) {
//                appVersion = Constant.versionCode.toDouble()
//            }
//        } catch (e: PackageManager.NameNotFoundException) {
//            e.printStackTrace()
//        }
//
//        if (Constant.versionCode.isNotEmpty()) {
//            if (installedVersion < appVersion) {
//                Constant.alreadyShowUpdate = 1
//                startActivity(Intent(context, AppUpdateActivity::class.java)
//                    .putExtra("isForceUpdate",Constant.isAndroidForceUpdate)
//                    .putExtra("updateMessage",Constant.updateMessage)
//                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
//            }
//        }
    }


    override fun onResume() {
        super.onResume()
        firstTime = true
    }

    fun openUrlInBrowser(view: View ,url : String ){
        view.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }
    }

    override fun setContentView(layoutResID: Int) {
        initApplication = InitApplication(this)
        if (initApplication!!.state) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        super.setContentView(layoutResID)


    }

    abstract fun initData()

    fun showToast(message: String = getString(R.string.something_went_wrong_)) {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }

    fun startActivity(cls: Class<*>?) {
        val intent = Intent(this, cls)
        super.startActivity(intent)
    }

    fun showLoadingDialog() {
        if (this::loadingDialog.isInitialized && !loadingDialog.isShowing()) {
            loadingDialog.show()
        }
    }

    fun changeLoadingStatus(show: Boolean) {
        if (show) showLoadingDialog()
        else hideLoadingDialog()
    }

    fun showLoadingDialog(title: String) {
        showLoadingDialog()
    }

    fun showHidePass(editText: EditText, imageView: ImageView) {
        if (editText.transformationMethod == PasswordTransformationMethod.getInstance()) {
            imageView.setImageResource(R.drawable.ic_eye_open)
            //Show Password
            editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            imageView.setImageResource(R.drawable.ic_eye_close)
            //Hide Password
            editText.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        editText.setSelection( editText.text.toString().length )
    }

    fun hideLoadingDialog() {
        if (this::loadingDialog.isInitialized && loadingDialog.isShowing()) {
            loadingDialog.dismiss()
        }
    }

    fun showInternetErrorDialog() {
        showToast("Internet not available")
    }

    fun showAuthErrorDialog() {
        showToast("Auth Error")
    }
}