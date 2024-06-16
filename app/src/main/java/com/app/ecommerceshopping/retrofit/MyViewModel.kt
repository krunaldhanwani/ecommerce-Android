package com.app.todo.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MyViewModel : ViewModel() {

    var isLoading = MutableLiveData(false)
    var errorListener = MutableLiveData<MyErrorModel>()
    var networkErrorListener = MutableLiveData<MyNetworkError>()
    var authErrorListener = MutableLiveData<MyAuthError>()

    fun observeLoading() = isLoading
    fun observeError() = errorListener
    fun observeNetworkError() = networkErrorListener
    fun observeAuthError() = authErrorListener
}

data class MyErrorModel(
    val message: String,
    val statusCode: Int
)

data class MyNetworkError(
    val message: String
)

data class MyAuthError(
    val message: String
)