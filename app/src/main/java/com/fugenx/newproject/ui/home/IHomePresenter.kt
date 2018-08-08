package com.fugenx.newproject.ui.home

import com.fugenx.newproject.ui.home.model.UpdateRequest

interface IHomePresenter {

    fun doRegister()
    fun doRegisterUpdate(updateRequest: UpdateRequest)


}