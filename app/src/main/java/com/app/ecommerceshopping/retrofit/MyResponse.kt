package com.app.todo.retrofit

data class MyResponse<out T>(val status: ResponseStatus, val error: String, val statusCode: Int, val data: T?) {
    companion object {
        fun <T> success(data: T?): MyResponse<T> {
            return MyResponse(ResponseStatus.SUCCESS, "", 200, data)
        }

        fun <T> serverError(msg: String, statusCode: Int): MyResponse<T> {
            return MyResponse(ResponseStatus.SERVER_ERROR, msg, statusCode, null)
        }

        fun <T> internetError(): MyResponse<T> {
            return MyResponse(ResponseStatus.INTERNET_NOT_AVAILABLE, "Internet connection lost", 500, null)
        }

        fun <T> authError(msg: String): MyResponse<T> {
            return MyResponse(ResponseStatus.AUTH_ERROR, msg, 504, null)
        }
    }
}