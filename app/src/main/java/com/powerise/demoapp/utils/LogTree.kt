package com.powerise.demoapp.utils

import android.util.Log
import timber.log.Timber

/**
 * Created by Krunal on 09-06-2018.
 */
class LogTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        } else {
            //report as crash.
        }
    }
}