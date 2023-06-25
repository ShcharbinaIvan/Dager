package com.example.dagger.ui.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger.model.DogResponse
import com.example.dagger.repository.DogRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstViewModel(
    private val repository: DogRepository
) : ViewModel() {

    val dog = MutableLiveData<String>()

    fun getDog() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getDogImage()
            if (response.isSuccessful) {
                dog.postValue(response.body()?.message)
            }
        }
    }

}