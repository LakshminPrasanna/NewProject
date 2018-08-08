package com.fugenx.newproject.network

class ApiConstants {

    companion object {
        val BASE_URL: String = "https://reqres.in/"
        const val LOGIN: String = "api/login"
        const val REGISTRATION : String = "api/register"
        const val HOMESERVICE : String = "api/users?page=2"
        const val UPDATE : String = "api/users/2"
        const val CREATE : String = "api/users"
        const val DELETE : String = "api/users/2"
    }
}