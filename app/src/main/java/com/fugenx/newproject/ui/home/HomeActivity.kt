package com.fugenx.newproject.ui.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.tapanjoshi.demoapplication.CustomAdapter
import com.fugenx.newproject.R
import com.fugenx.newproject.ui.create.CreateActivity
import com.fugenx.newproject.ui.home.model.HomeResponse
import com.fugenx.newproject.ui.home.model.UpdateRequest
import com.fugenx.newproject.ui.home.model.UpdateResponse
import kotlinx.android.synthetic.main.activity_homectivity.*
import kotlinx.android.synthetic.main.floating_layout.*


class HomeActivity : AppCompatActivity() ,IHomeView {


    lateinit var presenter: HomePresenter
    private var classesList: ArrayList<HomeResponse.Data>? = null
    lateinit var updateRequest: UpdateRequest

    private lateinit var customAdapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homectivity)
        //init()

        presenter = HomePresenter(this)
        presenter.doRegister()


        fab.setOnClickListener { view ->
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
        }

    }
    /*private fun init(){
        editText.setText("")
        editText.setText("")
        button.setOnClickListener(View.OnClickListener {
            updateRequest = UpdateRequest(name = editText.text.toString(), job = editText2.text.toString())
            presenter.doRegisterUpdate(updateRequest)
    })


    }*/
    override fun showResponse(homeResponse: HomeResponse) {

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        classesList =homeResponse.data

        customAdapter = CustomAdapter(this, classesList)
        recyclerView.adapter = customAdapter
        customAdapter.addClasses(classesList)

    }
    override fun showUpdateResponse(updateResponse: UpdateResponse) {
        if (updateResponse != null) {
            Toast.makeText(applicationContext, updateResponse.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun showError(responseError: Throwable) {

        Toast.makeText(applicationContext,responseError.toString(),Toast.LENGTH_SHORT).show()

    }

}
