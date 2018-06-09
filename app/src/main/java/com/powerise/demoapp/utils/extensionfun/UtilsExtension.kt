package com.powerise.demoapp.utils.extensionfun

import android.content.Context
import android.net.ConnectivityManager


/**
 * Created by Krunal on 09-06-2018.
 */
fun Context.isInternet(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo != null
}
