package com.example.dagger.di

import com.example.dagger.network.ChuckApi
import com.example.dagger.network.DogApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideDogApi(): DogApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/")
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(DogApi::class.java)
    }

    @Provides
    @Singleton
    fun provideChuckApi(): ChuckApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .client(
                OkHttpClient().newBuilder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ChuckApi::class.java)
    }

}