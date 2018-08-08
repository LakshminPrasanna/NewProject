package com.fugenx.newproject.interfaces

import retrofit2.Call

interface IRequestInterface {

    fun <T> callApi(call: Call<T>, reqType: String)
}
