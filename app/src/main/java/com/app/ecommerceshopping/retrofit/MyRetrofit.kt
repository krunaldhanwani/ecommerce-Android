package com.app.ecommerceshopping.retrofit

import android.util.Log
import com.app.ECommerceShopping.BuildConfig
import com.app.ecommerceshopping.utils.Constant
import com.app.todo.retrofit.CustomCallAdapter
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MyRetrofit {

    companion object {
//        private const val baseUrl: String = "https://todoapp.almightyinfotech.com/api/"
        private const val baseUrl: String = "https://2dotrips.com/api/"

        lateinit var client: OkHttpClient

        private val headerInterceptor = Interceptor { chain ->
            Log.i("API_RESPONSE", "headerInterceptor called")
            var request = chain.request()

            request = if(Constant.TOKEN.isNotEmpty()) {
                request.newBuilder()
                        .addHeader("Authorization", "Bearer ${Constant.USERTOKEN}")
                        .build()
            } else {
                request.newBuilder()
                        .build()
            }
            chain.proceed(request)
        }


        private fun getRetrofit() = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(CustomCallAdapter())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build()

        private fun getHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            client = if (BuildConfig.DEBUG) {
                OkHttpClient.Builder().addInterceptor(headerInterceptor)
                        .addInterceptor(interceptor)
                        .connectTimeout(60, TimeUnit.MINUTES)
                        .readTimeout(60, TimeUnit.MINUTES)
                        .writeTimeout(60, TimeUnit.MINUTES).build()
            } else {
                OkHttpClient.Builder().addInterceptor(headerInterceptor)
                        .addInterceptor(interceptor)
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS).build()
            }
            return client
        }

        fun <T> getRetrofitService(serviceType : Class<T>): T {
            return getRetrofit().create(serviceType)
        }
    }
}