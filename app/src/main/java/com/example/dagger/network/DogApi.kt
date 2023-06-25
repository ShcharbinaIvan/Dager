package com.example.dagger.network

import com.example.dagger.model.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogApi {

    @GET("image/random")
    suspend fun getDogUrl(): Response<DogResponse>

}