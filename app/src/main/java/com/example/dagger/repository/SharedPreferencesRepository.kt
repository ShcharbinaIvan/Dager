package com.example.dagger.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

private const val SHARED_PREFERENCE_FILE = "sharedPreferenceFile"
private const val FIRST_OPEN = "firstOpen"

@Singleton
class SharedPreferencesRepository @Inject constructor(
    private val context: Context
) {

    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)

    fun setFirstOpenApp(firstOpen: Boolean) {
        sharedPreferences.edit {
            putBoolean(FIRST_OPEN, firstOpen)
        }
    }

    fun firstOpenApp(): Boolean {
        return sharedPreferences.getBoolean(FIRST_OPEN, true)
    }

}