package com.example.awesomeapp.di.modules

import android.app.Application
import com.example.awesomeapp.AwesomeApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }
}