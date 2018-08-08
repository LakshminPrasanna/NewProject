package com.fugenx.newproject.ui.create

import com.fugenx.newproject.ui.create.model.CreateRequest
import com.fugenx.newproject.ui.home.model.UpdateRequest
import com.fugenx.newproject.ui.login.model.LoginRequest

interface ICreatePresenter {

    fun doRegister(createRequest: CreateRequest)
    fun doRegisterUpdate(updateRequest: UpdateRequest)
}