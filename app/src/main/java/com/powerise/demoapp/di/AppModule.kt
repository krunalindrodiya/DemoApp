package com.powerise.demoapp.di

import android.app.Application
import android.content.Context
import com.powerise.demoapp.MainActivityComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Krunal on 04-06-2018.
 */
@Module(subcomponents = arrayOf(MainActivityComponent::class))
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}