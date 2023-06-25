package com.example.dagger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dagger.App
import com.example.dagger.R
import com.example.dagger.databinding.ActivityMainBinding
import com.example.dagger.repository.SharedPreferencesRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    private lateinit var binding: ActivityMainBinding

    override fun onStart() {
        super.onStart()
        App.applicationComponent?.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.my_nav_host_fragment)
        binding.bottomNavigation.setupWithNavController(navController)
        if (sharedPreferencesRepository.firstOpenApp()) {
            sharedPreferencesRepository.setFirstOpenApp(false)
        }
    }
}