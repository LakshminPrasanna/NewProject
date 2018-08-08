package com.fugenx.newproject.interfaces

import retrofit2.Call
import retrofit2.Response


interface IResponseInterface {
    fun <T> onResponseSuccess(call: Call<T>?, response: Response<T>, retype: String)
    fun <T> onResponseFailure(call: Call<T>?, responseError: Throwable, retype: String)

}