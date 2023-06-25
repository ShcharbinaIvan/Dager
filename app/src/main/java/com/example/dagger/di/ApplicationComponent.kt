package com.example.dagger.di

import com.example.dagger.ui.MainActivity
import com.example.dagger.ui.first.FirstFragment
import com.example.dagger.ui.second.SecondFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
abstract class ApplicationComponent {

    abstract fun inject(firstFragment: FirstFragment)
    abstract fun inject(secondFragment: SecondFragment)
    abstract fun inject(mainActivity: MainActivity)

}