package com.example.tapanjoshi.demoapplication

import android.content.Context
import android.content.Intent
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.fugenx.newproject.R
import com.fugenx.newproject.ui.create.CreateActivity
import com.fugenx.newproject.ui.home.model.HomeResponse


class CustomAdapter(private var context: Context?, private var classesList: ArrayList<HomeResponse.Data>?) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val inflatedView = parent.inflate(R.layout.layout_recycler, false)
        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(classesList!![position])
    }

    override fun getItemCount(): Int {
        return classesList!!.size
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    fun addClasses(classesList: ArrayList<HomeResponse.Data>?) {
        this.classesList = classesList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(value: HomeResponse.Data) {

            val textViewDescription = itemView.findViewById(R.id.tv_id) as TextView
            val textFirstName = itemView.findViewById(R.id.tv_first_name) as TextView
            val textLastName = itemView.findViewById(R.id.tv_last_name) as TextView
            val image = itemView.findViewById(R.id.img_holder) as ImageView
            textViewDescription.text = "" + value.id.toString()
            textFirstName.text = value.first_name
            textLastName.text = value.last_name
            //image.setImageResource(value.avatar.toInt())
            textViewDescription.setOnClickListener {
                var intent = Intent(itemView.context, CreateActivity::class.java)
                intent.putExtra("id", textViewDescription.text.toString())
                textViewDescription.context.startActivity(intent)
            }
            textFirstName.setOnClickListener {
                var intent1 = Intent(itemView.context, CreateActivity::class.java)
                intent1.putExtra("firstname", textFirstName.text.toString())
                textFirstName.context.startActivity(intent1)
            }

            textLastName.setOnClickListener {
                var intent2 = Intent(itemView.context, CreateActivity::class.java)
                intent2.putExtra("lastname", textLastName.text.toString())
                textLastName.context.startActivity(intent2)
            }


            }
        }
    }
