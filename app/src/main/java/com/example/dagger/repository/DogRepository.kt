package com.example.dagger.repository

import com.example.dagger.network.DogApi
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val dogApi: DogApi
) {

    suspend fun getDogImage() = dogApi.getDogUrl()

}