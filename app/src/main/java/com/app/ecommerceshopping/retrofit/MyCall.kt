package com.app.todo.retrofit

interface MyCall<T> {

    fun cancel()

    fun enqueue(callback: MyCallback<T>)

}