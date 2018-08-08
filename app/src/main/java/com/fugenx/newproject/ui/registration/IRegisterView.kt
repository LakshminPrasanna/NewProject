package com.fugenx.newproject.ui.registration

import com.fugenx.newproject.ui.registration.model.RegisterResponse

interface IRegisterView {
    fun showResponse(registerResponse: RegisterResponse)
    fun showError(responseError: Throwable)
}