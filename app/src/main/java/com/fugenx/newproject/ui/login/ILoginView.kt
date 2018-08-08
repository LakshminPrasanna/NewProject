package com.fugenx.newproject.ui.login

import com.fugenx.newproject.ui.login.model.LoginResponse

interface ILoginView {

    fun showResponse(loginResponse: LoginResponse)
    fun showError(responseError: Throwable)
}