package com.powerise.demoapp.splash

import com.powerise.demoapp.splash.models.AlbumModel
import com.powerise.demoapp.splash.webapi.SplashApi
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by Krunal on 05-06-2018.
 */
class SplashPresenter(private val api: SplashApi, private var view: ISplashView?) : ISplashPresenter {
    override fun getApiCall() {
        view?.let {
            api.getFeed(1, 5).enqueue(object : Callback<ArrayList<AlbumModel>> {
                override fun onFailure(call: Call<ArrayList<AlbumModel>>?, t: Throwable?) {
                    view?.onFailure(t)
                }

                override fun onResponse(call: Call<ArrayList<AlbumModel>>?, response: retrofit2.Response<ArrayList<AlbumModel>>?) {
                    response?.let {
                        view?.onResponse(it.body())
                    } ?: view?.onFailure(Exception("Response empty"))

                }
            })
        }
    }

    override fun setNullView() {
        view = null
    }
}