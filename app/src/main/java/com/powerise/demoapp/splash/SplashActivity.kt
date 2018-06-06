package com.powerise.demoapp.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.powerise.demoapp.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), ISplashView {

    @Inject
    lateinit var splashPresenter: ISplashPresenter

//    @Inject
//    lateinit var splashApi : SplashApi

    override fun onResponse() {

    }

    override fun onFailure() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (splashPresenter != null) {
            Log.d("SplashActivity", "preseneter is not null");
        } else {
            Log.d("SplashActivity", "preseneter is null");
        }

    }
}
