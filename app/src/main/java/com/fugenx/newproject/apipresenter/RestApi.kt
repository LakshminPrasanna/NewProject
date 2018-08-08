package com.fugenx.newproject.apipresenter

import com.fugenx.newproject.network.ApiConstants
import com.fugenx.newproject.ui.create.model.CreateRequest
import com.fugenx.newproject.ui.create.model.CreateResponse
import com.fugenx.newproject.ui.delete.model.DeleteResponse
import com.fugenx.newproject.ui.home.model.HomeResponse
import com.fugenx.newproject.ui.home.model.UpdateRequest
import com.fugenx.newproject.ui.home.model.UpdateResponse
import com.fugenx.newproject.ui.login.model.LoginRequest
import com.fugenx.newproject.ui.login.model.LoginResponse
import com.fugenx.newproject.ui.registration.model.RegisterRequest
import com.fugenx.newproject.ui.registration.model.RegisterResponse
import retrofit2.Call
import retrofit2.http.*

interface RestApi {
    @POST(ApiConstants.LOGIN)
    fun callRegisterApi(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST(ApiConstants.REGISTRATION)
    fun callRegisterApi(@Body registerRequest: RegisterRequest): Call<RegisterResponse>

    @GET(ApiConstants.HOMESERVICE)
    fun callHomeServiceApi(): Call<HomeResponse>

    @PUT(ApiConstants.UPDATE)
    fun callUpdateApi(@Body updateRequest: UpdateRequest): Call<UpdateResponse>

    @POST(ApiConstants.CREATE)
    fun callCreateApi(@Body createRequest: CreateRequest): Call<CreateResponse>

    @DELETE(ApiConstants.DELETE)
    fun callDeleteApi(): Call<DeleteResponse>


}