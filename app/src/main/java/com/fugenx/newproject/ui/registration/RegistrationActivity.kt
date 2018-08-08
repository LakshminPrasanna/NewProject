package com.fugenx.newproject.ui.registration

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fugenx.newproject.R
import com.fugenx.newproject.ui.registration.model.RegisterRequest
import com.fugenx.newproject.ui.registration.model.RegisterResponse
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() ,IRegisterView{

    lateinit var presenter: RegistrationPresenter
    lateinit var registerRequest: RegisterRequest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        init()
    }
    private fun init()
    {
        et_emailid.setText("")
        et_pass.setText("")

        presenter = RegistrationPresenter(this)
        button_register.setOnClickListener {
            registerRequest = RegisterRequest(email = et_emailid.text.toString(),password = et_pass.text.toString())
            presenter.doRegister(registerRequest)

        }
    }
    override fun showResponse(registerResponse:RegisterResponse) {
        if (registerResponse!=null)
        {
            Toast.makeText(applicationContext, registerResponse.token, Toast.LENGTH_SHORT).show()
        }

    }

    override fun showError(responseError: Throwable) {
        Toast.makeText(applicationContext, responseError.toString(), Toast.LENGTH_SHORT).show()

    }
}
