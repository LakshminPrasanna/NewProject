package com.fugenx.newproject.ui.login

import com.fugenx.newproject.ui.login.model.LoginRequest

interface ILoginPresenter {
    fun doRegister(loginRequest: LoginRequest)
}