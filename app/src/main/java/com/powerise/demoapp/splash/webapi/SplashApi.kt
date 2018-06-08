package com.powerise.demoapp.splash.webapi

import com.powerise.demoapp.splash.models.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Krunal on 05-06-2018.
 */
interface SplashApi {

    @GET("/feed/")
    fun getFeed(@Query("page") page: Int, @Query("count") count: Int): Call<ArrayList<Response>>

}