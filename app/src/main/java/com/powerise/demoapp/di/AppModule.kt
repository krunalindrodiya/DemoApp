package com.powerise.demoapp.di

import com.powerise.demoapp.splash.di.SplashComponent
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Krunal on 04-06-2018.
 */
@Module(subcomponents = arrayOf(SplashComponent::class))
class AppModule {

    @Provides
    fun provideLoggingIntercepter() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor) = OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder().baseUrl("http://www.google.com/").addConverterFactory(GsonConverterFactory.create()).client(client).build()

}