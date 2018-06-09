package com.powerise.demoapp.splash

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.powerise.demoapp.R
import com.powerise.demoapp.databinding.ActivitySplashBinding
import com.powerise.demoapp.home.HomeActivity
import com.powerise.demoapp.splash.models.AlbumModel
import com.powerise.demoapp.splash.viewmodel.SplashViewModel
import com.powerise.demoapp.utils.BundleKey
import com.powerise.demoapp.utils.extensionfun.isInternet
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), ISplashView {

    @Inject
    lateinit var splashPresenter: ISplashPresenter
    private val viewModel = SplashViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)
        binding.model = viewModel

        if (isInternet()) {
            splashPresenter?.getApiCall()
        } else {
            viewModel.error = getString(R.string.no_internet)
            progressShow(false)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        splashPresenter?.setNullView()
    }


    private fun progressShow(isProgress: Boolean) {
        viewModel.isProgress = isProgress
        viewModel.notifyChange()
    }

    override fun onResponse(response: ArrayList<AlbumModel>?) {
        if (response?.isNotEmpty() == true) {
            val intent = Intent(this@SplashActivity, HomeActivity::class.java)
            intent.putExtra(BundleKey.ALBUM_RESPONSE, response)
            startActivity(intent)
            finish()
        } else {
            viewModel.error = getString(R.string.message_error)
        }
        progressShow(false)
    }

    override fun onFailure(t: Throwable?) {
        viewModel.error = t?.message ?: getString(R.string.message_error)
        Timber.d("Error=" + t?.toString())
        progressShow(false)
    }
}
