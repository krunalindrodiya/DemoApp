package com.powerise.demoapp

import android.app.Application
import com.powerise.demoapp.di.DaggerAppComponent

/**
 * Created by Krunal on 04-06-2018.
 */
class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

}