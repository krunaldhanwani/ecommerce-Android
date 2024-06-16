package com.app.todo.retrofit

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class CustomCallAdapter : CallAdapter.Factory() {

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (getRawType(returnType) != MyCall::class.java) {
            return null
        }
        val responseType = getParameterUpperBound(0, returnType as ParameterizedType)
        return ErrorHandlingCallAdapter<Any>(responseType)
    }


    private class ErrorHandlingCallAdapter<R> constructor(private val responseType: Type) : CallAdapter<R, MyCall<R>> {
        override fun responseType(): Type {
            return responseType
        }

        override fun adapt(call: Call<R>): MyCall<R> {
            return MyCallAdapter(call)
        }
    }
}