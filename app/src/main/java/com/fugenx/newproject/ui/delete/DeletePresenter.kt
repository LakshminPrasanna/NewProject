package com.fugenx.newproject.ui.delete

import com.fugenx.newproject.apipresenter.ApiResponsePresenter
import com.fugenx.newproject.interfaces.IResponseInterface
import com.fugenx.newproject.network.ApiRequestTypes
import com.fugenx.newproject.ui.delete.model.DeleteResponse
import com.fugenx.newproject.ui.home.model.HomeResponse
import com.fugenx.newproject.util.AppController
import retrofit2.Call
import retrofit2.Response

class DeletePresenter constructor(var view :IDeleteView): IDeletePresenter ,IResponseInterface{

    private var iRequest: ApiResponsePresenter

    init {
        this.view = view
        this.iRequest = ApiResponsePresenter(this)
    }

    override fun doRegister() {
        iRequest?.callApi(AppController.service.callDeleteApi(), ApiRequestTypes.DELETE)

    }

    override fun <T> onResponseSuccess(call: Call<T>?, response: Response<T>, retype: String) {
        if (response?.isSuccessful && response.body() != null) {
            when (retype) {
                ApiRequestTypes.DELETE -> {
                    view.showResponse(response.body() as DeleteResponse)
                }
            }
        }
    }

    override fun <T> onResponseFailure(call: Call<T>?, responseError: Throwable, retype: String) {
        view.showError(responseError)

    }
}