package com.powerise.demoapp

import android.app.Activity
import android.app.Application
import com.powerise.demoapp.di.DaggerAppComponent
import com.powerise.demoapp.utils.LogTree
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Krunal on 04-06-2018.
 */
class DemoApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree());
        } else {
            Timber.plant(LogTree())
        }
    }
}