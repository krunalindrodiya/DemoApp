package com.powerise.demoapp.splash

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.powerise.demoapp.R
import com.powerise.demoapp.databinding.ActivitySplashBinding
import com.powerise.demoapp.splash.viewmodel.SplashViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), ISplashView {

    @Inject
    lateinit var splashPresenter: ISplashPresenter
    private val viewModel = SplashViewModel()

    override fun onResponse() {
        Log.d("SplashActivity", "onResponse");
        progressShow(false)
    }

    override fun onFailure() {
        Log.d("SplashActivity", "onFailure");
        progressShow(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)

        binding.model = viewModel

        if (splashPresenter != null) {
            splashPresenter.getApiCall()
            progressShow(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        splashPresenter.setNullView()
    }


    private fun progressShow(isProgress: Boolean) {
        viewModel.isProgress = isProgress
        viewModel.notifyChange()
    }

}
