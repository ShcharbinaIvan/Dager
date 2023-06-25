package com.example.dagger.ui.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.dagger.repository.DogRepository
import javax.inject.Inject

class FirstViewModelFactory @Inject constructor(
    private val repository: DogRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return FirstViewModel(repository) as T
    }
}