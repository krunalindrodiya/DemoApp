package com.powerise.demoapp.splash.webapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Krunal on 05-06-2018.
 */
interface SplashApi {

    @GET("/users/{user}/repos")
    fun reposForUser(
            @Path("user") user: String
    ): Call<String>

}