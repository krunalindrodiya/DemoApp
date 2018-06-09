package com.powerise.demoapp.splash

import com.powerise.demoapp.splash.models.AlbumModel

/**
 * Created by Krunal on 05-06-2018.
 */
interface ISplashView {

    fun onResponse(response: ArrayList<AlbumModel>?)

    fun onFailure(t: Throwable?)

}