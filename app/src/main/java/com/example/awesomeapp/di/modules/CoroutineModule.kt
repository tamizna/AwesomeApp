package com.example.awesomeapp.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class CoroutineModule {

    @Provides
    fun provideDispatcher() : CoroutineDispatcher = Dispatchers.IO


}