package com.fugenx.newproject.ui.delete

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fugenx.newproject.R
import com.fugenx.newproject.ui.delete.model.DeleteResponse


class DeleteActivity : AppCompatActivity(),IDeleteView {

    lateinit var presenter: DeletePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        presenter = DeletePresenter(this)
        presenter.doRegister()

    }


    override fun showResponse(deleteResponse: DeleteResponse) {
        if (deleteResponse != null) {
            Toast.makeText(applicationContext, deleteResponse.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun showError(responseError: Throwable) {
        Toast.makeText(applicationContext, responseError.toString(), Toast.LENGTH_SHORT).show()
    }

}
