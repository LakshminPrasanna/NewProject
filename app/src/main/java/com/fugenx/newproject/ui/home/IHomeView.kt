package com.fugenx.newproject.ui.home

import com.fugenx.newproject.ui.home.model.HomeResponse
import com.fugenx.newproject.ui.home.model.UpdateResponse

interface IHomeView {

    fun showResponse(homeResponse: HomeResponse)
    fun showError(responseError: Throwable)
    fun showUpdateResponse(updateResponse: UpdateResponse)
}