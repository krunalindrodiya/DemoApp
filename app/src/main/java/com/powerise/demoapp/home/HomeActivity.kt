package com.powerise.demoapp.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.powerise.demoapp.R
import com.powerise.demoapp.home.adapter.AlbumAdapter
import com.powerise.demoapp.splash.models.AlbumModel
import com.powerise.demoapp.utils.BundleKey
import kotlinx.android.synthetic.main.activity_home.*
import timber.log.Timber

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (intent?.hasExtra(BundleKey.ALBUM_RESPONSE) == true) {
            val response = intent.getParcelableArrayListExtra<AlbumModel>(BundleKey.ALBUM_RESPONSE)
            if (response?.isNotEmpty() == true) {
                setAdapter(response)
            } else {
                Timber.d("No record found.")
            }
        } else {
            Timber.d("Response empty.")
        }
    }
    
    private fun setAdapter(albumList: ArrayList<AlbumModel>) {
        val layoutManager = GridLayoutManager(this, 2)
        val adapter = AlbumAdapter(this, Glide.with(this), albumList)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter
    }

}
