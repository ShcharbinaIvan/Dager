package com.example.dagger.ui.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger.model.ChuckResponse
import com.example.dagger.repository.ChuckRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondViewModel(
    private val repository: ChuckRepository
) : ViewModel() {

    val chuck = MutableLiveData<ChuckResponse>()

    fun getChuck() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getChuck()
            if (response.isSuccessful) {
                chuck.postValue(response.body())
            }
        }
    }

}