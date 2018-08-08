package com.fugenx.newproject.ui.create

import com.fugenx.newproject.ui.create.model.CreateResponse
import com.fugenx.newproject.ui.home.model.UpdateResponse

interface ICreateView {

    fun showResponse(createResponse: CreateResponse)
    fun showError(responseError: Throwable)
    fun showUpdateResponse(updateResponse: UpdateResponse)
}