package com.example.awesomeapp.di.components

import com.example.awesomeapp.di.modules.ApiModule
import com.example.awesomeapp.di.modules.AppModule
import com.example.awesomeapp.di.modules.CoroutineModule
import com.example.awesomeapp.di.modules.ViewModelModule
import com.example.awesomeapp.ui.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, ApiModule::class, ViewModelModule::class, CoroutineModule::class])
interface ApiComponent {
    fun inject(mainActivity: MainActivity)
}