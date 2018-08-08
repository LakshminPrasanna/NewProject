package com.fugenx.newproject.ui.create

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fugenx.newproject.R
import com.fugenx.newproject.ui.create.model.CreateRequest
import com.fugenx.newproject.ui.create.model.CreateResponse
import com.fugenx.newproject.ui.home.model.UpdateRequest
import com.fugenx.newproject.ui.home.model.UpdateResponse
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity(),ICreateView {

    lateinit var presenter: CreatePresenter
    lateinit var createRequest: CreateRequest
    lateinit var updateRequest : UpdateRequest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val i = getIntent()
        val id = i.getStringExtra("id")
        val firstname = i.getStringExtra("firstname")
        val lastname = i.getStringExtra("lastname")
        editText3.setText(id)
        editText4.setText(firstname)
        init()

    }
    private fun init()
    {

        presenter = CreatePresenter(this)
        btn_create.setOnClickListener {
            createRequest = CreateRequest(name = editText3.text.toString(),job = editText4.text.toString())
            presenter.doRegister(createRequest)

        }
        btn_update.setOnClickListener(View.OnClickListener {
            updateRequest = UpdateRequest(name = editText3.text.toString(), job = editText4.text.toString())
            presenter.doRegisterUpdate(updateRequest)
        })

    }

    override fun showResponse(createResponse: CreateResponse) {
        if (createResponse != null) {
            Toast.makeText(applicationContext, createResponse.toString(), Toast.LENGTH_SHORT).show()
        }
    }
    override fun showUpdateResponse(updateResponse: UpdateResponse) {
        if (updateResponse != null) {
            Toast.makeText(applicationContext, updateResponse.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun showError(responseError: Throwable) {

        Toast.makeText(applicationContext, responseError.toString(), Toast.LENGTH_SHORT).show()

    }
}
