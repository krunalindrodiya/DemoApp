package com.powerise.demoapp.splash

import android.util.Log
import com.powerise.demoapp.splash.models.Response
import com.powerise.demoapp.splash.webapi.SplashApi
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by Krunal on 05-06-2018.
 */
class SplashPresenter(private val api: SplashApi, private var view: ISplashView?) : ISplashPresenter {
    override fun getApiCall() {
        view?.let {
            api.getFeed(1, 5).enqueue(object : Callback<ArrayList<Response>> {
                override fun onFailure(call: Call<ArrayList<Response>>?, t: Throwable?) {
                    Log.d("SplashPresenter", "onFailure=" + t.toString())
                    view?.onFailure()
                }

                override fun onResponse(call: Call<ArrayList<Response>>?, response: retrofit2.Response<ArrayList<Response>>?) {
                    Log.d("SplashPresenter", "onSuccess")
                    view?.onResponse()
                }
            })
        }
    }

    override fun setNullView() {
        view = null
    }
}