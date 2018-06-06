package com.powerise.demoapp.splash.di

import com.powerise.demoapp.splash.SplashActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Krunal on 05-06-2018.
 */
@Subcomponent(modules = arrayOf(SplashModule::class))
interface SplashComponent : AndroidInjector<SplashActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SplashActivity>()
}