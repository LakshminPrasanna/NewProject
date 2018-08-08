package com.fugenx.newproject.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fugenx.newproject.R
import com.fugenx.newproject.ui.create.CreateActivity
import com.fugenx.newproject.ui.delete.DeleteActivity
import com.fugenx.newproject.ui.home.HomeActivity
import com.fugenx.newproject.ui.login.model.LoginRequest
import com.fugenx.newproject.ui.login.model.LoginResponse
import com.fugenx.newproject.ui.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() ,ILoginView{

    lateinit var presenter: LoginPresenter
    lateinit var loginRequest: LoginRequest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()

    }

    private fun init() {

        et_email.setText("peter@klaven")
        et_password.setText("cityslicka")

        presenter = LoginPresenter(this)

        login_button.setOnClickListener(View.OnClickListener {
            loginRequest = LoginRequest(email = et_email.text.toString(), password = et_password.text.toString())
            presenter.doRegister(loginRequest)
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        })

        register_button.setOnClickListener(View.OnClickListener {
            val intent =Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        })
       /* delete_button.setOnClickListener {
            val intent =Intent(this,DeleteActivity::class.java)
            startActivity(intent)
        }*/
    }
    override fun showResponse(loginResponse: LoginResponse) {
        if (loginResponse != null) {
            Toast.makeText(applicationContext, loginResponse.token, Toast.LENGTH_SHORT).show()
        }

    }

    override fun showError(responseError: Throwable) {
        Toast.makeText(applicationContext, responseError.toString(), Toast.LENGTH_SHORT).show()

    }
}
