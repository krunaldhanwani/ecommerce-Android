package com.app.todo.retrofit

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.app.ECommerceShopping.R
import com.app.ecommerceshopping.EcommerceShopping
import com.app.ecommerceshopping.utils.ConnectivityCheckingClass
import com.app.ecommerceshopping.utils.Constant
import com.app.todo.utils.MyPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyCallAdapter<T>(private val call : Call<T>) : MyCall<T> {

    private var isInternetStatusShow = false

    override fun enqueue(callback: MyCallback<T>) {
        if (!isInternetStatusShow) {
            if (!ConnectivityCheckingClass.isNetworkAvailable(EcommerceShopping.context)) {
                Toast.makeText(
                    EcommerceShopping.context,
                    EcommerceShopping.context.getString(R.string.internet_not_available), Toast.LENGTH_SHORT).show()
                isInternetStatusShow = true
                callback.networkError()
                return
            }
        }

        Log.i("REQUEST_BODY",call.request().toString())

        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                try {
                    when {
                        response.code() == 200 -> {
                            Log.v("API_RESPONSE", "$response")
                            callback.success(response)
                        }
                        response.code() == 401 -> {
                            Log.v("API_RESPONSE", "${response.errorBody()!!}")
                            callback.authError()
                            val fcmToken = MyPreferences.getFromPreferences(EcommerceShopping.context, Constant.FCM_TOKEN)
                            MyPreferences.clearData(EcommerceShopping.context)
                            MyPreferences.saveStringInPreference(EcommerceShopping.context, Constant.FCM_TOKEN, fcmToken)
//                            EcommerceShopping.context.startActivity(Intent(EcommerceShopping.context, LoginActivity::class.java)
//                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))

                        }
                        response.code() == 403 -> {
                            callback.authError()
                           /* val fcmToken = MyPreferences.getFromPreferences(FOREAL.context, Constant.FCM_TOKEN)
                            MyPreferences.clearData(FOREAL.context)
                            MyPreferences.saveStringInPreference(FOREAL.context, Constant.FCM_TOKEN, fcmToken.toString())*/

//                            FOREAL.context.startActivity(Intent(FOREAL.context, LoginActivity::class.java)
//                                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
                        }
                        else -> {
                            Log.v("API_RESPONSE", "${response.errorBody()!!.byteString()}")
                            val error = response.errorBody()!!.string()
                            val gson = Gson()
//                            val type = object : TypeToken<ErrorModel>() {}.type
//                            val errorResponse: ErrorModel? = gson.fromJson(error, type)
//                            callback.serverError(errorResponse!!.message, errorResponse.statusCode)
                        }
                    }
                } catch (e: Exception) {
                    Log.v("API_RESPONSE", "api exception ${e.message}")
                    callback.serverError("api exception ${e.message}", response.code())
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                Log.v("API_RESPONSE", "api failure ${t.message}")
                callback.serverError("   api failure   ${t.message}", 405)
            }
        })
    }

    override fun cancel() {
        call.cancel()
    }
}