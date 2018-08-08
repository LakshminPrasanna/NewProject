package com.fugenx.newproject.ui.create

import com.fugenx.newproject.apipresenter.ApiResponsePresenter
import com.fugenx.newproject.interfaces.IResponseInterface
import com.fugenx.newproject.network.ApiRequestTypes
import com.fugenx.newproject.ui.create.model.CreateRequest
import com.fugenx.newproject.ui.create.model.CreateResponse
import com.fugenx.newproject.ui.home.model.UpdateRequest
import com.fugenx.newproject.ui.home.model.UpdateResponse
import com.fugenx.newproject.util.AppController
import retrofit2.Call
import retrofit2.Response

class CreatePresenter constructor(var view: ICreateView) : ICreatePresenter, IResponseInterface {

    private var iRequest: ApiResponsePresenter

    init {
        this.view = view
        this.iRequest = ApiResponsePresenter(this)
    }
    override fun doRegister(createRequest: CreateRequest) {
        iRequest?.callApi(AppController.service.callCreateApi(createRequest), ApiRequestTypes.CREATE)
    }
    override fun doRegisterUpdate(updateRequest: UpdateRequest) {
        iRequest?.callApi(AppController.service.callUpdateApi(updateRequest), ApiRequestTypes.UPDATE)
    }


    override fun <T> onResponseSuccess(call: Call<T>?, response: Response<T>, retype: String) {
        if (response?.isSuccessful && response.body() != null) {
            when (retype) {
                ApiRequestTypes.CREATE -> {
                    view.showResponse(response.body() as CreateResponse)
                }
                ApiRequestTypes.UPDATE -> {
                    view.showUpdateResponse(response.body() as UpdateResponse)
                }
            }
        }

    }
    override fun <T> onResponseFailure(call: Call<T>?, responseError: Throwable, retype: String) {
        view.showError(responseError)
    }
}