package com.powerise.demoapp.splash.di

import com.powerise.demoapp.splash.ISplashPresenter
import com.powerise.demoapp.splash.ISplashView
import com.powerise.demoapp.splash.SplashActivity
import com.powerise.demoapp.splash.SplashPresenter
import com.powerise.demoapp.splash.webapi.SplashApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


/**
 * Created by Krunal on 05-06-2018.
 */
@Module
class SplashModule {

    @Provides
    fun provideSplashView(splashActivity: SplashActivity): ISplashView {
        return splashActivity
    }

    @Provides
    fun provideSplashApi(retrofit: Retrofit): SplashApi {
        return retrofit.create(SplashApi::class.java)
    }

    @Provides
    fun provideSplashPresenter(api: SplashApi, view: ISplashView): ISplashPresenter {
        return SplashPresenter(api, view)
    }

}