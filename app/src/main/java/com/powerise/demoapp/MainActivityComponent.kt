package com.powerise.demoapp

import dagger.Subcomponent
import dagger.android.AndroidInjector


/**
 * Created by Krunal on 04-06-2018.
 */
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}