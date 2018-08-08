package com.fugenx.newproject.util

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.constraint.BuildConfig
import android.support.multidex.MultiDexApplication
import com.fugenx.newproject.apipresenter.RestApi
import com.fugenx.newproject.network.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class AppController : MultiDexApplication(), Application.ActivityLifecycleCallbacks {
    companion object {
        val TAG: String = "AppController"
        lateinit var mInstance: AppController
        lateinit var service : RestApi

    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        //Fabric.with(this, Crashlytics())
        createRetrofitObj()
        registerActivityLifecycleCallbacks(this)
    }


    fun createRetrofitObj() {
        val retrofit = Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(getRequestHeader())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service =retrofit.create(RestApi::class.java)
    }

    fun getRequestHeader(): OkHttpClient {
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClient.readTimeout(10, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(10, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            //Stetho.initializeWithDefaults(this)
            val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            //okHttpClient.addNetworkInterceptor(StethoInterceptor())
            okHttpClient.addInterceptor(logging)
        }
        return okHttpClient.build()
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {

       // Crashlytics.getInstance().crash() // Force a crash
    }

    override fun onActivityPaused(activity: Activity?) {

    }

    override fun onActivityResumed(activity: Activity?) {

    }

    override fun onActivityStarted(activity: Activity?) {

    }

    override fun onActivityDestroyed(activity: Activity?) {

    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

    }

    override fun onActivityStopped(activity: Activity?) {

    }


}