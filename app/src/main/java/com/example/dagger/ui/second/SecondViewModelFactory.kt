package com.example.dagger.ui.second

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.dagger.repository.ChuckRepository
import javax.inject.Inject

class SecondViewModelFactory @Inject constructor(
    private val repository: ChuckRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return SecondViewModel(repository) as T
    }
}
