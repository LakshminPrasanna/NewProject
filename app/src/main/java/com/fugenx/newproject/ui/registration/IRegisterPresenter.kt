package com.fugenx.newproject.ui.registration

import com.fugenx.newproject.ui.registration.model.RegisterRequest

interface IRegisterPresenter {
    fun doRegister(registerRequest: RegisterRequest)
}