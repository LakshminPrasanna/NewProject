package com.fugenx.newproject.ui.registration

import com.fugenx.newproject.apipresenter.ApiResponsePresenter
import com.fugenx.newproject.interfaces.IResponseInterface
import com.fugenx.newproject.network.ApiRequestTypes
import com.fugenx.newproject.ui.registration.model.RegisterRequest
import com.fugenx.newproject.ui.registration.model.RegisterResponse
import com.fugenx.newproject.util.AppController
import retrofit2.Call
import retrofit2.Response

class RegistrationPresenter constructor(var view: IRegisterView) : IRegisterPresenter, IResponseInterface {

    private var iRequest: ApiResponsePresenter

    init {
        this.view = view
        this.iRequest = ApiResponsePresenter(this)
    }


    override fun doRegister(registerRequest: RegisterRequest) {

        iRequest?.callApi(AppController.service.callRegisterApi(registerRequest), ApiRequestTypes.REGISTER)

    }

    override fun <T> onResponseSuccess(call: Call<T>?, response: Response<T>, retype: String) {
        if (response?.isSuccessful && response.body() != null) {
            when (retype) {
                ApiRequestTypes.REGISTER -> {
                    view.showResponse(response.body() as RegisterResponse)
                }
            }
        }
    }

    override fun <T> onResponseFailure(call: Call<T>?, responseError: Throwable, retype: String) {
        view.showError(responseError)
    }
}