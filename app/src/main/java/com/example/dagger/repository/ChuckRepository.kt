package com.example.dagger.repository

import com.example.dagger.network.ChuckApi
import javax.inject.Inject

class ChuckRepository @Inject constructor(
    private val chuckApi: ChuckApi
) {

    suspend fun getChuck() = chuckApi.getChuckUrl()

}