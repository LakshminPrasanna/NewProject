package com.fugenx.newproject.ui.login

import com.fugenx.newproject.apipresenter.ApiResponsePresenter
import com.fugenx.newproject.interfaces.IResponseInterface
import com.fugenx.newproject.network.ApiRequestTypes
import com.fugenx.newproject.ui.login.model.LoginRequest
import com.fugenx.newproject.ui.login.model.LoginResponse
import com.fugenx.newproject.util.AppController
import retrofit2.Call
import retrofit2.Response

class LoginPresenter constructor(var view: ILoginView) : ILoginPresenter, IResponseInterface {

    private var iRequest: ApiResponsePresenter

    init {
        this.view = view
        this.iRequest = ApiResponsePresenter(this)
    }


    override fun doRegister(loginRequest: LoginRequest) {
        iRequest?.callApi(AppController.service.callRegisterApi(loginRequest), ApiRequestTypes.LOGIN)

    }

    override fun <T> onResponseSuccess(call: Call<T>?, response: Response<T>, retype: String) {
        if (response?.isSuccessful && response.body() != null) {
            when (retype) {
                ApiRequestTypes.LOGIN -> {
                    view.showResponse(response.body() as LoginResponse)
                }
            }
        }
    }

    override fun <T> onResponseFailure(call: Call<T>?, responseError: Throwable, retype: String) {
        view.showError(responseError)

    }


}