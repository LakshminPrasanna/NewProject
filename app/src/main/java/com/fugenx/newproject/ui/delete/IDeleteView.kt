package com.fugenx.newproject.ui.delete

import com.fugenx.newproject.ui.delete.model.DeleteResponse
import com.fugenx.newproject.ui.home.model.HomeResponse

interface IDeleteView {
    fun showResponse(deleteResponse: DeleteResponse)
    fun showError(responseError: Throwable)
}