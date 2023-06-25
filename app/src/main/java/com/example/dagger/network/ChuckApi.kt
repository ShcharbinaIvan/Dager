package com.example.dagger.network

import com.example.dagger.model.ChuckResponse
import retrofit2.Response
import retrofit2.http.GET

interface ChuckApi {

    @GET("jokes/random")
    suspend fun getChuckUrl(): Response<ChuckResponse>
}