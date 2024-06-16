package com.app.todo.retrofit

import retrofit2.Response


interface MyCallback<T> {

    fun success(response: Response<T>)

    fun serverError(error: String, statusCode: Int)

    fun networkError()

    fun authError()

}