package com.powerise.demoapp.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.powerise.demoapp.R
import com.powerise.demoapp.splash.models.AlbumModel
import com.powerise.demoapp.utils.BundleKey
import timber.log.Timber

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (intent?.hasExtra(BundleKey.ALBUM_RESPONSE) == true) {
            val response = intent.getParcelableArrayListExtra<AlbumModel>(BundleKey.ALBUM_RESPONSE)
            Timber.d("response arrived.")
        } else {
            Timber.d("Response empty.")
        }
    }
}
