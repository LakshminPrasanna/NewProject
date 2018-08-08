package com.fugenx.newproject.ui.home.model


data class HomeResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: ArrayList<Data>
) {

    data class Data(
        val id: Int,
        val first_name: String,
        val last_name: String,
        val avatar: String
    )
}