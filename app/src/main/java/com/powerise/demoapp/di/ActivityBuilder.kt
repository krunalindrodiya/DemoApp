package com.powerise.demoapp.di

import android.app.Activity
import com.powerise.demoapp.splash.SplashActivity
import com.powerise.demoapp.splash.di.SplashComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


/**
 * Created by Krunal on 04-06-2018.
 */
@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(SplashActivity::class)
    abstract fun bindSplashActivity(builder: SplashComponent.Builder): AndroidInjector.Factory<out Activity>

//    @ContributesAndroidInjector
//    abstract fun bindMainActivity(): SplashActivity

}